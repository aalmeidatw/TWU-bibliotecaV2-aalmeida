package com.twu.provider;

import com.twu.types.Name;
import com.twu.types.user.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryUsers {

    private List<User> libraryUsers = new ArrayList<>();
    private static String NAME = "name_user";
    private static String NAME_USER = "name_user01";
    private static String PASSWORD = "1111";
    private static String EMAIL = "user@provider.com";
    private static int PHONE = 12345678;

    private static String NAME_2 = "name_user2";
    private static String NAME_USER_2 = "name_user02";
    private static String PASSWORD_2 = "@asdf";
    private static String EMAIL_2 = "user@provider.com";
    private static int PHONE_2 = 99553266;

    public List<User> createLibraryUsers(){

        User user1 = new User(new Name(NAME),
                     new NameLoginUser(NAME_USER),
                     new PasswordUser(PASSWORD),
                     new EmailUser(EMAIL),
                     new PhoneNumberUser(PHONE));

        User user2 = new User(new Name(NAME_2),
                     new NameLoginUser(NAME_USER_2),
                     new PasswordUser(PASSWORD_2),
                     new EmailUser(EMAIL_2),
                     new PhoneNumberUser(PHONE_2));

        libraryUsers.addAll(Arrays.asList(user1,user2));

        return libraryUsers;
    }

}
