package com.comics.scheduledtasks.local.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.CharacterAliasEntity;

public interface LocalCharacterAliasRepository extends JpaRepository<CharacterAliasEntity, CharacterAliasEntity.CharacterAliasID> {
	List<CharacterAliasEntity> findByRecordCreationDateAfter(Timestamp ts, Pageable page);
}
