package com.comics.scheduledtasks.remote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.CharacterAliasEntity;
import com.comics.scheduledtasks.entities.CharacterAliasID;

public interface RemoteCharacterAliasRepository extends JpaRepository<CharacterAliasEntity, CharacterAliasID> {

}
