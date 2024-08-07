package com.comics.scheduledtasks.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ComicCharacters")
@IdClass(ComicCharacterID.class)
public class ComicCharacterEntity implements Serializable {
	@Id
	private int ComicID;
	@Id
	private int CharacterID;
	@Id
	private String AppearsAs;
	
	private Timestamp recordCreationDate;
}
