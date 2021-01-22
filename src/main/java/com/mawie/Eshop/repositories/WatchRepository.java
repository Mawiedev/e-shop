package com.mawie.Eshop.repositories;

import com.mawie.Eshop.model.entities.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WatchRepository extends JpaRepository< Watch, Long >
{

}
