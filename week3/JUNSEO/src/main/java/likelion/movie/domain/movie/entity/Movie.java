package likelion.movie.domain.movie.entity;

import jakarta.persistence.*;
import likelion.movie.domain.global.common.entity.BaseEntity;
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

    @Column(nullable = false, length = 30)
    private Integer rank;

    @Builder
    public Movie(Long id, String title, String content, Integer rank) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.rank = rank;
    }

}
