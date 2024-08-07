package com.comics.scheduledtasks.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Publisher")
public class PublisherEntity implements Serializable {
	@Id
	private int PublisherID;
	
	@Column(name = "Publisher")
	private String Publisher;
	
	//The value for RecordCreationDate are handled on the DB side.
	@Column(name = "RecordCreationDate", insertable = false, updatable = false)
	private Timestamp recordCreationDate;
}
