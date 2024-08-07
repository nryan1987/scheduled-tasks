package com.comics.scheduledtasks.remote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.ComicCharacterEntity;
import com.comics.scheduledtasks.entities.ComicCharacterID;

public interface RemoteComicCharacterRepository extends JpaRepository<ComicCharacterEntity, ComicCharacterID> {

}
