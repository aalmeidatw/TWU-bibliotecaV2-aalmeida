package com.twu.provider;

import com.twu.types.Name;
import com.twu.types.book.AuthorName;
import com.twu.types.book.Book;
import com.twu.types.item.Item;
import com.twu.types.item.PublicationYear;
import com.twu.types.library.ItemLibrary;
import com.twu.types.movie.DirectorName;
import com.twu.types.movie.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class LibraryItems {

    private List<Item> itemsList = new ArrayList<>();

    public List<ItemLibrary> createItemListLibrary(){

        Item book1 = new Book(new Name("In Search of Lost Time"), new PublicationYear(1913), new AuthorName("Marcel Proust"));
        Item book2 = new Book(new Name("Moby Dick"), new PublicationYear(1851), new AuthorName("Herman Melville"));
        Item book3 = new Book(new Name("Ulysses"), new PublicationYear(1904), new AuthorName("James Joyce"));

        Item movie1 = new Movie(new Name("Mad Max"), new PublicationYear(2004), new DirectorName("George Miller"), 5);
        Item movie2 = new Movie(new Name("Spotlight"), new PublicationYear(2002), new DirectorName("Tom McCarthy"), 5);
        Item movie3 = new Movie(new Name("Inside Out"), new PublicationYear(2001), new DirectorName("Ronnie del Carmen"), 7);

        itemsList.addAll(asList(book1, book2, book3, movie1, movie2, movie3));

        return itemsList.stream()
                .map(item -> new ItemLibrary(item))
                .collect(Collectors.toList());
    }
}
