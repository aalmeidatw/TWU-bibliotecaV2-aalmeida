package com.twu.control;

import com.twu.provider.LibraryItems;
import com.twu.types.itemType.ItemType;
import com.twu.types.library.ItemLibrary;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class LibraryTest {
    private Library library;
    private final String BOOK_NAME = "In Search of Lost Time";
    private final String BOOK_NAME_NOT_EXIST = "BookNotExist";
    private final String MOVIE_NAME = "Mad Max";
    private final String USER_NAME = "name_user01";
    private final String PASSWORD = "1111";
    private final String ERROR_PASSWORD = "@qweAr";

    @Mock
    ManagementUser managementUserMock;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

        when(managementUserMock.loginUser(USER_NAME, PASSWORD)).thenReturn(true);
        when(managementUserMock.loginUser(USER_NAME, ERROR_PASSWORD)).thenReturn(false);

        this.library = new Library(new LibraryItems().createItemListLibrary(), managementUserMock);
    }

    @Test
    public void shouldReturnItemWhenPassedItemName() throws Exception {
        ItemLibrary item = library.getLibraryItem(MOVIE_NAME);
        assertThat(item.getItem().getName(), is(MOVIE_NAME));
    }

    @Test
    public void shouldReturnNullWhenBookNameIsNotFound() throws Exception {
        assertNull(library.getLibraryItem(BOOK_NAME_NOT_EXIST));
    }

    @Test
    public void shouldReturnTrueWhenIsUserAuthenticated(){
        boolean result = library.loginUser(USER_NAME, PASSWORD);
        verify(managementUserMock).loginUser(USER_NAME, PASSWORD);
        assertThat(result, is(true));
    }

    @Test
    public void shouldReturnFalseWhenIsUserIsNotAuthenticated(){
        boolean result = library.loginUser(USER_NAME, ERROR_PASSWORD);
        verify(managementUserMock).loginUser(USER_NAME, ERROR_PASSWORD);
        assertThat(result, is(false));
    }

    @Test
    public void shouldReturnUserPassedUserName(){
        library.returnUserInfo(USER_NAME);
        verify(managementUserMock).getUser(USER_NAME);
    }

    @Test
    public void shouldReturnLibraryMovieList(){
        List<ItemLibrary> items = library.returnItemList(ItemType.MOVIE);
        assertThat(items.get(0).getItem().getName(), is(MOVIE_NAME));
    }

    @Test
    public void shouldReturnLibraryBookList(){
        List<ItemLibrary> items = library.returnItemList(ItemType.BOOK);
        assertThat(items.get(0).getItem().getName(), is(BOOK_NAME));
    }

    @Test
    public void shouldReturnTrueWhenItemTypeIsBook(){
        assertThat(library.isBook(ItemType.BOOK), is (true));
    }

    @Test
    public void shouldReturnFalseWhenItemTypeIsNotBook(){
        assertThat(library.isBook(ItemType.MOVIE), is (false));
    }

    @Test
    public void shouldReturnTrueWhenItemTypeIsMovie(){
        assertThat(library.isMovie(ItemType.MOVIE), is (true));
    }

    @Test
    public void shouldReturnFalseWhenItemTypeIsNotMovie(){
        assertThat(library.isMovie(ItemType.BOOK), is (false));
    }

    @Test
    public void shouldReturnItemListOfReturn() throws Exception {
        library.lendItem(MOVIE_NAME);
        List<ItemLibrary> returnList = library.getAllItemsToReturn();
        assertThat(returnList.get(0).getItem().getName(), is(MOVIE_NAME));
    }
}