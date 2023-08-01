package keyclaoktest.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import keyclaoktest.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/hotels")
@Transactional
public class HotelController {

    @Autowired
    HotelRepository hotelRepository;

    @RequestMapping(
        value = "hotels/",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Hotel searchHotels(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody Hotel hotel
    ) throws Exception {
        System.out.println("##### /hotel/searchHotels  called #####");
        hotel.searchHotels(searchHotelscommand);
        hotelRepository.save(hotel);
        return hotel;
    }

    @RequestMapping(
        value = "hotels/viewhoteldetails",
        method = RequestMethod.GET,
        produces = "application/json;charset=UTF-8"
    )
    public Hotel viewHotelDetails(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody Hotel hotel
    ) throws Exception {
        System.out.println("##### /hotel/viewHotelDetails  called #####");
        hotel.viewHotelDetails(viewHotelDetailscommand);
        hotelRepository.save(hotel);
        return hotel;
    }

    @RequestMapping(
        value = "hotels/viewreservation",
        method = RequestMethod.GET,
        produces = "application/json;charset=UTF-8"
    )
    public Hotel viewReservation(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody Hotel hotel
    ) throws Exception {
        System.out.println("##### /hotel/viewReservation  called #####");
        hotel.viewReservation(viewReservationcommand);
        hotelRepository.save(hotel);
        return hotel;
    }
}
