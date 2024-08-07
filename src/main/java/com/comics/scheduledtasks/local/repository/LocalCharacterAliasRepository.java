package com.comics.scheduledtasks.local.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.CharacterAliasEntity;
import com.comics.scheduledtasks.entities.CharacterAliasID;

public interface LocalCharacterAliasRepository extends JpaRepository<CharacterAliasEntity, CharacterAliasID> {
	List<CharacterAliasEntity> findByRecordCreationDateAfter(Timestamp ts, Pageable page);
}
