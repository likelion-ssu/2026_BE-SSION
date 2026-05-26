package likelion.movie.domain.review.entity;

import jakarta.persistence.*;
import likelion.movie.domain.member.entity.Member;
import likelion.movie.domain.movie.entity.Movie;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length =50)
    private String movie_name;

    @Column(columnDefinition = "TEXT")  // default가 true라서 nullable 안 써도 됨. / text 말고 다른 것도 써도 됨. varchar 등
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = " member_id")  //FK를 매핑할 때 사용. 
    private Member member;

}
