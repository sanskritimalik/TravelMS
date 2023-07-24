package main.java.com.models;

import java.util.ArrayList;
import java.util.List;

import main.java.com.enums.PassengerType;
import main.java.com.exceptions.TravelManagementSystemException;

public class Passenger extends User {
    private Integer passengerNumber;
    private PassengerType passengerType;
    private Double balance;
    private List<Activity> activities;

    public Passenger(String id, String name, Integer passengerNumber, PassengerType passengerType, Double balance) {
        super(id, name);
        this.passengerNumber = passengerNumber;
        this.passengerType = passengerType;
        this.balance = balance;
        this.activities = new ArrayList<>();
    }

    public boolean addActivity(Activity activity) {
        
        if (activities.contains(activity)) {
            return false;
        }

        switch (passengerType) {
            case STANDARD:
               if (balance >= activity.getCost()) {
                balance -= activity.getCost();
                activities.add(activity);
                activity.addPassenger(this);
                return true;
            }
            return false;

            case GOLD:
            Double discountedCost = activity.getCost() * 0.9;
            if (balance >= discountedCost) {
                balance -= discountedCost;
                activities.add(activity);
                activity.addPassenger(this);
                return true;
            }
            return false;

            case PREMIUM:
             activities.add(activity);
            activity.addPassenger(this);
            return true;

            default:
            throw new TravelManagementSystemException();
        }
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder();
        details.append("Name: ").append(super.getName()).append(", Passenger Number: ").append(passengerNumber);

        // if (passengerType == PassengerType.STANDARD || passengerType == PassengerType.GOLD) {
        //     details.append(", Balance: $").append(balance);
        // }

        // List<String> activityDetails = new ArrayList<>();
        // for (Activity activity : activities) {
        //     activityDetails.add(activity.getName() + " (Destination: " + activity.getDestinationId() + ", Price: $" + activity.getCost() + ")");
        // }

        // if (!activityDetails.isEmpty()) {
        //     details.append(", Activities: ").append(String.join(", ", activityDetails));
        // }

        return details.toString();
    }

    public String getPassengerDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Name: ").append(super.getName()).append(", Passenger Number: ").append(passengerNumber);

        if (passengerType == PassengerType.STANDARD || passengerType == PassengerType.GOLD) {
            details.append(", Balance: $").append(balance);
        }

        List<String> activityDetails = new ArrayList<>();
        for (Activity activity : activities) {
            activityDetails.add(activity.getName() + " (Destination: " + activity.getDestinationId() + ", Price: $" + activity.getCost() + ")");
        }

        if (!activityDetails.isEmpty()) {
            details.append(", Activities: ").append(String.join(", ", activityDetails));
        }

        return details.toString();
    }
}


