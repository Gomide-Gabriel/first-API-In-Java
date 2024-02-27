package org.demo.models;


//import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "anime")
public class Anime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 80)
    private String name;
    @Column(nullable = false, length = 80)
    private String image;
    @Column(nullable = false, length = 80)
    private String studio;
    @Column(nullable = false, length = 80)
    private int episodes;
    @Column(nullable = false, length = 80)
    private int rating;

    public Anime() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anime anime)) return false;
        return getEpisodes() == anime.getEpisodes() && getRating() == anime.getRating() && Objects.equals(getId(), anime.getId()) && Objects.equals(getName(), anime.getName()) && Objects.equals(getImage(), anime.getImage()) && Objects.equals(getStudio(), anime.getStudio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getImage(), getStudio(), getEpisodes(), getRating());
    }
}
