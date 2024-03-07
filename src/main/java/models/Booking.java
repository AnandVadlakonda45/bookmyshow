package models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel {//Ticket

    @ManyToMany
    private List<ShowSeat> showSeats;

    @ManyToOne
    private User user;

    private double amount;

    @OneToMany
    List<Payment> payments;

    private BookingStatus bookingStatus;

}
