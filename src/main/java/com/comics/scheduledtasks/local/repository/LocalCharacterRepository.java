package com.comics.scheduledtasks.local.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.CharacterEntity;

public interface LocalCharacterRepository extends JpaRepository<CharacterEntity, Integer> {
	List<CharacterEntity> findByLastUpdatedAfter(Timestamp ts, Pageable page);
}
