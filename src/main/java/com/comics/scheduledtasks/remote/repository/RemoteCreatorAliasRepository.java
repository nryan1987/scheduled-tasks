package com.comics.scheduledtasks.remote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.CreatorAliasEntity;
import com.comics.scheduledtasks.entities.CreatorAliasID;

public interface RemoteCreatorAliasRepository extends JpaRepository<CreatorAliasEntity, CreatorAliasID> {

}
