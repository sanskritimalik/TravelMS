package main.java.com.models;

import java.util.ArrayList;
import java.util.List;
import main.java.com.exceptions.*;

/**
 * TravelPackage - A package to be maintained by different travel agencies comprising of passenger
 * details & itinerary.
 */
public class TravelPackage {
    private String id;
    private String name;
    private Integer passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    // Constructor to initialize a travel package
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

    // Prints Itinerary associated with a travel package
    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println(destination);
        }
    }

    // Prints Passenger List associated with a travel package
    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println(passenger);
        }
    }

    // Prints passenger details corresponding to each passenger
    public void printPassengerDetails(Passenger passenger) {
        passenger.getPassengerDetails();
    }

    // Prints available activities corresponding to each destination
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