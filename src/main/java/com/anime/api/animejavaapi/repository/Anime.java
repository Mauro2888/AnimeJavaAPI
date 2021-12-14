package com.anime.api.animejavaapi.repository;

import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "href")
    private String href;

    public Anime(String title, String href) {
        this.title = title;
        this.href = href;
    }
}
