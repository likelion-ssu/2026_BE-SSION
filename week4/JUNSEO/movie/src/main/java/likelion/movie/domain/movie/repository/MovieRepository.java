package likelion.movie.domain.movie.repository;

import likelion.movie.domain.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {



}