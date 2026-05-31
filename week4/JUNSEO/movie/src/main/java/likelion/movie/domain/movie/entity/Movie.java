package likelion.movie.domain.movie.entity;

import jakarta.persistence.*;
import likelion.movie.domain.global.common.entity.BaseEntity;
import likelion.movie.domain.member.entity.Member;
import likelion.movie.domain.movie.dto.MovieUpdateRequestDTO;
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

    @Column(columnDefinition="TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Movie(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public void updateMoviePut(MovieUpdateRequestDTO req) {
        this.title = req.title();
        this.content = req.content();
    }

    public void updateMoviePatch(MovieUpdateRequestDTO req) {
        if (req.title() != null) this.title = req.title();
        if (req.content() != null) this.content = req.content();
    }

}