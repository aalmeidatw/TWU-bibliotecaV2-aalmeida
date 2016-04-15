package com.twu.types.user;

import com.twu.types.Name;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserLoginTest {
    private User user;
    private static String NAME_OF_USER = "USER_NAME";
    private static String USER_NAME = "user_01";
    private static String EMAIL_USER = "email@user.com";
    private static String CORRECT_PASSWORD = "asdf-qwer";
    private static int PHONE_NUMBER = 12345678;
    private static String ERROR_PASSWORD = "qwer-ssd";


    @Before
    public void setUp() throws Exception {
        this.user = new User( new Name(NAME_OF_USER),
                              new NameLoginUser(USER_NAME),
                              new PasswordUser(CORRECT_PASSWORD),
                              new EmailUser(EMAIL_USER),
                              new PhoneNumberUser(PHONE_NUMBER));
    }

    @Test
    public void shouldReturnTrueWhenPassWordPassedIsCorrect(){
        assertThat(user.isPasswordCorrect(CORRECT_PASSWORD), is (true));
    }

    @Test
    public void shouldReturnTrueWhenPassWordPassedIsNotCorrect(){
        assertThat(user.isPasswordCorrect(ERROR_PASSWORD), is (false));
    }
}