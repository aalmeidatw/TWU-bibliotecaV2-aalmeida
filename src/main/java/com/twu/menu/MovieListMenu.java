package com.twu.menu;

import com.twu.IO.MessagePrinter;
import com.twu.control.Library;
import com.twu.types.itemType.ItemType;


public class MovieListMenu implements Menu {
    private MessagePrinter messagePrinter;
    private Library library;
    private ItemType itemType;

    public MovieListMenu(Library library, MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
        this.library = library;
    }

    @Override
    public void execute() {
        messagePrinter.print("List of Available Movies!  : ");
        messagePrinter.printerItemList(library.returnItemList(itemType.MOVIE));
    }
}
