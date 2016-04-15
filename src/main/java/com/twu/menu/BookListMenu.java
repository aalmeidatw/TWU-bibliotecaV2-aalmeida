package com.twu.menu;


import com.twu.IO.MessagePrinter;
import com.twu.control.Library;
import com.twu.types.itemType.ItemType;
import com.twu.types.library.ItemLibrary;

import java.util.List;


public class BookListMenu implements Menu {
    private MessagePrinter messagePrinter;
    private Library library;

    public BookListMenu(Library library, MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
        this.library = library;
    }

    @Override
    public void execute() {
        messagePrinter.print("List of Available Books!  : ");

        List<ItemLibrary> itemLibraries = library.returnItemList(ItemType.BOOK);
        messagePrinter.printerItemList(itemLibraries);
    }
}
