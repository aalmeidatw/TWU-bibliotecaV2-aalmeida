package com.twu.control;


import com.twu.provider.LibraryItems;
import com.twu.provider.LibraryUsers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class ManagementUserTest {
    private ManagementUser managementUser;
    private LibraryUsers libraryUsers;
    private Library library;
    private static String USER_NAME = "name_user01";
    private static String USER_NAME_ERROR = "asd";
    private static String PASSWORD = "1111";


    @Before
    public void setUp() throws Exception {
        this.managementUser = new ManagementUser();
        this.library = new Library(new LibraryItems().createItemListLibrary(), new ManagementUser());
        this.libraryUsers = new LibraryUsers();
    }

    @Test
    public void shouldReturnNullWhenUserNameAsNotFound(){
        assertNull(managementUser.getUser(USER_NAME_ERROR));
     }

    @Test
    public void shouldReturnNotNullWhenUserNameAsFound(){
        assertNotNull(managementUser.getUser(USER_NAME));
    }

    @Test
    public void shouldReturnTrueWhenUserNameAndPasswordIsValid(){
        assertThat(managementUser.isUserRegistred(managementUser.getUser(USER_NAME), USER_NAME, PASSWORD), is (true));
    }

    @Test
    public void shouldReturnFalseWhenUserNameAndPasswordIsNotValid(){
        assertThat(managementUser.isUserRegistred(managementUser.getUser(USER_NAME), USER_NAME_ERROR, PASSWORD), is (false));
    }

    @Test
    public void shouldReturnTrueWhenUserIsLoggIn(){
        assertThat(managementUser.loginUser(USER_NAME, PASSWORD), is (true));
    }

    @Test
    public void shouldReturnFalseWhenUserIsNotLoggIn(){
        assertThat(managementUser.loginUser(USER_NAME_ERROR, PASSWORD), is (false));
    }

}
