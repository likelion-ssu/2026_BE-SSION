package likelion.movie.domain.review.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import likelion.movie.domain.member.entity.Member;
import likelion.movie.domain.movie.entity.Movie;
import likelion.movie.global.common.entity.BaseEntity;
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

    @NotNull // DB까지 가기 전, 애플리케이션 단계에서 NOT NULL 검증 (사용자에게 에러 응답)
    @Min(1) // 최소 1점
    @Max(5) // 최대 5점
    @Column(nullable = false) // DB 컬럼을 NOT NULL 제약으로 만듦
    private Integer rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Review(String content, Integer rating) {
        this.content = content;
        this.rating = rating;
    }

    public void updateReview(Review review) {
        this.content = review.getContent();
        this.rating = review.getRating();
    }
}
