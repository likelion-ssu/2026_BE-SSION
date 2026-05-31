package likelion.movie.domain.movie.dto;

import java.time.LocalDateTime;

public record MovieResponseDTO(
        String title,
        String content,
        String author,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}