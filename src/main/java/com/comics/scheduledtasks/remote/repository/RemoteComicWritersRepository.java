package com.comics.scheduledtasks.remote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.ComicWritersEntity;
import com.comics.scheduledtasks.entities.ComicWritersID;

public interface RemoteComicWritersRepository extends JpaRepository<ComicWritersEntity, ComicWritersID> {

}
