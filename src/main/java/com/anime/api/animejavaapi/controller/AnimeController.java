package com.anime.api.animejavaapi.controller;

import com.anime.api.animejavaapi.repository.Anime;
import com.anime.api.animejavaapi.repository.Episodes;
import com.anime.api.animejavaapi.service.AnimeService;
import com.anime.api.animejavaapi.service.ScraperServiceEpisodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/anime")
public class AnimeController {

    Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private AnimeService animeService;

    @Autowired
    ScraperServiceEpisodes scraperServiceEpisodes;

    @GetMapping()
    public List<Anime> getAnime() {
        return animeService.getAnime();
    }

    @GetMapping(value = "{id}")
    public Anime getByAnimeId(@PathVariable int id) {
        return animeService.getAnimeById(id);
    }

    @GetMapping(value = "/name")
    public List<Anime> getByAnimeTitle(@RequestParam String title) {
        return animeService.getAnimeByTitle(title);
    }

    @GetMapping(value = "/href/{id}")
    public List<Episodes> getByAnimeHrefById(@PathVariable int id) throws IOException {
        String href = animeService.getHrefAnime(id);
        return animeService.getAllEpisodes(href, id);
    }

}
