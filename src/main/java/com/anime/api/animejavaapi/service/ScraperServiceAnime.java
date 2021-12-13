package com.anime.api.animejavaapi.service;

import com.anime.api.animejavaapi.repository.Anime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ScraperServiceAnime {

    public List<Anime> scrapAllAnime() throws IOException {
        List<Anime>dataAnime = new ArrayList<>();

        Document document = Jsoup.connect("https://www.animeforce.it/lista-anime/")
                .header("Accept-Encoding", "gzip, deflate")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
                .maxBodySize(0)
                .timeout(500000)
                .get();

        document.select(".media-body.pb-3.mb-0.small")
                .forEach(title -> {
                    dataAnime.add(new Anime(title.text(),title.select("a").first().attr("href")));
                });

        return dataAnime;
    }

}
