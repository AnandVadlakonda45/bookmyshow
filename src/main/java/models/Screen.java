package models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{

    private String screenNumber;

    @OneToMany
    private List<Seat> seats;

    private List<Feature> features;

}
