package com.comics.scheduledtasks.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Notes")
public class NoteEntity implements Serializable {
	@Id
	private int NoteID;
	private int ComicID;
	private String Notes;
	private Timestamp recordCreationDate;
	private Timestamp lastUpdated;
}
