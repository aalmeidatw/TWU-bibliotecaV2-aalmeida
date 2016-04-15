package com.twu.types;


import com.twu.types.item.PublicationYear;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PublicationYearTest {
    private PublicationYear publicationYear;

    @Before
    public void setUp() throws Exception {
        this.publicationYear = new PublicationYear(1930);
    }

    @Test
    public void shouldReturnPublicationYear() throws Exception {
        assertThat(publicationYear.getPublicationYear(), is (1930));

    }
}