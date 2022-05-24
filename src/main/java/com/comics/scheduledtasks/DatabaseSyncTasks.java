package com.comics.scheduledtasks;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.comics.scheduledtasks.constants.schedulerConstants;
import com.comics.scheduledtasks.entities.ComicEntity;
import com.comics.scheduledtasks.local.repository.LocalComicRepository;
import com.comics.scheduledtasks.remote.repository.RemoteComicRepository;
import com.comics.scheduledtasks.service.ComicService;

@Component
public class DatabaseSyncTasks {
	@Autowired
	LocalComicRepository localComicRepository;
	
	@Autowired
	RemoteComicRepository remoteComicRepository;
	
	@Autowired
	ComicService comicService;
	
	private static final Logger log = LoggerFactory.getLogger(AppTasks.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
	
	@Scheduled(cron="0 */2 * * * *")
	public void syncDatabases() {
//		LocalDate today = LocalDate.now();
//	    LocalDate yesterday = today.minus(Period.ofDays(1));
//	    Date date = Date.from(Instant.now());
//	    Date date2 = new Date(System.currentTimeMillis());
//		Timestamp today = new Timestamp(System.currentTimeMillis());
//		Timestamp yesterday = new Timestamp(System.currentTimeMillis()-24*60*60*1000);
//		
//	    log.info("today {}", today);
//	    log.info("yesterday {}", yesterday);
//	    
//	    List<ComicEntity> comicsToUpdate = localComicRepository.findByLastUpdatedAfter(yesterday);
//	    
//		log.info("The time is now {}", dateFormat.format(new Date()));
//		log.info("{} comics need updating.", comicsToUpdate.size());
//		log.info("local: {}", comicsToUpdate);
//		log.info("remote: {}", remoteComicRepository.findById(17116));
		comicService.syncPublishersFromYesterday();
		comicService.syncCreatorsFromYesterday();
		comicService.syncComicsFromYesterday();
	}
}
