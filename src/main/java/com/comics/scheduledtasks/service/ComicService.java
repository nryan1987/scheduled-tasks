package com.comics.scheduledtasks.service;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.comics.scheduledtasks.application.ApplicationConfiguration;
import com.comics.scheduledtasks.entities.ComicEntity;
import com.comics.scheduledtasks.entities.CreatorEntity;
import com.comics.scheduledtasks.entities.PublisherEntity;
import com.comics.scheduledtasks.local.repository.LocalComicRepository;
import com.comics.scheduledtasks.local.repository.LocalCreatorRepository;
import com.comics.scheduledtasks.local.repository.LocalPublisherRepository;
import com.comics.scheduledtasks.remote.repository.RemoteComicRepository;
import com.comics.scheduledtasks.remote.repository.RemoteCreatorRepository;
import com.comics.scheduledtasks.remote.repository.RemotePublisherRepository;
import com.comics.scheduledtasks.util.DateTimeUtil;

@Service
public class ComicService {
	Logger logger = LoggerFactory.getLogger(ComicService.class);
	
	@Autowired
	ApplicationConfiguration config;
	
	@Autowired
	DateTimeUtil dateTimeUtil;
	
	@Autowired
	LocalComicRepository localComicRepository;
	
	@Autowired
	LocalPublisherRepository localPublisherRepository;
	
	@Autowired
	LocalCreatorRepository localCreatorRepository;
	
	@Autowired
	RemoteComicRepository remoteComicRepository;
	
	@Autowired
	RemotePublisherRepository remotePublisherRepository;
	
	@Autowired
	RemoteCreatorRepository remoteCreatorRepository;
	
	public void syncPublishersFromYesterday() {
		Timestamp yesterday = dateTimeUtil.getYesterdayTimestamp();
		int pageNumber = 0;
		boolean done = false;
		
		logger.info("Syncing publisher records created on or after {}", yesterday.toLocalDateTime().toLocalDate());
		while (!done) {
			Pageable publisherPage = PageRequest.of(pageNumber, config.getPublisherPageSize());
			List<PublisherEntity> publishersInPage = localPublisherRepository.findByRecordCreationDateAfter(yesterday, publisherPage);
			
			if(publishersInPage == null || publishersInPage.isEmpty()) {
				done = true;
			} else {
				logger.info("Processing page #{}", pageNumber);
				logger.info("{} publishers to update.", publishersInPage.size());
				publishersInPage.forEach(publisher -> {
					logger.info(publisher.toString());
				});
//				remotePublisherRepository.saveAll(publishersInPage);
			}
			pageNumber++;
		}
	}
	
	public void syncCreatorsFromYesterday() {
		Timestamp yesterday = dateTimeUtil.getYesterdayTimestamp();
		int pageNumber = 0;
		boolean done = false;
		
		logger.info("Syncing creator records created or updated on or after {}", yesterday.toLocalDateTime().toLocalDate());
		while (!done) {
			Pageable creatorPage = PageRequest.of(pageNumber, config.getCreatorPageSize());
			List<CreatorEntity> creatorsInPage = localCreatorRepository.findByLastUpdatedAfter(yesterday, creatorPage);
			
			if(creatorsInPage == null || creatorsInPage.isEmpty()) {
				done = true;
			} else {
				logger.info("Processing page #{}", pageNumber);
				logger.info("{} creators to update.", creatorsInPage.size());
				creatorsInPage.forEach(publisher -> {
					logger.info(publisher.toString());
				});
//				remoteCreatorRepository.saveAll(creatorsInPage);
			}
			pageNumber++;
		}
	}
	
	public void syncComicsFromYesterday() {
		Timestamp yesterday = dateTimeUtil.getYesterdayTimestamp();
		int pageNumber = 0;
		boolean done = false;
		
		logger.info("Syncing comic records created or updated on or after {}", yesterday.toLocalDateTime().toLocalDate());
		while (!done) {
			Pageable comicPage = PageRequest.of(pageNumber, config.getComicPageSize());
			List<ComicEntity> comicsInPage = localComicRepository.findByLastUpdatedAfter(yesterday, comicPage);
			
			if(comicsInPage == null || comicsInPage.isEmpty()) {
				done = true;
			} else {
				logger.info("Processing page #{}", pageNumber);
				logger.info("{} comics to update.", comicsInPage.size());
				comicsInPage.forEach(comic -> {
					logger.info(comic.toString());
				});
				//remoteComicRepository.saveAll(comicsInPage);
			}
			pageNumber++;
		}
	}

}
