package likelion.movie.domain.review.controller;


import likelion.movie.domain.review.dto.ReviewCreateRequestDTO;
import likelion.movie.domain.review.dto.ReviewCreateResponseDTO;
import likelion.movie.domain.review.dto.ReviewResponseDTO;
import likelion.movie.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/movies/{movie_id}/members/{member_id}/reviews")
    public ResponseEntity<ReviewCreateResponseDTO> createReview(@PathVariable("member_id") Long memberId,
                                                                @PathVariable("movie_id") Long movieId,
                                                                @RequestBody ReviewCreateRequestDTO req) {
        Long reviewId = reviewService.createReview(memberId, movieId, req);
        return ResponseEntity.ok(new ReviewCreateResponseDTO(reviewId));
    }

    @GetMapping("/movies/{movie_id}/reviews")
    public ResponseEntity<List<ReviewResponseDTO>> getReviewsByMovieId(@PathVariable("movie_id") Long movieId) {

        List<ReviewResponseDTO> reviews = reviewService.getReviewsByMovieId(movieId);

        return ResponseEntity.ok(reviews);

    }


}