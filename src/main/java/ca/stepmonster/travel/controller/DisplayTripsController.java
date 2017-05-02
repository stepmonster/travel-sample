package ca.stepmonster.travel.controller;

import ca.stepmonster.travel.model.Trip;
import ca.stepmonster.travel.service.DataService;
import com.vaadin.navigator.View;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by judy on 4/28/17.
 */
public class DisplayTripsController {


   @Inject
    DataService dataService;

   View displayTrips;

   public void setView(View view){
       this.displayTrips = view;
   }


    public List<Trip> getData(String user){
        return dataService.queryItinerariesForUser(user);

    }
}
