package com.comics.scheduledtasks.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Creators")
public class CreatorEntity implements Serializable {
	@Id
	private int creatorId;
	
	private String creator, creatorPic;
	
	private Timestamp recordCreationDate, lastUpdated;
}
