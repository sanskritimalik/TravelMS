package main.java.com.models;

import java.util.ArrayList;
import java.util.List;

public class Activity {
    private String id;
    private String name;
    private String description;
    private Double cost;
    private Integer capacity;
    private Destination destination;
    private List<Passenger> passengers;

    public Activity(String id, String name, String description, Double cost, Integer capacity, Destination destination) {
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

    @Override
    public String toString() {
        return name + " - " + description + " - Cost: $" + cost + " - Capacity: " + capacity;
    }
}
