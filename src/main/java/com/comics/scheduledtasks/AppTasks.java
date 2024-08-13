package com.comics.scheduledtasks;

import com.comics.scheduledtasks.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppTasks {
    @Autowired
    DateTimeUtil dateTimeUtil;

    private static final Logger logger = LoggerFactory.getLogger(AppTasks.class);

    @Scheduled(cron = "${heartbeat.cron.schedule}")
    public void heartBeat() {
        logger.info("The time is now {}", dateTimeUtil.getCurrentCDTTimestamp());
    }
}
