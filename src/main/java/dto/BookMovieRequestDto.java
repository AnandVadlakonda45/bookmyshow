package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookMovieRequestDto {
    private Long useId;
    private Long showId;
    private List<Long> showSeatIds;
}
