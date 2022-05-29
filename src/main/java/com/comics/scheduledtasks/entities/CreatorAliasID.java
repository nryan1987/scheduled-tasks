package com.comics.scheduledtasks.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class CreatorAliasID implements Serializable {
	private int creatorId;
	private String alias;
}
