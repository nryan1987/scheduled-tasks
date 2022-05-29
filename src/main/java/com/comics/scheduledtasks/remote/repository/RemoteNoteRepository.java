package com.comics.scheduledtasks.remote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comics.scheduledtasks.entities.NoteEntity;

public interface RemoteNoteRepository extends JpaRepository<NoteEntity, Integer> {

}
