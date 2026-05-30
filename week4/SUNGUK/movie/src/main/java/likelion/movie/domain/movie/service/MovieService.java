package likelion.movie.domain.movie.service;

import likelion.movie.domain.member.entity.Member;
import likelion.movie.domain.member.repository.MemberRepository;
import likelion.movie.domain.movie.dto.MovieCreateRequestDTO;
import likelion.movie.domain.movie.dto.MovieResponseDTO;
import likelion.movie.domain.movie.dto.MovieUpdateRequestDTO;
import likelion.movie.domain.movie.entity.Movie;
import likelion.movie.domain.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieService {

    private final MovieRepository movieRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long createMovie(Long memberId, MovieCreateRequestDTO req) {
        Member member = memberRepository.findById(memberId).orElseThrow
                (() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "멤버를 찾을 수 없습니다."));

        Movie movie = movieRepository.save(Movie.builder()
                .title(req.title())
                .content(req.content())
                .member(member)
                .build());

        return movie.getId();
    }

    public List<MovieResponseDTO> getMovies() {

        return movieRepository.findAll().stream()
                .map(movie -> new MovieResponseDTO(
                        movie.getTitle(),
                        movie.getContent(),
                        movie.getMember().getName(),
                        movie.getCreatedAt(),
                        movie.getUpdatedAt()
                ))
                .toList();

    }

    public MovieResponseDTO getMovie(Long movieId) {

        Movie movie = movieRepository.findById(movieId).orElseThrow
                (() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "영화를 찾을 수 없습니다."));

        return new MovieResponseDTO(
                movie.getTitle(),
                movie.getContent(),
                movie.getMember().getName(),
                movie.getCreatedAt(),
                movie.getUpdatedAt());

    }

    @Transactional
    public void updateMoviePut(Long memberId, Long movieId, MovieUpdateRequestDTO req) {
        if(!memberRepository.existsById(memberId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "멤버를 찾을 수 없습니다.");
        }

        Movie movie = movieRepository.findById(movieId).orElseThrow
                (() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "영화를 찾을 수 없습니다."));

        if(!memberId.equals(movie.getMember().getId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "수정 권한이 없습니다.");
        }

        movie.updateMoviePut(req);
    }

    @Transactional
    public void updateMoviePatch(Long memberId, Long movieId, MovieUpdateRequestDTO req) {
        if(!memberRepository.existsById(memberId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "멤버를 찾을 수 없습니다.");
        }

        Movie movie = movieRepository.findById(movieId).orElseThrow
                (() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "영화를 찾을 수 없습니다."));

        if(!memberId.equals(movie.getMember().getId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "수정 권한이 없습니다.");
        }

        movie.updateMoviePatch(req);
    }

    @Transactional
    public void deleteMovie(Long memberId, Long movieId) {
        if(!memberRepository.existsById(memberId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "멤버를 찾을 수 없습니다.");
        }

        Movie movie = movieRepository.findById(movieId).orElseThrow
                (() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "영화를 찾을 수 없습니다."));

        if(!memberId.equals(movie.getMember().getId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "삭제 권한이 없습니다.");
        }

        movieRepository.delete(movie);
    }
}
