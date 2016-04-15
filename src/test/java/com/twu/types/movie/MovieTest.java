package com.twu.types.movie;

import com.twu.types.Name;
import com.twu.types.item.PublicationYear;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MovieTest {
    Movie movie;

    @Before
    public void setUp() throws Exception {
        this.movie = new Movie(new Name("MovieName1"), new PublicationYear(1900), new DirectorName("Director1"), 10);
    }

    @Test
    public void shouldReturnDirectorName() throws Exception {
        assertThat(movie.getName(), is("MovieName1"));

    }

    @Test
    public void shouldReturnItemType() throws Exception {
        assertThat(movie.getPublicationYear(), is(1900));

    }

    @Test
    public void shouldReturnRateValue() throws Exception {
        assertThat(movie.getRate(), is(10));

    }
}