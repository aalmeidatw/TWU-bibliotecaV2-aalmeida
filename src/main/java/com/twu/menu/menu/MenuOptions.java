package com.twu.menu.menu;

import com.twu.IO.MessagePrinter;
import com.twu.IO.ScannerInputUser;
import com.twu.control.Library;
import com.twu.menu.*;

import java.util.HashMap;
import java.util.Map;

public class MenuOptions {
    private Library library;
    private ScannerInputUser scannerInputUser;
    private MessagePrinter messagePrinter;
    private LoginMenu loginMenu;

    public MenuOptions(Library library, ScannerInputUser scannerInputUser, MessagePrinter messagePrinter) {
        this.library = library;
        this.scannerInputUser = scannerInputUser;
        this.messagePrinter = messagePrinter;
        this.loginMenu = new LoginMenu(library, messagePrinter, scannerInputUser);
    }

    public void menuOption(String option) {

        Map<String, Menu> map = new HashMap<>();
        map.put("1", new BookListMenu(library, messagePrinter));
        map.put("2", new MovieListMenu(library, messagePrinter));
        map.put("3", new LendItemMenu(library, messagePrinter, scannerInputUser));
        map.put("4", new ReturnItemMenu(library, messagePrinter, scannerInputUser));
        map.put("5", new UserInfoMenu(library, messagePrinter));
        map.put("Q", new MovieListMenu(library, messagePrinter));

        map.get(option).execute();


        switch (option) {

            case "Q":
                messagePrinter.print("Exit of System");
                break;

            default:
                messagePrinter.print("Select a valid option!");
                break;
        }
    }


     public boolean userLogin(){
        loginMenu.execute();

        return loginMenu.isUserAuthenticated();
    }
}
