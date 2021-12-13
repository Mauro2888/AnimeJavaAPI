package com.anime.api.animejavaapi.service;

import com.anime.api.animejavaapi.repository.Anime;
import com.anime.api.animejavaapi.repository.AnimeRepository;
import com.anime.api.animejavaapi.repository.EpisodeRepository;
import com.anime.api.animejavaapi.repository.Episodes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        List<Anime> all = repository.findAll();
        return all.stream()
                .filter(ids -> ids.getId() == id)
                .map(Anime::getHref).findFirst().orElse("");
    }

    public String getAnimeByName(String name){
        List<Anime> all = repository.findAnimeByTitleLike(name);
        return all.stream()
                .filter(ids -> Objects.equals(ids.getTitle(), name))
                .map(Anime::getHref).findFirst().orElse("Not found");
    }


    public List<Episodes>getAllEpisodes(String urls){
        return scraperServiceEpisodes.scrapAllEpisodes(urls);
    }



    public Anime getAnimeById(int id){
        return repository.findById(id);
    }


    public List<Anime>getAnimeByTitle(String title) {
        return repository.findByTitleIgnoreCaseContaining(title);
    }
}
