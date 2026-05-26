package likelion.movie.domain.movie.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length =50)
    private String movie_name;

    @Column(columnDefinition = "TEXT")   // default가 true라서 nullable 안 써도 됨.
    private String content;

}
