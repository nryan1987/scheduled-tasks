package com.comics.scheduledtasks.remote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.ComicArtistsEntity;
import com.comics.scheduledtasks.entities.ComicArtistsID;

public interface RemoteComicArtistsRepository extends JpaRepository<ComicArtistsEntity, ComicArtistsID> {

}
