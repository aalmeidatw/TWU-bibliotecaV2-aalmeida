package com.twu.menu;

import com.twu.IO.MessagePrinter;
import com.twu.control.Library;
import com.twu.types.itemType.ItemType;

public class MovieListMenu implements Menu {
    private MessagePrinter messagePrinter;
    private Library library;
    private final String LIST_MOVIES_MESSAGE = "List of Available Movies! ";

    public MovieListMenu(Library library, MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
        this.library = library;
    }

    @Override
    public void execute() {
        messagePrinter.print(LIST_MOVIES_MESSAGE);
        messagePrinter.printerItemList(library.returnItemList(ItemType.MOVIE));
    }
}
