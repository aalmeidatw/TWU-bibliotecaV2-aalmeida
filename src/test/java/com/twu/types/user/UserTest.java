package com.twu.types.user;

import com.twu.control.ManagementUser;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {
    private static String USER_NAME = "name_user01";
    private static String PASSWORD = "1111";
    private static String ERROR_PASSWORD = "asdf";
    private ManagementUser managementUser;

    @Before
    public void setUp() throws Exception {
        this.managementUser = new ManagementUser();
    }

    @Test
    public void shouldReturnTrueWhenPasswordPassedIsEqual(){
        assertThat(managementUser.getUser(USER_NAME).isPasswordCorrect(PASSWORD), is (true));
    }

    @Test
    public void shouldReturnFalseWhenPasswordPassedIsNotEqual(){
        assertThat(managementUser.getUser(USER_NAME).isPasswordCorrect(ERROR_PASSWORD), is (false));
    }
}