package likelion.movie.domain.movie.entity;

import jakarta.persistence.*;
import likelion.movie.domain.member.entity.Member;
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

    @Column(nullable = false, length = 20)
    private String director;

    @Column(nullable = false, length = 20)
    private String genre;

    @Column(nullable = false)
    private Integer runningTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Movie(String title, String content, String director, String genre, Integer runningTime, Member member) {
        this.title = title;
        this.content = content;
        this.director = director;
        this.genre = genre;
        this.runningTime = runningTime;
        this.member = member;
    }

    public updateMovie(String title, String content, String director, String genre, Integer runningTime, Member member) {
        this.title = title;
        this.content = content;
        this.director = director;
        this.genre = genre;
        this.runningTime = runningTime;
        this.member = member;
    }
}
