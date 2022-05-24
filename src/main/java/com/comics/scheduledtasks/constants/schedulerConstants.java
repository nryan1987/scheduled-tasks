package com.comics.scheduledtasks.constants;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class schedulerConstants {
	public static final String EVERY_HOUR_ON_THE_HOUR_CRON_SCHEDULE = "0 0 */1 * * *";
}
