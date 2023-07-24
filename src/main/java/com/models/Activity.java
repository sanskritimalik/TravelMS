package main.java.com.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity : activity that can be performed at any destination
 */
public class Activity {
    private String id;
    private String name;
    private String description; 
    private Double cost;
    private Integer capacity;
    private Destination destination; //validation
    private List<Passenger> passengers;

    public Activity(String id, String name, String description, Double cost, Integer capacity, Destination destination) {
        if (destination == null) {
            throw new IllegalArgumentException("destination cannot be null");
        }
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.passengers = new ArrayList<>();
    }

    public Boolean addPassenger(Passenger passenger) {
        if (passengers.size() < capacity && !passengers.contains(passenger)) {
            passengers.add(passenger);
            return true;
        }
        return false;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public Integer getSpacesAvailable() {
        return capacity - passengers.size();
    }

    public Double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public Destination getDestination() {
        return destination;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " - " + description + " - Cost: $" + cost + " - Capacity: " + capacity;
    }
}
