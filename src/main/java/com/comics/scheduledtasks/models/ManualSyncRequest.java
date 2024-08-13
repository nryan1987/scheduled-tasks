package com.comics.scheduledtasks.models;

import lombok.Data;

@Data
public class ManualSyncRequest {
    private int numDays;
    private int numMonths;
    private int numYears;
}
