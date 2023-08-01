package keyclaoktest.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import keyclaoktest.HotelReservationApplication;
import keyclaoktest.domain.CancelReservation;
import keyclaoktest.domain.RoomReservation;
import lombok.Data;

@Entity
@Table(name = "Hotel_table")
@Data
public class Hotel {

    @Id
    private String name;

    private String location;

    @ElementCollection
    private List<String> roomTypes;

    private roomTypesType roomTypesType;

    @ElementCollection
    private List<Date> availableDates;

    private Money price;

    @PostPersist
    public void onPostPersist() {
        RoomReservation roomReservation = new RoomReservation(this);
        roomReservation.publishAfterCommit();

        CancelReservation cancelReservation = new CancelReservation(this);
        cancelReservation.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static HotelRepository repository() {
        HotelRepository hotelRepository = HotelReservationApplication.applicationContext.getBean(
            HotelRepository.class
        );
        return hotelRepository;
    }

    public void searchHotels(SearchHotelsCommand searchHotelsCommand) {
        //implement business logic here:

        HotelSearch hotelSearch = new HotelSearch(this);
        hotelSearch.set(searchHotelsCommand.get());
        hotelSearch.publishAfterCommit();
    }

    public void viewHotelDetails(
        ViewHotelDetailsCommand viewHotelDetailsCommand
    ) {
        //implement business logic here:

        ViewHotelDetails viewHotelDetails = new ViewHotelDetails(this);
        viewHotelDetails.set(viewHotelDetailsCommand.get());
        viewHotelDetails.publishAfterCommit();
    }

    public void viewReservation(ViewReservationCommand viewReservationCommand) {
        //implement business logic here:

        ViewReservation viewReservation = new ViewReservation(this);
        viewReservation.set(viewReservationCommand.get());
        viewReservation.publishAfterCommit();
    }
}
