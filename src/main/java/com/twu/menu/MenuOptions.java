package com.twu.menu;

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
    private Map<String, Menu> map;

    public MenuOptions(Library library, ScannerInputUser scannerInputUser, MessagePrinter messagePrinter) {
        this.library = library;
        this.scannerInputUser = scannerInputUser;
        this.messagePrinter = messagePrinter;
        this.loginMenu = new LoginMenu(library, messagePrinter, scannerInputUser);
        createMenuOptions();
    }

    public void menuOption(String option) {

        if(!option.equals("Q")) {
            map.get(option).execute();
        }
    }

    private void createMenuOptions(){
        this.map = new HashMap<>();
        map.put("1", new BookListMenu(library, messagePrinter));
        map.put("2", new MovieListMenu(library, messagePrinter));
        map.put("3", new LendItemMenu(library, messagePrinter, scannerInputUser));
        map.put("4", new ReturnItemMenu(library, messagePrinter, scannerInputUser));
        map.put("5", new UserInfoMenu(library, messagePrinter));
    }

     public boolean userLogin(){
        loginMenu.execute();
        return loginMenu.isUserAuthenticated();
    }
}
