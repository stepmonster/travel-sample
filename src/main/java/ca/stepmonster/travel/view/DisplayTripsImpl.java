package ca.stepmonster.travel.view;


import ca.stepmonster.travel.controller.DisplayTripsController;

import ca.stepmonster.travel.model.Trip;

import com.vaadin.data.provider.GridSortOrderBuilder;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.DateRenderer;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by judy on 4/28/17.
 */
public class DisplayTripsImpl extends VerticalLayout implements DisplayTrips, View {
    private Grid<Trip> grid;

    @Inject
    private DisplayTripsController controller;

    public DisplayTripsImpl() {
        super();
        grid = new Grid<>();
    }

    @PostConstruct
    public void init(){
        controller.setView(this);
        setData(controller.getData("Judy"));
        addComponent(grid);
    }

    @Override
    public void setData(List<Trip> trips){
        setUpGrid(trips);
    }

    private void setUpGrid(List<Trip> trips) {
       grid.setItems(trips);
       grid.setWidth(100, Unit.PERCENTAGE);
       Grid.Column name = grid.addColumn(Trip::getDisplayName).setCaption("Name").setSortable(true);
       Grid.Column start = grid.addColumn(Trip::getStartTime).setCaption("Start").setRenderer(new DateRenderer()).setSortable(true);
       Grid.Column end = grid.addColumn(Trip::getEndTime).setCaption("End").setRenderer(new DateRenderer()).setSortable(true);
       grid.addColumn(Trip::getDescription).setCaption("Description");
       GridSortOrderBuilder gridSortOrderBuilder = new GridSortOrderBuilder();
       grid.setSortOrder(gridSortOrderBuilder.thenAsc(start));

    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
