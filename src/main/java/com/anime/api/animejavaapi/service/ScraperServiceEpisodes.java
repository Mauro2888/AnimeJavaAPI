package com.anime.api.animejavaapi.service;

import com.anime.api.animejavaapi.repository.Episodes;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ScraperServiceEpisodes {

    @SneakyThrows
    public List<Episodes> scrapAllEpisodes(String url) {

        List<Episodes>episodes = new ArrayList<>();

        Document document = Jsoup.connect(url)
                .header("Accept-Encoding", "gzip, deflate")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
                .maxBodySize(0)
                .timeout(500000)
                .get();

        List<Element> collect = document.getElementsByClass("btn btn-dark mb-1").stream().collect(Collectors.toList());
        int count = 0;
        for (Element e:collect) {
            System.out.println(e.attr("title"));
            System.out.println(e.attr("href"));
            count += 1;
            episodes.add(new Episodes(count ,e.attr("title"),e.attr("href")));
        }

        return episodes;
    }

}
