package com.comics.scheduledtasks.service;

import com.comics.scheduledtasks.application.ApplicationConfiguration;
import com.comics.scheduledtasks.entities.*;
import com.comics.scheduledtasks.local.repository.*;
import com.comics.scheduledtasks.remote.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ComicService {
    Logger logger = LoggerFactory.getLogger(ComicService.class);

    @Autowired
    ApplicationConfiguration config;

    @Autowired
    LocalComicRepository localComicRepository;

    @Autowired
    LocalComicAliasRepository localComicAliasRepository;

    @Autowired
    LocalNoteRepository localNoteRepository;

    @Autowired
    LocalPublisherRepository localPublisherRepository;

    @Autowired
    LocalCreatorRepository localCreatorRepository;

    @Autowired
    LocalCreatorAliasRepository localcreatorAliasRepository;

    @Autowired
    LocalCharacterRepository localCharacterRepository;

    @Autowired
    LocalCharacterAliasRepository localCharacterAliasRepository;

    @Autowired
    LocalComicArtistsRepository localComicArtistsRepository;

    @Autowired
    RemoteComicRepository remoteComicRepository;

    @Autowired
    RemoteComicAliasRepository remoteComicAliasRepository;

    @Autowired
    RemoteNoteRepository remoteNoteRepository;

    @Autowired
    RemotePublisherRepository remotePublisherRepository;

    @Autowired
    RemoteCreatorRepository remoteCreatorRepository;

    @Autowired
    RemoteCreatorAliasRepository remoteCreatorAliasRepository;

    @Autowired
    RemoteCharacterRepository remoteCharacterRepository;

    @Autowired
    RemoteCharacterAliasRepository remoteCharacterAliasRepository;

    @Autowired
    RemoteComicArtistsRepository remoteComicArtistsRepository;

    public void syncPublishers(Timestamp syncDate) {
        int pageNumber = 0;
        boolean done = false;

        logger.info("Syncing publisher records created on or after {}", syncDate.toLocalDateTime().toLocalDate());
        while (!done) {
            Pageable publisherPage = PageRequest.of(pageNumber, config.getPublisherPageSize());
            List<PublisherEntity> publishersInPage = localPublisherRepository.findByRecordCreationDateAfter(syncDate, publisherPage);

            if (publishersInPage == null || publishersInPage.isEmpty()) {
                done = true;
            } else {
                logger.info("Processing page #{}", pageNumber);
                logger.info("{} publishers to update.", publishersInPage.size());
                publishersInPage.forEach(publisher -> logger.info(publisher.toString()));
                remotePublisherRepository.saveAll(publishersInPage);
            }
            pageNumber++;
        }
    }

    public void syncCreators(Timestamp syncDate) {
        int pageNumber = 0;
        boolean done = false;

        logger.info("Syncing creator records created or updated on or after {}", syncDate.toLocalDateTime().toLocalDate());
        while (!done) {
            Pageable creatorPage = PageRequest.of(pageNumber, config.getCreatorPageSize());
            List<CreatorEntity> creatorsInPage = localCreatorRepository.findByLastUpdatedAfter(syncDate, creatorPage);

            if (creatorsInPage == null || creatorsInPage.isEmpty()) {
                done = true;
            } else {
                logger.info("Processing page #{}", pageNumber);
                logger.info("{} creators to update.", creatorsInPage.size());
                creatorsInPage.forEach(creator -> logger.info(creator.toString()));
                remoteCreatorRepository.saveAll(creatorsInPage);
            }
            pageNumber++;
        }
    }

    public void syncCreatorAliases(Timestamp syncDate) {
        int pageNumber = 0;
        boolean done = false;

        logger.info("Syncing creator alias records created on or after {}", syncDate.toLocalDateTime().toLocalDate());
        while (!done) {
            Pageable creatorPage = PageRequest.of(pageNumber, config.getCreatorPageSize());
            List<CreatorAliasEntity> creatorAliasesInPage = localcreatorAliasRepository.findByRecordCreationDateAfter(syncDate, creatorPage);

            if (creatorAliasesInPage == null || creatorAliasesInPage.isEmpty()) {
                done = true;
            } else {
                logger.info("Processing page #{}", pageNumber);
                logger.info("{} creator aliases to update.", creatorAliasesInPage.size());
                creatorAliasesInPage.forEach(alias -> logger.info(alias.toString()));
                remoteCreatorAliasRepository.saveAll(creatorAliasesInPage);
            }
            pageNumber++;
        }
    }

    public void syncCharacters(Timestamp syncDate) {
        int pageNumber = 0;
        boolean done = false;

        logger.info("Syncing character records created or updated on or after {}", syncDate.toLocalDateTime().toLocalDate());
        while (!done) {
            Pageable characterPage = PageRequest.of(pageNumber, config.getCharacterPageSize());
            List<CharacterEntity> charactersInPage = localCharacterRepository.findByLastUpdatedAfter(syncDate, characterPage);

            if (charactersInPage == null || charactersInPage.isEmpty()) {
                done = true;
            } else {
                logger.info("Processing page #{}", pageNumber);
                charactersInPage.forEach(character -> logger.info(character.toString()));
                remoteCharacterRepository.saveAll(charactersInPage);
            }
            pageNumber++;
        }
    }

    public void syncCharacterAliases(Timestamp syncDate) {
        int pageNumber = 0;
        boolean done = false;

        logger.info("Syncing character alias records created on or after {}", syncDate.toLocalDateTime().toLocalDate());
        while (!done) {
            Pageable characterAliasPage = PageRequest.of(pageNumber, config.getCharacterPageSize());
            List<CharacterAliasEntity> characterAliasesInPage = localCharacterAliasRepository.findByRecordCreationDateAfter(syncDate, characterAliasPage);

            if (characterAliasesInPage == null || characterAliasesInPage.isEmpty()) {
                done = true;
            } else {
                logger.info("Processing page #{}", pageNumber);
                characterAliasesInPage.forEach(characterAliases -> logger.info(characterAliases.toString()));
                remoteCharacterAliasRepository.saveAll(characterAliasesInPage);
            }
            pageNumber++;
        }
    }

    public void syncComics(Timestamp syncDate) {
        int pageNumber = 0;
        boolean done = false;

        logger.info("Syncing comic records created or updated on or after {}", syncDate.toLocalDateTime().toLocalDate());
        while (!done) {
            Pageable comicPage = PageRequest.of(pageNumber, config.getComicPageSize());
            List<ComicEntity> comicsInPage = localComicRepository.findByLastUpdatedAfter(syncDate, comicPage);

            if (comicsInPage == null || comicsInPage.isEmpty()) {
                done = true;
            } else {
                logger.info("Processing page #{}", pageNumber);
                logger.info("{} comics to update.", comicsInPage.size());
                comicsInPage.forEach(comic -> logger.info(comic.toString()));
                remoteComicRepository.saveAll(comicsInPage);
            }
            pageNumber++;
        }
    }

    public void syncNotes(Timestamp syncDate) {
        int pageNumber = 0;
        boolean done = false;

        logger.info("Syncing note records created or updated on or after {}", syncDate.toLocalDateTime().toLocalDate());
        while (!done) {
            Pageable notePage = PageRequest.of(pageNumber, config.getComicPageSize());
            List<NoteEntity> notesInPage = localNoteRepository.findByLastUpdatedAfter(syncDate, notePage);

            if (notesInPage == null || notesInPage.isEmpty()) {
                done = true;
            } else {
                logger.info("Processing page #{}", pageNumber);
                notesInPage.forEach(note -> logger.info(note.toString()));
                remoteNoteRepository.saveAll(notesInPage);
            }
            pageNumber++;
        }
    }

    public void syncComicAliases(Timestamp syncDate) {
        int pageNumber = 0;
        boolean done = false;

        logger.info("Syncing comicAlias records created or updated on or after {}", syncDate.toLocalDateTime().toLocalDate());
        while (!done) {
            Pageable comicAliasPage = PageRequest.of(pageNumber, config.getComicPageSize());
            List<ComicAliasEntity> comicAliasesInPage = localComicAliasRepository.findByLastUpdatedAfter(syncDate, comicAliasPage);

            if (comicAliasesInPage == null || comicAliasesInPage.isEmpty()) {
                done = true;
            } else {
                logger.info("Processing page #{}", pageNumber);
                comicAliasesInPage.forEach(alias -> logger.info(alias.toString()));
                remoteComicAliasRepository.saveAll(comicAliasesInPage);
            }
            pageNumber++;
        }
    }

    public void syncComicArtists(Timestamp syncDate) {
        int pageNumber = 0;
        boolean done = false;

        logger.info("Syncing comicArtist records created on or after {}", syncDate.toLocalDateTime().toLocalDate());
        while (!done) {
            Pageable comicArtistPage = PageRequest.of(pageNumber, config.getCreatorPageSize());
            List<ComicArtistsEntity> comicArtistsInPage = localComicArtistsRepository.findByRecordCreationDateAfter(syncDate, comicArtistPage);

            if (comicArtistsInPage == null || comicArtistsInPage.isEmpty()) {
                done = true;
            } else {
                logger.info("Processing page #{}", pageNumber);
                comicArtistsInPage.forEach(comicArtist -> logger.info(comicArtist.toString()));
                remoteComicArtistsRepository.saveAll(comicArtistsInPage);
            }
            pageNumber++;
        }
    }
}
