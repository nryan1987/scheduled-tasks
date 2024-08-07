package com.comics.scheduledtasks.local.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.ComicWritersEntity;
import com.comics.scheduledtasks.entities.ComicWritersID;

public interface LocalComicWritersRepository extends JpaRepository<ComicWritersEntity, ComicWritersID> {
	List<ComicWritersEntity> findByRecordCreationDateAfter(Timestamp ts, Pageable page);
}
