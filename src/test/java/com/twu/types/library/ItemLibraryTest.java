package com.twu.types.library;

import com.twu.types.Name;
import com.twu.types.item.Item;
import com.twu.types.item.PublicationYear;
import com.twu.types.library.ItemLibrary;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class ItemLibraryTest {
    private ItemLibrary libraryItem;
    private static String ITEM_NAME = "Name1";
    private static int PUBLICATION_YEAR = 1900;
    private static  String EXPECTED = "Item Name: Name1";

    @Before
    public void setUp() throws Exception {
        this.libraryItem = new ItemLibrary(new Item(new Name(ITEM_NAME),
                                                    new PublicationYear(PUBLICATION_YEAR)));
     }

    @Test
    public void shouldSetItemAsNotAvailable() throws Exception {
        libraryItem.modifyAvailableItemStatus(false);
        assertThat(libraryItem.isAvailable(), is(false));
    }

    @Test
    public void shouldSetItemAsAvailable() throws Exception {
        libraryItem.modifyAvailableItemStatus(true);
        assertThat(libraryItem.isAvailable(), is(true));
    }

    @Test
    public void shouldReturnTrueWhenItemAsAvailable(){
        assertThat(libraryItem.isAvailable(), is (true));
    }

    @Test
    public void shouldReturnItemName(){
        assertThat(libraryItem.toString(), is(EXPECTED));
    }

    @Test
    public void  shouldModifyItemStatusAsAvailable(){
        this.libraryItem.modifyAvailableItemStatus(true);
        assertThat(this.libraryItem.isAvailable(), is(true));
    }

    @Test
    public void  shouldModifyItemStatusAsNotAvailable(){
        this.libraryItem.modifyAvailableItemStatus(false);
        assertThat(this.libraryItem.isAvailable(), is(false));
    }



}