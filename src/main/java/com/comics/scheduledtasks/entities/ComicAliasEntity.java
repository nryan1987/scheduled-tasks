package com.comics.scheduledtasks.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ComicAlias")
public class ComicAliasEntity implements Serializable {
	@Id
	private int ComicID;
	private int issue, volume;
	private String title;
	private Timestamp recordCreationDate, lastUpdated;
}
