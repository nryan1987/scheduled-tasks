package com.comics.scheduledtasks.application;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApplicationConfiguration {
    @Value("${comic.page.size}")
    private int comicPageSize;

    @Value("${publisher.page.size}")
    private int publisherPageSize;

    @Value("${creator.page.size}")
    private int creatorPageSize;

    @Value("${character.page.size}")
    private int characterPageSize;
}
