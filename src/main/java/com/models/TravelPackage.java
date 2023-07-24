package main.java.com.models;

import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;

import main.java.com.exceptions.PassengerCapacityFullException;

/**
 * TravelPackage
 */
public class TravelPackage {
    private String id;
    private String name;
    private Integer passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String id, String name, int passengerCapacity) {
        this.id = id;
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.contains(passenger)) {
          throw new AlreadyExistsException();
        }
        if (passengers.size() >= passengerCapacity) {
            throw new PassengerCapacityFullException();
        }
            passengers.add(passenger);
    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println(destination);
        }
    }

    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println(passenger);
        }
    }

    public void printPassengerDetails(Passenger passenger) {
        passenger.getPassengerDetails();
    }
// fine
    public void printAvailableActivities() {
        System.out.println("Available Activities for " + name);
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                int spacesAvailable = activity.getSpacesAvailable();
                System.out.println(activity + " - Spaces Available: " + spacesAvailable);
            }
        }
    }
}