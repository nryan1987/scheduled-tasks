package com.comics.scheduledtasks.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class ApplicationConfiguration {
	@Value("${heartbeat.cron.schedule}")
	private String heartBeatCronSchedule;
	
	@Value("${comic.page.size}")
	private int comicPageSize;
	
	@Value("${publisher.page.size}")
	private int publisherPageSize;
	
	@Value("${creator.page.size}")
	private int creatorPageSize;
}
