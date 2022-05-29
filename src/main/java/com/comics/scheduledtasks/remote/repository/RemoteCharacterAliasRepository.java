package com.comics.scheduledtasks.remote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.CharacterAliasEntity;

public interface RemoteCharacterAliasRepository extends JpaRepository<CharacterAliasEntity, CharacterAliasEntity.CharacterAliasID> {

}
