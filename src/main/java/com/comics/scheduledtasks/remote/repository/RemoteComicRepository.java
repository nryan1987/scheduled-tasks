package com.comics.scheduledtasks.remote.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.comics.scheduledtasks.entities.ComicEntity;

public interface RemoteComicRepository extends JpaRepository<ComicEntity, Integer>{
	@Modifying
	@Transactional
    @Query(
            value = "truncate table Comics",
            nativeQuery = true
    )
    void truncateComics();
}
