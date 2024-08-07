package com.comics.scheduledtasks.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class CharacterAliasID implements Serializable {
	private int characterId;
	private String alias;
}