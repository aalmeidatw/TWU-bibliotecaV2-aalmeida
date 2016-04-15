package com.twu.menu;

import com.twu.IO.MessagePrinter;
import com.twu.control.Library;
import com.twu.menu.MovieListMenu;
import com.twu.types.Name;
import com.twu.types.item.PublicationYear;
import com.twu.types.itemType.ItemType;
import com.twu.types.library.ItemLibrary;
import com.twu.types.movie.DirectorName;
import com.twu.types.movie.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static java.util.Arrays.asList;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class MovieListMenuTest {
    static String NAME =  "name";
    private static int PUBLICATION_YEAR = 1244;
    private static String AUTHOR_NAME = "AUTHOR_NAME";
    private MovieListMenu movieListMenu;

    @Mock
    MessagePrinter messagePrinterMock;

    @Mock
    Library libraryMock;


    @Before
    public void setUp() throws Exception {
        initMocks(this);

        ItemLibrary movie = new ItemLibrary(new Movie(new Name(NAME),
                                            new PublicationYear(PUBLICATION_YEAR),
                                            new DirectorName(AUTHOR_NAME), 4));

        when(libraryMock.returnItemList(ItemType.MOVIE)).thenReturn(asList(movie));

        this.movieListMenu = new MovieListMenu(libraryMock, messagePrinterMock);
    }

    @Test
    public void shouldCallPrintListMethod() throws Exception {
        movieListMenu.execute();
        verify(messagePrinterMock).printerItemList(anyListOf(ItemLibrary.class));
    }

    @Test
    public void shouldCallPrintMethod() throws Exception {
        movieListMenu.execute();
        verify(messagePrinterMock).print(anyString());
    }
}