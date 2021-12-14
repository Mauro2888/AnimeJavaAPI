package com.anime.api.animejavaapi.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupConnection {

   public static Document makeJsoupConnection(String url) throws IOException {
       return Jsoup.connect(url)
              .header("Accept-Encoding", "gzip, deflate")
              .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
              .maxBodySize(0)
              .timeout(500000)
              .get();
   }
}
