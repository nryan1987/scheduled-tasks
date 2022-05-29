package com.comics.scheduledtasks.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ComicAlias")
public class ComicAliasEntity {
	@Id
	private int ComicID;
	private int issue, volume;
	private Timestamp recordCreationDate, lastUpdated;
}
