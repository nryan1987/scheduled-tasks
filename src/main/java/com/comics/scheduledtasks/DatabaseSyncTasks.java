package com.comics.scheduledtasks;

import com.comics.scheduledtasks.models.ManualSyncRequest;
import com.comics.scheduledtasks.service.ComicService;
import com.comics.scheduledtasks.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DatabaseSyncTasks {
    @Autowired
    DateTimeUtil dateTimeUtil;

    @Autowired
    ComicService comicService;

    private static final Logger logger = LoggerFactory.getLogger(DatabaseSyncTasks.class);

    @Scheduled(cron = "${daily.sync.cron.schedule}")
    public void dailyDatabaseSync() {
        logger.info("Starting daily sync job at {}", dateTimeUtil.getCurrentCDTTimestamp());
        syncData(dateTimeUtil.getYesterdayTimestamp());
        logger.info("Finished daily sync job at {}", dateTimeUtil.getCurrentCDTTimestamp());
    }

    public void manualDatabaseSync(ManualSyncRequest manualSyncRequest) {
        logger.info("Starting manual sync job at {}", dateTimeUtil.getCurrentCDTTimestamp());
        syncData(dateTimeUtil.getTimestampFromRequest(manualSyncRequest));
        logger.info("Finished daily sync job at {}", dateTimeUtil.getCurrentCDTTimestamp());
    }

    private void syncData(Timestamp syncDate) {
        comicService.syncPublishers(syncDate);
        comicService.syncCreators(syncDate);
        comicService.syncCreatorAliases(syncDate);
        comicService.syncCharacters(syncDate);
        comicService.syncCharacterAliases(syncDate);
        comicService.syncComics(syncDate);
        comicService.syncComicAliases(syncDate);
        comicService.syncNotes(syncDate);
        comicService.syncComicArtists(syncDate);
    }
}
