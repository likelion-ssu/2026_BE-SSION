package likelion.movie.domain.review.service;


import likelion.movie.domain.member.entity.Member;
import likelion.movie.domain.member.repository.MemberRepository;
import likelion.movie.domain.movie.entity.Movie;
import likelion.movie.domain.movie.repository.MovieRepository;
import likelion.movie.domain.review.dto.ReviewCreateRequestDTO;
import likelion.movie.domain.review.dto.ReviewResponseDTO;
import likelion.movie.domain.review.entity.Review;
import likelion.movie.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final MovieRepository movieRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public Long createReview(Long memberId, Long movieId, ReviewCreateRequestDTO req) {
        Member member = memberRepository.findById(memberId).orElseThrow
                (() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "멤버를 찾을 수 없습니다."));

        Movie movie = movieRepository.findById(movieId).orElseThrow
                (() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "영화를 찾을 수 없습니다."));

        Review review = reviewRepository.save(Review.builder()
                .content(req.content())
                .member(member)
                .movie(movie)
                .build());

        return review.getId();
    }

    public List<ReviewResponseDTO> getReviewsByMovieId(Long movieId) {

        if (!movieRepository.existsById(movieId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "영화가 존재하지 않습니다.");
        }

        return reviewRepository.findByMovie_Id(movieId)
                .stream()
                .map(review -> new ReviewResponseDTO(
                        review.getId(),
                        review.getContent(),
                        review.getMember().getName(),
                        review.getCreatedAt(),
                        review.getUpdatedAt()
                ))
                .toList();

    }

}