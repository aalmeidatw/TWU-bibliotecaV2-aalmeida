package com.twu.menu;


import com.twu.IO.MessagePrinter;
import com.twu.control.Library;

public class UserInfoMenu implements Menu {
    private Library library;
    private MessagePrinter messagePrinter;
    private final String USER_INFO_MESSAGE = "User Info: ";

    public UserInfoMenu(Library library, MessagePrinter messagePrinter){
        this.library = library;
        this.messagePrinter = messagePrinter;
    }

    @Override
    public void execute() {
        messagePrinter.print(USER_INFO_MESSAGE);
        messagePrinter.print(library.getUserInfo());
    }
}
