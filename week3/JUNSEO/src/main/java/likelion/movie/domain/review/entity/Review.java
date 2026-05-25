package likelion.movie.domain.review.entity;

import jakarta.persistence.*;
import likelion.movie.domain.global.common.entity.BaseEntity;
import likelion.movie.domain.member.entity.Member;
import likelion.movie.domain.movie.entity.Movie;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private Integer rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Review(Long id, Integer rating, String content, Member member, Movie movie) {
        this.id = id;
        this.rating = rating;
        this.content = content;
        this.member = member;
        this.movie = movie;
    }
}
