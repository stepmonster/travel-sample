package ca.stepmonster.travel.models;

import ca.stepmonster.travel.model.Trip;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Created by judy on 4/26/17.
 */
public class TripTest {
    private Trip trip;
    private Date start = Calendar.getInstance().getTime();

    private Date end = null;




    @Test
    public void testGetStartTime() throws Exception {
        assertEquals(start, trip.getStartTime());
    }

    @Test
    public void testGetEndTime() throws Exception {
        assertEquals(end, trip.getEndTime() );
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Tahit", trip.getName());
    }

    @Test
    public void testGetUserName() throws Exception {
        assertEquals("skippy", trip.getUserName());

    }

    @Test
    public void testGetDescription() throws Exception {
        assertNull(trip.getDescription());
    }

    @Test
    public void testSetStartTime() throws Exception {
        LocalDateTime ldt = LocalDateTime.of(2018, Month.NOVEMBER,
                1, 6, 30);
        Date newStart = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        trip.setStartTime(newStart);
        assertEquals(newStart, trip.getStartTime());
        trip.setStartTime(start);
    }

    @Test
    public void testSetEndTime() throws Exception {
        LocalDateTime ldt = LocalDateTime.of(2018, Month.DECEMBER,
                21, 20, 20);
        Date newEnd = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        trip.setEndTime(newEnd);
        assertEquals(newEnd, trip.getEndTime());
        trip.setEndTime(end);
    }

    @Test
    public void testSetName() throws Exception {
    }

    @Test
    public void testSetDescription() throws Exception {
    }


    @BeforeEach
    void setUp() {
        trip = new Trip( "Tahiti", "skippy", start, end,null);
        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.WEEK_OF_YEAR, 1);
        end = cal.getTime();
    }

}