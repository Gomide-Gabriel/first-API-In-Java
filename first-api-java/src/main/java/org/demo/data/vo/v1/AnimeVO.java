package org.demo.data.vo.v1;


import com.github.dozermapper.core.Mapping;
//import jakarta.persistence.*;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;


import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "anime")
public class AnimeVO extends RepresentationModel<AnimeVO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @Id
    private Long Key;
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

    public AnimeVO() {
    }

    public Long getKey() {
        return Key;
    }

    public void setKey(Long key) {
        Key = key;
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
        if (!(o instanceof AnimeVO animeVO)) return false;
        if (!super.equals(o)) return false;
        return getEpisodes() == animeVO.getEpisodes() && getRating() == animeVO.getRating() && Objects.equals(getKey(), animeVO.getKey()) && Objects.equals(getName(), animeVO.getName()) && Objects.equals(getImage(), animeVO.getImage()) && Objects.equals(getStudio(), animeVO.getStudio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getKey(), getName(), getImage(), getStudio(), getEpisodes(), getRating());
    }
}