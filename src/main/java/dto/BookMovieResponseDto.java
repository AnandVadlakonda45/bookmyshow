package dto;

import lombok.Getter;
import lombok.Setter;
import models.ResponseStatus;

import javax.annotation.processing.Generated;

@Getter
@Setter
public class BookMovieResponseDto {
    private Long bookingId;
    private double amount;
    private ResponseStatus responseStatus;
}
