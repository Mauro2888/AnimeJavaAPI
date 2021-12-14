package com.anime.api.animejavaapi.service;

import com.anime.api.animejavaapi.repository.Anime;
import com.anime.api.animejavaapi.repository.AnimeRepository;
import com.anime.api.animejavaapi.repository.EpisodeRepository;
import com.anime.api.animejavaapi.repository.Episodes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {

    public final AnimeRepository repository;

    public final EpisodeRepository episodeRepository;

    public final ScraperServiceEpisodes scraperServiceEpisodes;

    public AnimeService(AnimeRepository repository, EpisodeRepository episodeRepository, ScraperServiceEpisodes scraperServiceEpisodes) {
        this.repository = repository;
        this.episodeRepository = episodeRepository;
        this.scraperServiceEpisodes = scraperServiceEpisodes;
    }

    public List<Anime> getAnime(){
        return repository.findAll();
    }

    public String getHrefAnime(int id){
        List<Anime> all = repository.findAnimeById(id);
        return all.stream()
                .filter(ids -> ids.getId() == id)
                .map(Anime::getHref).findFirst().orElse("");
    }


    public List<Episodes>getAllEpisodes(String urls,int id){
        List<Episodes> episodes = scraperServiceEpisodes.scrapAllEpisodes(urls, id);
        return episodes;
    }



    public Anime getAnimeById(int id){
        return repository.findById(id);
    }


    public List<Anime>getAnimeByTitle(String title) {
        return repository.findByTitleIgnoreCaseContaining(title);
    }
}
