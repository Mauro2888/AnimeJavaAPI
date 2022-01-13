package com.anime.api.animejavaapi.controller;

import com.anime.api.animejavaapi.exception.NotFoundException;
import com.anime.api.animejavaapi.repository.Anime;
import com.anime.api.animejavaapi.repository.Episodes;
import com.anime.api.animejavaapi.service.AnimeService;
import com.anime.api.animejavaapi.service.ScraperServiceEpisodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/anime")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @Autowired
    ScraperServiceEpisodes scraperServiceEpisodes;

    @GetMapping
    public List<Anime> getAnime() {
        return animeService.getAnime();
    }

    @GetMapping(value = "{id}")
    public Anime getByAnimeId(@PathVariable int id) {
        return animeService.getAnimeById(id);
    }

    //,produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
    @GetMapping(value = "/name")
    public ResponseEntity<List<Anime>> getByAnimeTitle(@RequestParam String title) {
        List<Anime> animeByTitle = animeService.getAnimeByTitle(title);
        if (animeByTitle.isEmpty()){
            throw new NotFoundException("Not found " + title);
        }else
            return new ResponseEntity<>(animeByTitle, HttpStatus.OK);
    }

    @GetMapping(value = "/href/{id}")
    public List<Episodes> getEpisodesByAnimeId(@PathVariable int id) {
        String href = animeService.getHrefAnime(id);
        if (href.isEmpty()){
            throw new NotFoundException("Not found " + id);
        }else
            return animeService.getAllEpisodes(href, id);
    }

}
