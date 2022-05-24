package com.comics.scheduledtasks.remote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.PublisherEntity;

public interface RemotePublisherRepository extends JpaRepository<PublisherEntity, Integer> {

}
