package keyclaoktest.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class SearchHotelsCommand {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String name;

    private String location;
    private List<String> roomTypes;
    private roomTypesType roomTypesType;
    private List<Date> availableDates;
    private Money price;
}
