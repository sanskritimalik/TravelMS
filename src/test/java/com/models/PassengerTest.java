package test.java.com.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import main.java.com.enums.PassengerType;
import main.java.com.models.Activity;
import main.java.com.models.Destination;
import main.java.com.models.Passenger;

public class PassengerTest {

    private Destination destination;
    private Activity activity1;
    private Passenger passenger1;
    private List<Activity> activities;

    @Before
    public void setUp() {
        passenger1 = new Passenger("pass-1", "passenger1", 1234567890, PassengerType.STANDARD, 200.0);
        destination = new Destination("id", "destination-1");
        activity1 = new Activity("act-1", "activity-1", "description-1", 100.0, 1, destination);
        activities = new ArrayList<>();
        activities.add(activity1);
    }

    @Test
    public void testAddActivity_Success_Standard() {
        assertTrue(passenger1.addActivity(activity1));

        List<Passenger> expectedPassengerListForActivity = new ArrayList<>();
        expectedPassengerListForActivity.add(passenger1);

        Assert.assertEquals(activities, passenger1.getActivities());
        Assert.assertEquals(expectedPassengerListForActivity, activity1.getPassengers());
    }

    @Test
    public void testAddActivity_InsufficientBalance_Standard() {
        passenger1.setBalance(50.0);
        assertFalse(passenger1.addActivity(activity1));

        Assert.assertEquals(0, activity1.getPassengers().size());
        Assert.assertEquals(0, passenger1.getActivities().size());
    }

    @Test
    public void testAddActivity_Success_Gold() {
        passenger1.setPassengerType(PassengerType.GOLD);
        assertTrue(passenger1.addActivity(activity1));

        List<Passenger> expectedPassengerListForActivity = new ArrayList<>();
        expectedPassengerListForActivity.add(passenger1);

        Assert.assertEquals(activities, passenger1.getActivities());
        Assert.assertEquals(expectedPassengerListForActivity, activity1.getPassengers());
    }

    @Test
    public void testAddActivity_InsufficientBalance_Gold() {
        passenger1.setPassengerType(PassengerType.GOLD);
        passenger1.setBalance(50.0);
        assertFalse(passenger1.addActivity(activity1));

        Assert.assertEquals(0, activity1.getPassengers().size());
        Assert.assertEquals(0, passenger1.getActivities().size());
    }

    @Test
    public void testAddActivity_Success_Premium() {
        passenger1.setPassengerType(PassengerType.PREMIUM);
        passenger1.setBalance(0.0);

        assertTrue(passenger1.addActivity(activity1));

        List<Passenger> expectedPassengerListForActivity = new ArrayList<>();
        expectedPassengerListForActivity.add(passenger1);

        Assert.assertEquals(activities, passenger1.getActivities());
        Assert.assertEquals(expectedPassengerListForActivity, activity1.getPassengers());
    }

    @Test
    public void testAddActivity_AlreadyExists() {
        passenger1.addActivity(activity1);
        assertFalse(passenger1.addActivity(activity1));
    }

    @Test
    public void testGetPassengerDetails() {
        passenger1.addActivity(activity1);
        StringBuilder details = new StringBuilder();
        details.append("Name: ").append(passenger1.getName()).append(", Passenger Number: ")
                .append(passenger1.getPassengerNumber());

        if (passenger1.getPassengerType() == PassengerType.STANDARD
                || passenger1.getPassengerType() == PassengerType.GOLD) {
            details.append(", Balance: $").append(passenger1.getBalance());
        }

        List<String> activityDetails = new ArrayList<>();
        for (Activity activity : activities) {
            activityDetails.add(activity.getName() + " (Destination: " + activity.getDestination() + ", Price: $"
                    + activity.getCost() + ")");
        }

        if (!activityDetails.isEmpty()) {
            details.append(", Activities: ").append(String.join(", ", activityDetails));
        }

        String expectedDetails = details.toString();
        Assert.assertEquals(expectedDetails, passenger1.getPassengerDetails());
    }

    @Test
    public void testToString() {
        StringBuilder details = new StringBuilder();
        details.append("Name: ").append(passenger1.getName()).append(", Passenger Number: ")
                .append(passenger1.getPassengerNumber());
        String expectedToString = details.toString();
        Assert.assertEquals(expectedToString, passenger1.toString());
    }

    @Test
    public void testGetActivities() {
        passenger1.addActivity(activity1);
        Assert.assertEquals(activities, passenger1.getActivities());
    }

    @Test
    public void testSetPassengerType() {
        passenger1.setPassengerType(PassengerType.GOLD);
        Assert.assertEquals(PassengerType.GOLD, passenger1.getPassengerType());
    }

    @Test
    public void testGetPassengerType() {
        Assert.assertEquals(PassengerType.STANDARD, passenger1.getPassengerType());
    }

    @Test
    public void testSetBalance() {
        Double balance = 50.0;
        passenger1.setBalance(balance);
        Assert.assertEquals(balance, passenger1.getBalance());
    }

    @Test
    public void testGetBalance() {
        Double balance = 200.0;
        Assert.assertEquals(balance, passenger1.getBalance());
    }

    @Test
    public void testGetPassengerNumber() {
        Integer passengerNumber = 1234567890;
        Assert.assertEquals(passengerNumber, passenger1.getPassengerNumber());
    }

}
