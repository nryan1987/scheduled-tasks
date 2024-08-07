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
@Table(name = "ComicArtists")
@IdClass(ComicArtistsID.class)
public class ComicArtistsEntity implements Serializable {
	@Id
	private int comicId;
	@Id
	private int artistID;
	private Timestamp recordCreationDate;
}
