package test.java.com.models;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.com.enums.PassengerType;
import main.java.com.exceptions.AlreadyExistsException;
import main.java.com.exceptions.PassengerCapacityFullException;
import main.java.com.models.Activity;
import main.java.com.models.Destination;
import main.java.com.models.Passenger;
import main.java.com.models.TravelPackage;

public class TravelPackageTest {
    private TravelPackage travelPackage;
    private Destination destination;
    private Activity activity1;
    private Passenger passenger1;
    private List<Activity> activities;

    @Before
    public void setUp() {
        travelPackage = new TravelPackage("tp-1", "travel-pack-1", 1);
        passenger1 = new Passenger("pass-1", "passenger1", 1234567890, PassengerType.STANDARD, 200.0);
        destination = new Destination("id", "destination-1");
        activity1 = new Activity("act-1", "activity-1", "description-1", 100.0, 1, destination);
    }

    @Test(expected = AlreadyExistsException.class)
    public void testAddDestination_AlreadyExists() {
        travelPackage.addDestination(destination);
        travelPackage.addDestination(destination);
    }

    @Test
    public void testAddPassenger_Success() {
        travelPackage.addPassenger(passenger1);
        List<Passenger> expectedPassengerList = new ArrayList<>();
        expectedPassengerList.add(passenger1);
        Assert.assertEquals(expectedPassengerList, travelPackage.getPassengers());
    }

    @Test(expected = AlreadyExistsException.class)
    public void testAddPassenger_AlreadyExists() {
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger1);
    }

    @Test(expected = PassengerCapacityFullException.class)
    public void testAddPassenger_PassengerCapacityFull() {
        travelPackage.addPassenger(passenger1);
        Passenger passenger2 = new Passenger("pass-2", "passenger2", 1234567890, PassengerType.STANDARD, 200.0);
        travelPackage.addPassenger(passenger2);
        ;
    }

    @Test
    public void testPrintItinerary() {
        travelPackage.addDestination(destination);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent
        // stream.

        travelPackage.printItinerary();

        // Now you have to validate the output.
        String expectedOutput = "Travel Package: travel-pack-1\r\n" +
                "Destination: destination-1\r\n";

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintPassengerList() {
        travelPackage.setPassengerCapacity(2);
        Passenger passenger2 = new Passenger("pass-2", "passenger2", 1234567890, PassengerType.STANDARD, 200.0);
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent
        // stream.

        travelPackage.printPassengerList();

        // Now you have to validate the output.
        String expectedOutput = "Travel Package: travel-pack-1\r\n" +
                "Passenger Capacity: 2\r\n" +
                "Number of Passengers Enrolled: 2\r\n" +
                "Name: passenger1, Passenger Number: 1234567890\r\n" +
                "Name: passenger2, Passenger Number: 1234567890\r\n";

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());

    }

    @Test
    public void testPrintPassengerDetails() {
        passenger1.addActivity(activity1);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent
        // stream.

        travelPackage.printPassengerDetails(passenger1);

        // Now you have to validate the output.
        String expectedOutput = "Name: passenger1, Passenger Number: 1234567890, Balance: $100.0, Activities: activity-1 (Destination: Destination: destination-1, Price: $100.0)\r\n";

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintAvailableActivities() {
        travelPackage.addDestination(destination);
        destination.addActivity(activity1);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // After this all System.out.println() statements will come to outContent
        // stream.

        travelPackage.printAvailableActivities();

        // Now you have to validate the output.
        String expectedOutput = "Available Activities for travel-pack-1\r\n" +
                "activity-1 - description-1 - Cost: $100.0 - Capacity: 1 - Spaces Available: 1\r\n";
        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testGetDestinations() {
        travelPackage.addDestination(destination);
        List<Destination> expectedDestinationList = new ArrayList<>();
        expectedDestinationList.add(destination);

        Assert.assertEquals(expectedDestinationList, travelPackage.getDestinations());
    }

    @Test
    public void testGetPassengers() {
        travelPackage.addPassenger(passenger1);
        List<Passenger> expectedPassengerList = new ArrayList<>();
        expectedPassengerList.add(passenger1);

        Assert.assertEquals(expectedPassengerList, travelPackage.getPassengers());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("travel-pack-1", travelPackage.getName());
    }

    @Test
    public void testSetPassengerCapacity() {
        Integer expectedPassenegerCapacity = 3;
        travelPackage.setPassengerCapacity(expectedPassenegerCapacity);
        Assert.assertEquals(expectedPassenegerCapacity, travelPackage.getPassengerCapacity());
    }

    @Test
    public void testGetPassengerCapacity() {
        Integer expectedPassenegerCapacity = 1;
        Assert.assertEquals(expectedPassenegerCapacity, travelPackage.getPassengerCapacity());
    }
}
