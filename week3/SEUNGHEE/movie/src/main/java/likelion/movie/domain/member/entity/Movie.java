package likelion.movie.domain.member.entity;

import jakarta.persistence.*;
import likelion.global.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "member")
    private List<Movie> movies = new ArrayList<>();

    @Builder
    public Movie(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void updateMovie(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
