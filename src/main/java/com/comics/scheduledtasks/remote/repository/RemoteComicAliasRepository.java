package com.comics.scheduledtasks.remote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.ComicAliasEntity;

public interface RemoteComicAliasRepository extends JpaRepository<ComicAliasEntity, Integer> {

}
