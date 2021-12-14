package com.anime.api.animejavaapi.service;

import com.anime.api.animejavaapi.repository.Episodes;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ScraperServiceEpisodes {

    @SneakyThrows
    public List<Episodes> scrapAllEpisodes(String url, int idAnime) {

        List<Episodes>episodes = new ArrayList<>();

        List<Element> collect = JsoupConnection
                .makeJsoupConnection(url)
                .getElementsByClass("btn btn-dark mb-1").stream().collect(Collectors.toList());

        for (Element e:collect) {
            Elements select = JsoupConnection.makeJsoupConnection(e.attr("href")).select("source");
            episodes.add(new Episodes(e.attr("title"),e.attr("href"),select.first().attr("src")));
        }

        return episodes;
    }

}
