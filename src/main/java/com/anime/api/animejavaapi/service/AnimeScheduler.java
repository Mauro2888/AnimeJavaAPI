package com.anime.api.animejavaapi.service;

import com.anime.api.animejavaapi.repository.Anime;
import com.anime.api.animejavaapi.repository.AnimeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AnimeScheduler {

    private static final String HOURLY = "0 0 0/1 1/1 * ? *";
    private static final String MONTHLY = "0 0 12 1 1/1 ? *";

    Logger LOG = LoggerFactory.getLogger(getClass());

    private final AnimeRepository animeRepository;

    private final ScraperServiceAnime scraperServiceAnime;

    public AnimeScheduler(AnimeRepository animeRepository, ScraperServiceAnime scraperServiceAnime) {
        this.animeRepository = animeRepository;
        this.scraperServiceAnime = scraperServiceAnime;
    }

    //@Scheduled(cron = MONTHLY)
    public void scheduler() throws IOException {
        LOG.info("Update DB with new animes");
        List<Anime> animeList = scraperServiceAnime.scrapAllAnime();
        animeRepository.saveAll(animeList);
    }
}
