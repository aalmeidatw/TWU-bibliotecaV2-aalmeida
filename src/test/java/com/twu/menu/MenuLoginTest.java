package com.twu.menu;


import com.twu.IO.MessagePrinter;
import com.twu.IO.ScannerInputUser;
import com.twu.control.Library;
import com.twu.control.ManagementUser;
import com.twu.menu.LoginMenu;
import com.twu.provider.LibraryItems;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class MenuLoginTest {
    private LoginMenu loginMenu;
    private Library library;
    private static String USER_NAME = "name_user01";
    private static String PASSWORD = "1111";
    private static String ERROR_PASSWORD = "@qweAr";

    @Mock
    Library libraryMock;

    @Mock
    MessagePrinter messagePrinterMock;

    @Mock
    ScannerInputUser scannerInputUserMock;

    @Mock
    ManagementUser managementUserMock;


    @Before
    public void setUp() throws Exception {
        initMocks(this);
        this.loginMenu = new LoginMenu(libraryMock, messagePrinterMock, scannerInputUserMock);
    }

    @Test
    public void shouldReturnTrueWhenUserAsAuthenticated() throws Exception {
        loginMenu.setUserStatus(USER_NAME, PASSWORD);
        verify(libraryMock).loginUser(Mockito.anyString(), Mockito.anyString());
    }

    @Test
    public void shouldReturnTrueWhenUserAsNotAuthenticated() throws Exception {
        loginMenu.setUserStatus(USER_NAME, ERROR_PASSWORD);
        assertThat(loginMenu.isUserAuthenticated(), is(false));
    }
}