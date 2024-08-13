package com.comics.scheduledtasks.models;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SyncResponse {
    private String message;
    private Timestamp timestamp;
}
