package com.comics.scheduledtasks.remote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.CharacterEntity;

public interface RemoteCharacterRepository extends JpaRepository<CharacterEntity, Integer> {

}
