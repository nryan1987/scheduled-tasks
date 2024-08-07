package com.comics.scheduledtasks.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class ComicCharacterID implements Serializable {
	private int ComicID;
	private int CharacterID;
	private String AppearsAs;
}
