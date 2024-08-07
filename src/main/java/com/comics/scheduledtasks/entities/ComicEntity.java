package com.comics.scheduledtasks.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "Comics")
public class ComicEntity implements Serializable {
	
	@Id
	private int ComicID;
	
	private int volume;
	
	private double issue, pricePaid, value;

	@Column(name="`condition`")
	private String condition;
	
	private String title, storyTitle, publisher, picture;

	//The values for RecordCreationDate and LastUpdated are handled on the DB side.
	@Column(name = "RecordCreationDate", insertable = false, updatable = false)
	private Timestamp recordCreationDate;
	
	@Column(name = "LastUpdated", insertable = false, updatable = false)
	private Timestamp lastUpdated;

	private LocalDate publicationDate;
}
