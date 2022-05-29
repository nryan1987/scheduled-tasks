package com.comics.scheduledtasks.local.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.CreatorAliasEntity;
import com.comics.scheduledtasks.entities.CreatorAliasID;

public interface LocalCreatorAliasRepository extends JpaRepository<CreatorAliasEntity, CreatorAliasID> {
	List<CreatorAliasEntity> findByRecordCreationDateAfter(Timestamp ts, Pageable page);
}
