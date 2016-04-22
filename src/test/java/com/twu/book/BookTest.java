package com.twu.book;

import com.twu.types.Name;
import com.twu.types.book.AuthorName;
import com.twu.types.book.Book;
import com.twu.types.item.PublicationYear;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class BookTest {
    private Book myBook;
    private final String BOOK_NAME = "O Vento";
    private final int PUBLICATION_YEAR =  1980;
    private final String AUTHOR_NAME = "João Simplicio";


    @Before
    public void setUp() throws Exception {
         this.myBook = new Book(new Name(BOOK_NAME),
                                new PublicationYear(PUBLICATION_YEAR),
                                new AuthorName(AUTHOR_NAME));
    }

    @Test
    public void shouldReturnBookName() throws Exception {
        assertThat(myBook.getBookName(), is(BOOK_NAME));
    }

    @Test
    public void shouldReturnAuthorName() throws Exception {
        assertThat(myBook.getAuthorName(), is(AUTHOR_NAME));
    }

    @Test
    public void shouldReturnPublicationYear() throws Exception {
        assertThat(myBook.getPublicationYear(), is(PUBLICATION_YEAR));
    }

}