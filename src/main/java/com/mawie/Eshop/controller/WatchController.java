package com.mawie.Eshop.controller;

import com.mawie.Eshop.exception.WatchNotFoundException;
import com.mawie.Eshop.exception.WatchValidationException;
import com.mawie.Eshop.model.assembler.WatchModelAssembler;
import com.mawie.Eshop.model.entities.Watch;
import com.mawie.Eshop.service.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class WatchController
{
    @Autowired
    private WatchService watchService;
    
    @Autowired
    private WatchModelAssembler watchModelAssembler;
    
    //menu
    @RequestMapping("/")
    public String index()
    {
          return "Hello world! :)";
    }
    
    //Get all watches
    @GetMapping(value = "/watches",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public CollectionModel<EntityModel<Watch>> all()
    {
        List<EntityModel<Watch>> watches = watchService
                .getAll()
                .stream()
                .map(watchModelAssembler::toModel)
                .collect( Collectors.toList());
        return CollectionModel.of(watches, linkTo(methodOn(WatchController.class).all()).withSelfRel());
    }

    //Get one watch
    @GetMapping(value = "/watch/{id}",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public EntityModel<Watch> one( @PathVariable long id )
    {
        Watch watch = watchService.getOne(id)
          .orElseThrow(() -> new WatchNotFoundException(id));
        return watchModelAssembler.toModel( watch );
    }
    
    //Post one watch
    @PostMapping(value = "/addwatch",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> newWatch( @Valid @RequestBody Watch newWatch, Errors errors)
    {
        if(errors.hasErrors())
        {
            throw new WatchValidationException(errors);
        }
        EntityModel<Watch> entityModel = watchModelAssembler.toModel( watchService.save( newWatch ) );
        return ResponseEntity
                .created( entityModel.getRequiredLink( IanaLinkRelations.SELF ).toUri() )
                .body( entityModel );
    }
}
