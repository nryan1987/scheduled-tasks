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
@Table(name = "CharacterAliases")
@IdClass(CharacterAliasID.class)
public class CharacterAliasEntity implements Serializable {
	@Id
	private int characterId;
	@Id
	private String alias;
	private Timestamp recordCreationDate;
}
