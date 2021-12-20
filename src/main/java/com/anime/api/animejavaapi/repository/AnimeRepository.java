package com.anime.api.animejavaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository("animeRepository")
public interface AnimeRepository extends JpaRepository<Anime, Integer> {
    List<Anime>findAll();
    Anime findById(int id);

    @Query("select a from Anime a where a.href like %?1%")
    Anime findHrefById(int id);

    List<Anime> findAnimeByTitleLike(String title);

    List<Anime>findAnimeById(int id);

    List<Anime> findByTitleIgnoreCaseContaining(String title);


}
