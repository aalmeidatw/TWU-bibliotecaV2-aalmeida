package com.twu.menu;

import com.twu.IO.MessagePrinter;
import com.twu.control.Library;
import com.twu.control.ManagementUser;
import com.twu.menu.ItemsToReturnMenu;
import com.twu.provider.LibraryItems;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class ItemsToReturnMenuTest {
    private Library library;
    private static String MOVIE_NAME = "Mad Max";
    private ItemsToReturnMenu itemsToReturnMenu;


    @Mock
    MessagePrinter messagePrinterMock;
    ManagementUser managementUserMock;
    Library libraryMock;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        this.libraryMock = new Library(new LibraryItems().createItemListLibrary(), managementUserMock);
        this.itemsToReturnMenu = new ItemsToReturnMenu(libraryMock, messagePrinterMock);
    }

    @Test
    public void shouldExecutePrintMethod(){
        itemsToReturnMenu.execute();
        verify(messagePrinterMock).print(Mockito.anyString());
    }
}