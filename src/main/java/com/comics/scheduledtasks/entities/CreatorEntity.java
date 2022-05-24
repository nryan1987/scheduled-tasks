package com.comics.scheduledtasks.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Creators")
public class CreatorEntity {
	@Id
	private int creatorId;
	
	private String creator, creatorPic;
	
	private Timestamp recordCreationDate, lastUpdated;
}
