package com.anime.api.animejavaapi.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "episodes")
public class Episodes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "video")
    private String href;
    @Column(name = "url")
    private String url;

    public Episodes(String title, String href, String url) {
        this.title = title;
        this.href = href;
        this.url = url;
    }
}
