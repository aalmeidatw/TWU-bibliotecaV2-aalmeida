package com.twu.menu;


import com.twu.IO.MessagePrinter;
import com.twu.control.Library;

public class ItemsToReturnMenu implements Menu {
    private MessagePrinter messagePrinter;
    private Library library;
    private final String ALL_ITEMS_MESSAGE = "List of All items To Return: ";

    public ItemsToReturnMenu(Library library, MessagePrinter messagePrinter){
        this.messagePrinter = messagePrinter;
        this.library = library;
    }

    @Override
    public void execute() {
        messagePrinter.print(ALL_ITEMS_MESSAGE);
        messagePrinter.printerItemList(library.getAllItemsToReturn());
    }
}
