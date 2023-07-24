package test.java.com.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import main.java.com.enums.PassengerType;
import main.java.com.models.Activity;
import main.java.com.models.Destination;
import main.java.com.models.Passenger;

import org.junit.Test;

/**
 * ActivityTest
 */
public class ActivityTest {

    private  Destination destination;
    private  Activity activity1;
    private  Activity activity2;

    @Before
    public void setUp() {
        destination = new Destination("id", "destination-1");
        activity1 = new Activity("act-1", "activity-1", "description-1", 100.0, 1, destination);
        activity2 = new Activity("act-2", "activity-2", "description-2", 50.0, 3, destination);
        destination.addActivity(activity1);
        destination.addActivity(activity2);
    }

    @Test
    public void testAddPassenger() {
        Passenger passenger1 = new Passenger("pass-1", "passenger1", 1234567890, PassengerType.STANDARD, 200.0);
        Passenger passenger2 = new Passenger("pass-2", "passenger2", 1234567890, PassengerType.STANDARD, 200.0);

        // add 1 passenger to activity 1 returns true as capacity is 1 and no initial
        // passengers present
        assertTrue(activity1.addPassenger(passenger1));
        // adding same passenger again returns false
        assertFalse(activity1.addPassenger(passenger1));
        // as capacity of passengers for activity is already full returns false
        assertFalse(activity1.addPassenger(passenger2));
    }

    @Test
    public void testSpacesAvailable() {
        // Initial capacity comparison
        Integer expectedSpace = 1;
        Integer actualSpace = activity1.getSpacesAvailable();
        Assert.assertEquals(expectedSpace, actualSpace);

        // Spaces available in case passenger is added
        Passenger passenger1 = new Passenger("pass-1", "passenger1", 1234567890, PassengerType.STANDARD, 200.0);
        activity1.addPassenger(passenger1);
        expectedSpace = 0;
        actualSpace = activity1.getSpacesAvailable();
        Assert.assertEquals(expectedSpace, actualSpace);
    }

    @Test
    public void testCost() {
        Double expectedCost = 100.0;
        Double actualCost = activity1.getCost();
        Assert.assertEquals(expectedCost, actualCost);
    }

    @Test
    public void testName() {
        String expectedName = "activity-1";
        String actualName = activity1.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void TestDestination() {
        Assert.assertEquals(destination, activity1.getDestination());
    }

}