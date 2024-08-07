package com.comics.scheduledtasks.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Characters")
public class CharacterEntity implements Serializable {

	@Id
	private int characterId;
	private String characters, characterPic;
	private Timestamp recordCreationDate, lastUpdated;
}
