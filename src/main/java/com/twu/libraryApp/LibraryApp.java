package com.twu.libraryApp;

import com.twu.IO.MessagePrinter;
import com.twu.IO.ScannerInputUser;
import com.twu.control.Library;
import com.twu.control.ManagementUser;
import com.twu.menu.MenuOptions;
import com.twu.provider.LibraryItems;

public class LibraryApp {
    private final String ERROR_LOGIN_MESSAGE = "LOGIN FAIL - SYSTEM IS OUT!";

    public static void main(String[] args) {


        MessagePrinter messagePrinter = new MessagePrinter();
        ScannerInputUser scannerInputUser = new ScannerInputUser();
        Library library = new Library(new LibraryItems().createItemListLibrary(), new ManagementUser());
        MenuOptions menu = new MenuOptions(library, scannerInputUser, messagePrinter);

        String option;
        messagePrinter.welcomeMessage();

        if (menu.userLogin()) {

            do {
                messagePrinter.showMenuOptions();

                messagePrinter.print("Option: " + "\n\n");
                option = scannerInputUser.getUserInfoScanner();

                menu.menuOption(option);

            } while (!option.equals("Q"));
        } else {
            messagePrinter.print(ERROR_LOGIN_MESSAGE);

        }
    }

}
