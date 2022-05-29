package com.comics.scheduledtasks.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CharacterAliases")
@IdClass(CreatorAliasID.class)
public class CharacterAliasEntity {
	@Id
	private int characterId;
	@Id
	private String alias;
	private Timestamp recordCreationDate;
	
	@Data
	public class CharacterAliasID implements Serializable {
		private int characterId;
		private String alias;
	}
}
