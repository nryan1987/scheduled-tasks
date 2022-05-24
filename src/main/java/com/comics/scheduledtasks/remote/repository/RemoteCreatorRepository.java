package com.comics.scheduledtasks.remote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.CreatorEntity;

public interface RemoteCreatorRepository extends JpaRepository<CreatorEntity, Integer> {

}
