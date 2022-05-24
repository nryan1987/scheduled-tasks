package com.comics.scheduledtasks.local.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.CreatorEntity;

public interface LocalCreatorRepository extends JpaRepository<CreatorEntity, Integer> {
	List<CreatorEntity> findByLastUpdatedAfter(Timestamp ts, Pageable page);
}
