package likelion.movie.domain.movie.controller;

import likelion.movie.domain.movie.dto.MovieCreateRequestDTO;
import likelion.movie.domain.movie.dto.MovieResponseDTO;
import likelion.movie.domain.movie.dto.MovieUpdateRequestDTO;
import likelion.movie.domain.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/members/{memberId}/movies")
    public ResponseEntity<Void> createMovie(@PathVariable Long memberId,
                                            @RequestBody MovieCreateRequestDTO req) {
        Long movieId = movieService.createMovie(memberId, req);
        URI location = URI.create("/api/members/" + memberId + "/movies/" + movieId);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieResponseDTO>> getAllMovies() {
        return ResponseEntity.ok(movieService.getMovies());
    }

    @GetMapping("/movies/{movieId}")
    public ResponseEntity<MovieResponseDTO> getMovie(@PathVariable Long movieId) {
        return ResponseEntity.ok(movieService.getMovie(movieId));
    }

    @PutMapping("/members/{memberId}/movies/{movieId}")
    public ResponseEntity<Void> updateMoviePut(@PathVariable Long memberId,
                                               @PathVariable Long movieId,
                                               @RequestBody MovieUpdateRequestDTO req) {
        movieService.updateMoviePut(memberId, movieId, req);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/members/{memberId}/movies/{movieId}")
    public ResponseEntity<Void> updateMoviePatch(@PathVariable Long memberId,
                                                 @PathVariable Long movieId,
                                                 @RequestBody MovieUpdateRequestDTO req) {
        movieService.updateMoviePatch(memberId, movieId, req);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/members/{memberId}/movies/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long memberId,
                                            @PathVariable Long movieId) {
        movieService.deleteMovie(memberId, movieId);
        return ResponseEntity.noContent().build();
    }
}
