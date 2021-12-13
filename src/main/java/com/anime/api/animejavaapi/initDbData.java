package com.anime.api.animejavaapi;

import com.anime.api.animejavaapi.repository.Anime;
import com.anime.api.animejavaapi.repository.AnimeRepository;
import com.anime.api.animejavaapi.repository.EpisodeRepository;
import com.anime.api.animejavaapi.service.ScraperServiceAnime;
import com.anime.api.animejavaapi.service.ScraperServiceEpisodes;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class initDbData implements ApplicationRunner {

    private final AnimeRepository animeRepository;


    private final ScraperServiceAnime scraperServiceAnime;

    public initDbData(AnimeRepository animeRepository, ScraperServiceAnime scraperServiceAnime) {
        this.animeRepository = animeRepository;
        this.scraperServiceAnime = scraperServiceAnime;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Anime> animeList = scraperServiceAnime.scrapAllAnime();
        animeRepository.saveAll(animeList);
    }


}
