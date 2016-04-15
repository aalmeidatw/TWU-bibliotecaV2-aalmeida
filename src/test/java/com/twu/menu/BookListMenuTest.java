package com.twu.menu;

import com.twu.IO.MessagePrinter;
import com.twu.control.Library;
import com.twu.types.Name;
import com.twu.types.book.AuthorName;
import com.twu.types.book.Book;
import com.twu.types.item.PublicationYear;
import com.twu.types.itemType.ItemType;
import com.twu.types.library.ItemLibrary;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class BookListMenuTest {
    private static String MESSAGE = "message to print";
    private static String NAME =  "name";
    private static int PUBLICATION_YEAR = 1244;
    private static String AUTHOR_NAME = "AUTHOR_NAME";
    private List<ItemLibrary> itemList = new ArrayList<>();
    private BookListMenu bookListMenu;

    @Mock
    MessagePrinter messagePrinterMock;

    @Mock
    Library libraryMock;



    @Before
    public void setUp()  {
        initMocks(this);

        ItemLibrary book = new ItemLibrary(new Book(new Name(NAME), new PublicationYear(PUBLICATION_YEAR), new AuthorName(AUTHOR_NAME)));

        when(libraryMock.returnItemList(ItemType.BOOK)).thenReturn(asList(book));

        this.bookListMenu = new BookListMenu(libraryMock, messagePrinterMock);
     }

    @Test
    public void shouldCallPrintListMethod() throws Exception {
        bookListMenu.execute();
        verify(messagePrinterMock).printerItemList(anyListOf(ItemLibrary.class));
    }

    @Test
    public void shouldCallPrintMethod() throws Exception {
        bookListMenu.execute();
        verify(messagePrinterMock).print(Mockito.anyString());
    }




}