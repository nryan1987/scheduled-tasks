package com.comics.scheduledtasks.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Notes")
public class NoteEntity {
	@Id
	private int NoteID;
	private int ComicID;
	private String Notes;
	private Timestamp recordCreationDate;
	private Timestamp lastUpdated;
}
