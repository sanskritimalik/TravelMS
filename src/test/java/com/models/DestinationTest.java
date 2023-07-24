package test.java.com.models;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.com.exceptions.AlreadyExistsException;
import main.java.com.models.Activity;
import main.java.com.models.Destination;

public class DestinationTest {

    private Destination destination;
    private Activity activity1;
    private List<Activity> activities;

    @Before
    public void setUp() {
        destination = new Destination("id", "destination-1");
        activity1 = new Activity("act-1", "activity-1", "description-1", 100.0, 1, destination);
        activities = new ArrayList<>();
        activities.add(activity1);
    }

    @Test
    public void testGetActivities() {
        destination.addActivity(activity1);
        List<Activity> actualActivityList = destination.getActivities();
        List<Activity> expectedActivityList = new ArrayList<>();
        expectedActivityList.add(activity1);

        Assert.assertEquals(expectedActivityList, actualActivityList);
    }

    @Test(expected = AlreadyExistsException.class)
    public void testGetActivities_AlreadyExistsException() {
        destination.addActivity(activity1);
        destination.addActivity(activity1);
    }

    @Test
    public void testAddActivity_Success() {
        List<Activity> expectedActivityList = new ArrayList<>();
        expectedActivityList.add(activity1);
        destination.addActivity(activity1);
        Assert.assertEquals(expectedActivityList, destination.getActivities());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("destination-1", destination.getName());
    }

    @Test
    public void testSetName() {
        destination.setName("new-name");
        Assert.assertEquals("new-name", destination.getName());
    }

    @Test
    public void testToString() {
        destination.addActivity(activity1);
        String activityString = "";
        String expectedString = "";
        if (activities.size() > 0) {
            for (Activity activity : activities) {
                activityString += activity;
            }
            expectedString = "Destination: " + destination.getName() + " Activities: " + activityString;
        } else
            expectedString = "Destination: " + destination.getName();

        Assert.assertEquals(expectedString, destination.toString());
    }

}
