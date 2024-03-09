package models;

import jakarta.persistence.*;
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

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

}
