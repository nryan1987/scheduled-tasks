package com.comics.scheduledtasks.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Characters")
public class CharacterEntity {

	@Id
	private int characterId;
	private String characters, characterPic;
	private Timestamp recordCreationDate, lastUpdated;
}
