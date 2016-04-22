package com.twu.menu;


import com.twu.IO.MessagePrinter;
import com.twu.IO.ScannerInputUser;
import com.twu.control.Library;

public class ReturnItemMenu implements Menu {
    private MessagePrinter messagePrinter;
    private Library library;
    private ScannerInputUser scannerInputUser;
    private final String LIST_ITEM_MESSAGE = "List Items To Return: " + "\n\n";
    private final String TYPE_ITEM_MESSAGE = "Type ItemName To Return :" + "\n\n";

    public ReturnItemMenu(Library library, MessagePrinter messagePrinter, ScannerInputUser scannerInputUser) {
        this.messagePrinter = messagePrinter;
        this.scannerInputUser = scannerInputUser;
        this.library = library;
    }

    @Override
    public void execute() {
        messagePrinter.print(LIST_ITEM_MESSAGE);
        messagePrinter.printerItemList(library.getAllItemsToReturn());

        messagePrinter.print(TYPE_ITEM_MESSAGE);
        String itemName = scannerInputUser.getNameItemScanner();

        try {
            library.returnBorrowedItem(itemName);
        }
        catch (Exception e){
            messagePrinter.print(e.getMessage());
        }
    }
}
