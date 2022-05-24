package com.comics.scheduledtasks.local.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.comics.scheduledtasks.entities.ComicEntity;

public interface LocalComicRepository extends JpaRepository<ComicEntity, Integer> {
	List<ComicEntity> findByLastUpdatedAfter(Timestamp ts, Pageable page);
}
