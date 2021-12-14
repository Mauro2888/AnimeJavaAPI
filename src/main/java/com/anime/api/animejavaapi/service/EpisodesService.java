package com.anime.api.animejavaapi.service;

import com.anime.api.animejavaapi.repository.EpisodeRepository;
import com.anime.api.animejavaapi.repository.Episodes;
import org.springframework.stereotype.Service;

@Service
public class EpisodesService {

    public final EpisodeRepository repository;
    public final ScraperServiceEpisodes scraperServiceEpisodes;

    public EpisodesService(EpisodeRepository repository, ScraperServiceEpisodes scraperServiceEpisodes) {
        this.repository = repository;
        this.scraperServiceEpisodes = scraperServiceEpisodes;
    }

}
