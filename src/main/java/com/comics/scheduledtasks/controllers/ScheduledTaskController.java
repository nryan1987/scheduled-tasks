package com.comics.scheduledtasks.controllers;

import com.comics.scheduledtasks.DatabaseSyncTasks;
import com.comics.scheduledtasks.models.ManualSyncRequest;
import com.comics.scheduledtasks.models.SyncResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@RestController
@CrossOrigin
@RequestMapping("/scheduledJobs")
public class ScheduledTaskController {
    @Autowired
    DatabaseSyncTasks databaseSyncTasks;

    @PostMapping("/startSync")
    public SyncResponse startSync() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        Runnable task = () -> databaseSyncTasks.dailyDatabaseSync();
        executorService.execute(task);
        executorService.shutdown();

        SyncResponse response = new SyncResponse();
        response.setMessage("Sync Started");
        response.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        return response;
    }

    @PostMapping("/syncPastData")
    public SyncResponse syncPastData(@RequestBody ManualSyncRequest manualSyncRequest) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        Runnable task = () -> databaseSyncTasks.manualDatabaseSync(manualSyncRequest);
        executorService.execute(task);
        executorService.shutdown();

        SyncResponse response = new SyncResponse();
        response.setMessage("Sync Started from date: " + manualSyncRequest.toString());
        response.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        return response;
    }
}
