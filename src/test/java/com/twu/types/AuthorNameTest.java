package com.twu.types;


import com.twu.types.book.AuthorName;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AuthorNameTest {
    private AuthorName authorName;

    @Before
    public void setUp() throws Exception {
        this.authorName = new AuthorName("Jonny");
    }

    @Test
    public void shouldReturnAutorName() throws Exception {
        assertThat(authorName.getAuthorName(), is ("Jonny"));
    }
}