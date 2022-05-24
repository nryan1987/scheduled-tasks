package com.comics.scheduledtasks.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DateTimeUtil {
	Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);
	
	public Timestamp getYesterdayTimestamp() {
		
//		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
//		zoneIds.forEach(zone -> {
//			logger.info("zone: {}", zone);
//		});
//		
//		Map<String, String> zoneMap = ZoneId.SHORT_IDS;
//		Set<String> keySet = zoneMap.keySet();
//		keySet.forEach(key -> {
//			logger.info("key: {}. value: {}", key, zoneMap.get(key));
//		});
		
		LocalDateTime localNow = LocalDateTime.now();
		ZonedDateTime todayCDT = localNow.atZone(ZoneId.of("America/Chicago"));
		ZonedDateTime yesterdayCDT = todayCDT.minusDays(1);
		
//		Timestamp yesterday = Timestamp.valueOf(yesterdayCDT.toLocalDateTime());
//		
//		logger.info("localNow: {}", localNow);
//		logger.info("todayCDT: {}", todayCDT);
//		logger.info("yesterdayCDT: {}", yesterdayCDT);
//		logger.info("yesterday TS: {}", yesterday);
//		logger.info("yesterday string: {}", Timestamp.valueOf(yesterdayCDT.toLocalDate().toString() + " 00:00:00"));
		
		return Timestamp.valueOf(yesterdayCDT.toLocalDate().toString() + " 00:00:00");
	}
}
