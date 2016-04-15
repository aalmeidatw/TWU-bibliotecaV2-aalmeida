package com.twu.control;

import com.twu.exception.NameErrorException;
import com.twu.types.Name;
import com.twu.types.book.Book;
import com.twu.types.itemType.ItemType;
import com.twu.types.library.ItemLibrary;
import com.twu.types.movie.Movie;
import com.twu.types.user.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private List<ItemLibrary> libraryItems = new ArrayList<>();
    private ManagementUser managementUser;
    private User userAuthenticated;
    private static String ERROR_NAME_EXCEPTION = "ItemName Not Found - Try Again!";

    public Library(List<ItemLibrary> libraryItems, ManagementUser managementUser) {
        this.libraryItems = libraryItems;
        this.managementUser = managementUser;
    }

    public boolean loginUser(String user_name, String password) {
        return managementUser.loginUser(user_name, password);
    }

    public List<ItemLibrary> returnItemList(ItemType itemType) {

        if (isBook(itemType)) {
            return getAvailableBooks();

        } else if (isMovie(itemType)) {
            return getAvailableMovies();
        }
        return null;
    }

    public void setUserAuthenticated(User user) {
        this.userAuthenticated = new User(new Name(user.getName()),
                new NameLoginUser(user.getUserName()),
                new PasswordUser(user.getPassword()),
                new EmailUser(user.getEmail()),
                new PhoneNumberUser(user.getPhoneNumber())
        );
    }


    protected boolean isMovie(ItemType itemType) {
        return itemType.equals(ItemType.MOVIE);
    }

    protected boolean isBook(ItemType itemType) {
        return itemType.equals(ItemType.BOOK);
    }

    private List<ItemLibrary> getAvailableBooks() {
        return libraryItems.stream()
                .filter(itemLibrary -> isItemIsBookAndAvailableToLend(itemLibrary))
                .collect(Collectors.toList());
    }

    private List<ItemLibrary> getAvailableMovies() {
        return libraryItems.stream()
                .filter(itemLibrary -> isItemIsMovieAndAvailableToLend(itemLibrary))
                .collect(Collectors.toList());
    }

    private boolean isItemIsMovieAndAvailableToLend(ItemLibrary itemLibrary) {
        return itemLibrary.getItem() instanceof Movie && itemLibrary.isAvailable();
    }

    private boolean isItemIsBookAndAvailableToLend(ItemLibrary itemLibrary) {
        return itemLibrary.getItem() instanceof Book && itemLibrary.isAvailable();
    }

    public List<ItemLibrary> getAllItemsToReturn() {
        return libraryItems.stream()
                .filter(itemLibrary -> itemLibrary.isAvailable() == false)
                .collect(Collectors.toList());
    }

    public void lendItem(String name) throws Exception {
        ItemLibrary item = getLibraryItem(name);

        if (item != null) {
            item.modifyAvailableItemStatus(false);
        } else
            throw new NameErrorException(ERROR_NAME_EXCEPTION);
    }

    public void returnBorrowedItem(String name) throws Exception {
        ItemLibrary item = getLibraryItem(name);

        if (item != null) {
            item.modifyAvailableItemStatus(true);
        } else
            throw new NameErrorException(ERROR_NAME_EXCEPTION);
    }

    protected ItemLibrary getLibraryItem(String name) throws Exception {
        Optional<ItemLibrary> result = findLibraryItem(name);
        return result.orElse(null);
    }

    private Optional<ItemLibrary> findLibraryItem(String name) {
        return libraryItems
                .stream()
                .filter(item -> compareItemName(item, name))
                .findFirst();
    }

    private boolean compareItemName(ItemLibrary itemLibrary, String name) {
        return itemLibrary.getItem().getName().equals(name);
    }

    public String getUserInfo() {
        return userAuthenticated.getName() + " \n" +
                userAuthenticated.getUserName() + " \n" +
                userAuthenticated.getEmail() + " \n" +
                userAuthenticated.getPhoneNumber() + " \n";
    }

    public User returnUserInfo(String userName) {
        return managementUser.getUser(userName);
    }


}