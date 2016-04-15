package com.twu.menu;

import com.twu.IO.MessagePrinter;
import com.twu.IO.ScannerInputUser;
import com.twu.control.Library;
import com.twu.menu.ReturnItemMenu;
import com.twu.types.library.ItemLibrary;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;


public class ReturnItemMenuTest {
    private ReturnItemMenu returnItemMenu;
    private static String ITEM_NAME = "Mad Max";

    @Mock
    MessagePrinter messagePrinterMock;

    @Mock
    Library libraryMock;

    @Mock
    ScannerInputUser scannerInputUserMock;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

        this.returnItemMenu = new ReturnItemMenu(libraryMock, messagePrinterMock, scannerInputUserMock);
    }

    @Test
    public void shouldCallPrintListMethod() throws Exception {
        returnItemMenu.execute();
        verify(messagePrinterMock).printerItemList(anyListOf(ItemLibrary.class));
    }

    @Test
    public void shouldCallreturnBorrowedItemMethod() throws Exception {
        libraryMock.lendItem(ITEM_NAME);
        returnItemMenu.execute();
        verify(libraryMock).returnBorrowedItem(Mockito.anyString());
    }




}