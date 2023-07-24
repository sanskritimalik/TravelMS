package main.java.com.models;

import java.util.ArrayList;
import java.util.List;

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
        activities.add(activity);
    }

    public List<Activity> getActivities() {
        return activities;
    } 

    @Override 
    public String toString() {
        String activityString = "";
        for (Activity activity : activities) {
            activityString += activity;
        }
        return "Destination: " + name + "Activities: " + activityString;
    }
}
