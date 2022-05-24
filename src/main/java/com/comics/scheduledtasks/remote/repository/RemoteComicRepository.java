package com.comics.scheduledtasks.remote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.comics.scheduledtasks.entities.ComicEntity;

public interface RemoteComicRepository extends JpaRepository<ComicEntity, Integer>{

}
