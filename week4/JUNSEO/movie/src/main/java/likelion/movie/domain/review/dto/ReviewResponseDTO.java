package likelion.movie.domain.review.dto;

import java.time.LocalDateTime;

public record ReviewResponseDTO(
        Long reviewId,
        String content,
        String author,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}