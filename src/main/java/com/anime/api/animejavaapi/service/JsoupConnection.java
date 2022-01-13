package com.anime.api.animejavaapi.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsoupConnection {

   public Document makeJsoupConnection(String url) throws IOException {
       return Jsoup.connect(url)
               .userAgent("Mozilla")
               .header("Accept", "text/html")
               .header("Accept-Encoding", "gzip,deflate")
               .header("Accept-Language", "it-IT,en;q=0.8,en-US;q=0.6,de;q=0.4,it;q=0.2,es;q=0.2")
               .header("Connection", "keep-alive")
               .ignoreContentType(true)
              .maxBodySize(0)
              .timeout(500000)
              .get();
   }
}
