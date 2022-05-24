package com.comics.scheduledtasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.comics.scheduledtasks.application.ApplicationConfiguration;
import com.comics.scheduledtasks.constants.schedulerConstants;

@Component
public class AppTasks {
	@Autowired
	ApplicationConfiguration config;
	
	private static final Logger log = LoggerFactory.getLogger(AppTasks.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
	
	@Scheduled(cron="${heartbeat.cron.schedule}")
	public void heartBeat() {
		log.info("The time is now {}", dateFormat.format(new Date()));
	}
}
