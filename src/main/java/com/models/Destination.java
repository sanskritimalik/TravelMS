package main.java.com.models;

import java.util.ArrayList;
import java.util.List;

import main.java.com.exceptions.AlreadyExistsException;

/**
 * Destination - a destination that can be covered as part of a travel package
 */
public class Destination {
    private String id;
    private String name;
    private List<Activity> activities;

    public Destination(String id, String name) {
        this.id = id;
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public void addActivity(Activity activity) {
        if (activities.contains(activity))
        throw new AlreadyExistsException();
        activities.add(activity);
    }

    public List<Activity> getActivities() {
        return activities;
    } 

    public String getName() {
        return name;
    }

    public void setName(String name) {
     this.name = name;
    }

    @Override 
    public String toString() {
        String activityString = "";
        if (activities.size() > 0) {
        for (Activity activity : activities) {
            activityString += activity;
        }
        return "Destination: " + name + " Activities: " + activityString;
    }
        return "Destination: " + name;
    }
}
