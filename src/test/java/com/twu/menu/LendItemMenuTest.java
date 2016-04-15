package com.twu.menu;

import com.twu.IO.MessagePrinter;
import com.twu.IO.ScannerInputUser;
import com.twu.control.Library;
import com.twu.control.ManagementUser;
import com.twu.provider.LibraryItems;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;


public class LendItemMenuTest {
    private LendItemMenu lendItemMenu;
    private static String MESSAGE = "message";

    @Mock
    Library libraryMock;

    @Mock
    MessagePrinter messagePrintMock;

    @Mock
    ManagementUser managementUserMock;

    @Mock
    ScannerInputUser scannerMock;


    @Before
    public void setUp() throws Exception {
        initMocks(this);
        this.lendItemMenu = new LendItemMenu(libraryMock, messagePrintMock, scannerMock);
    }

   @Test
    public void shouldTestIfPrintIsCalled() throws Exception {
        lendItemMenu.execute();
        verify(messagePrintMock).print(Mockito.anyString());
     }
}