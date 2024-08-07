package com.comics.scheduledtasks.local.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.ComicArtistsEntity;
import com.comics.scheduledtasks.entities.ComicArtistsID;

public interface LocalComicArtistsRepository extends JpaRepository<ComicArtistsEntity, ComicArtistsID> {
	List<ComicArtistsEntity> findByRecordCreationDateAfter(Timestamp ts, Pageable page);
}
