package com.comics.scheduledtasks.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class ComicWritersID implements Serializable {
	private int comicId, writerID;
}
