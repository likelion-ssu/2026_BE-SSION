package likelion.movie.domain.review.repository;

import likelion.movie.domain.movie.entity.Movie;
import likelion.movie.domain.review.dto.ReviewResponseDTO;
import likelion.movie.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMovie(Movie movie);
}
