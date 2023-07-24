package test.java.com.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import main.java.com.models.User;

public class UserTest {

    private User user1;

    @Before
    public void setUp() {
        user1 = new User("user-id", "user-1");
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("user-1", user1.getName());
    }

    @Test
    public void testSetName() {
        user1.setName("new-name");
        Assert.assertEquals("new-name", user1.getName());
    }
}
