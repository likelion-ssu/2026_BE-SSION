package likelion.movie.domain.movie.entity;

import jakarta.persistence.*;
import likelion.movie.global.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false, length = 50)
    private String category;

    @Builder
    public Movie(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public void updateMovie(Movie movie) {
        this.title = movie.getTitle();
        this.content = movie.getContent();
        this.category = movie.getCategory();
    }
}
