package keyclaoktest.infra;

import keyclaoktest.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class HotelHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Hotel>> {

    @Override
    public EntityModel<Hotel> process(EntityModel<Hotel> model) {
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/viewhoteldetails"
                )
                .withRel("viewhoteldetails")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() + "/viewreservation"
                )
                .withRel("viewreservation")
        );

        return model;
    }
}
