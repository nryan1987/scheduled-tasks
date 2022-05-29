package com.comics.scheduledtasks.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CreatorAlias")
@IdClass(CreatorAliasID.class)
public class CreatorAliasEntity {
	@Id
	private int creatorId;
	@Id
	private String alias;
	private Timestamp recordCreationDate;
}
