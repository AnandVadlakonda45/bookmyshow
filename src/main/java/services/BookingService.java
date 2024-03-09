package services;

import exceptions.ShowNotFoundException;
import exceptions.ShowSeatNotAvailableException;
import exceptions.UserNotFoundException;
import models.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ShowRepository;
import repositories.ShowSeatRepository;
import repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    public BookingService(UserRepository userRepository,ShowRepository showRepository,ShowSeatRepository showSeatRepository){

        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId , Long showId , List<Long> showSeatIds){

        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("Invalid UserId");
        }
        User bookedBy = optionalUser.get();

        Optional<Show> optionalShow = showRepository.findById(showId);

        if (optionalShow.isEmpty()){
            throw new ShowNotFoundException("Invalid showId");
        }

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for (ShowSeat showSeat: showSeats ){
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatNotAvailableException("showSeatWithId: " +showSeat.getId() + "isn't available.");
            }
        }

        for (ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);


        }

        return null;
    }

}
