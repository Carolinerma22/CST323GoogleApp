package com.gcu.milestone.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.gcu.milestone.entity.AlbumEntity;

public interface AlbumsRepository extends CrudRepository<AlbumEntity, Long> {

}