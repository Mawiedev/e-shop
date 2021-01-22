package com.mawie.Eshop.config;

import com.mawie.Eshop.model.entities.Watch;
import com.mawie.Eshop.repositories.WatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

@Configuration
public class LoadDatabase
{
  
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase( WatchRepository watchRepository) {
  String fountain = "GIF89a";
  
    return args -> {
      log.info("Preloading " + watchRepository.save(new Watch("Prim", 25000, "A watch with a water fountain picture", fountain.getBytes( StandardCharsets.UTF_8 ))));
    };
  }
}

