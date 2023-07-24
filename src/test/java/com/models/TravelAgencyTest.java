package test.java.com.models;

import org.junit.Before;
import org.junit.Test;

import main.java.com.exceptions.AlreadyExistsException;
import main.java.com.models.TravelAgency;
import main.java.com.models.TravelPackage;

public class TravelAgencyTest {

    private TravelAgency travelAgency;

    @Before
    public void setUp() {
        travelAgency = new TravelAgency("travel-agency-1");
    }

    @Test
    public void testAddTravelPackage_Success() {
        TravelPackage travelPackage = new TravelPackage("tp-1", "travel-pack-1", 1);
        travelAgency.addTravelPackage(travelPackage);
    }

    @Test(expected = AlreadyExistsException.class)
    public void testAddTravelPackage_AlreadyExists() {
        TravelPackage travelPackage = new TravelPackage("tp-1", "travel-pack-1", 1);
        travelAgency.addTravelPackage(travelPackage);
        travelAgency.addTravelPackage(travelPackage);
    }
}
