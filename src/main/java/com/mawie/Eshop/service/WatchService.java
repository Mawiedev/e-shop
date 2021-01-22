package com.mawie.Eshop.service;

import com.mawie.Eshop.model.entities.Watch;
import com.mawie.Eshop.repositories.WatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WatchService
{
    @Autowired
    private WatchRepository watchRepository;
    
    public List<Watch> getAll()
    {
        return watchRepository.findAll();
    }
    
    public Optional< Watch > getOne( long id)
    {
        return watchRepository.findById( id );
    }
    
    public Watch save( Watch watch)
    {
        return watchRepository.save( watch );
    }
    
}
