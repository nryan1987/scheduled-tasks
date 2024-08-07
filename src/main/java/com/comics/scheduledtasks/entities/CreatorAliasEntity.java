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
@Table(name = "CreatorAlias")
@IdClass(CreatorAliasID.class)
public class CreatorAliasEntity implements Serializable {
	@Id
	private int creatorId;
	@Id
	private String alias;
	private Timestamp recordCreationDate;
}
