package ca.stepmonster.travel.models;

import ca.stepmonster.travel.model.User;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.runner.manipulation.Filter;


/**
 * Created by judy on 4/26/17.
 */
public class UserTest {
    private User user;
    private String firstName = "skippy";
    private String password = "testpassword";

    @BeforeEach
    void setUp() {
        user = new User(firstName, password );
    }

    public void tearDown() throws Exception {
        user = null;
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals(firstName, user.getName());
    }

    @Test
    public void testGetPassword() throws Exception {
        assertEquals(password, user.getPassword());

    }

    @Test
    public void testSetPassword() throws Exception {
        user.setPassword(null);
        assertNotNull("password should never be null", user.getPassword());
    }

}