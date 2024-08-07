package com.comics.scheduledtasks.local.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.ComicCharacterEntity;
import com.comics.scheduledtasks.entities.ComicCharacterID;

public interface LocalComicCharacterRepository extends JpaRepository<ComicCharacterEntity, ComicCharacterID> {
	List<ComicCharacterEntity> findByRecordCreationDateAfter(Timestamp ts, Pageable page);
}
