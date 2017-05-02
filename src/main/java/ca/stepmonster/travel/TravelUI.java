package ca.stepmonster.travel;

import javax.inject.Inject;

import ca.stepmonster.travel.view.DisplayTrips;
import ca.stepmonster.travel.view.DisplayTripsImpl;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;

import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ca.stepmonster.travel.model.User;

/**
 * Main app view for Travel
 */
@Theme("mytheme")
@Widgetset("ca.stepmonster.MyAppWidgetset")
@CDIUI("")
@SuppressWarnings("serial")
public class TravelUI extends UI {

    private User user = new User("Judy", "admin");

    @Inject
    private DisplayTrips displayTrips;


    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setWidth(100, Unit.PERCENTAGE);
        layout.setMargin(true);
        setContent(layout);
        Label label = new Label("Trips for " + user.getDisplayName());
        label.setWidth(100, Unit.PERCENTAGE);

        layout.addComponents(label, (DisplayTripsImpl)displayTrips);

    }



}
