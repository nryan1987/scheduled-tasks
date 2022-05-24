package com.comics.scheduledtasks.local.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.PublisherEntity;

public interface LocalPublisherRepository extends JpaRepository<PublisherEntity, Integer> {
	List<PublisherEntity> findByRecordCreationDateAfter(Timestamp ts, Pageable page);
}
