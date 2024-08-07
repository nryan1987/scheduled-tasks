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
@Table(name = "ComicWriters")
@IdClass(ComicWritersID.class)
public class ComicWritersEntity implements Serializable {
	@Id
	private int comicId;
	@Id
	private int writerID;
	private Timestamp recordCreationDate;
}
