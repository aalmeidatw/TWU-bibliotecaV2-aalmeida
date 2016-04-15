package com.twu.menu;


import com.twu.IO.MessagePrinter;
import com.twu.IO.ScannerInputUser;
import com.twu.control.Library;

public class ReturnItemMenu implements Menu {
    private MessagePrinter messagePrinter;
    private Library library;
    private ScannerInputUser scannerInputUser;

    public ReturnItemMenu(Library library, MessagePrinter messagePrinter, ScannerInputUser scannerInputUser) {
        this.messagePrinter = messagePrinter;
        this.scannerInputUser = scannerInputUser;
        this.library = library;
    }

    @Override
    public void execute() {
        messagePrinter.print("List Items To Return: " + "\n\n");
        messagePrinter.printerItemList(library.getAllItemsToReturn());

        messagePrinter.print("Type ItemName To Return :" + "\n\n");
        String itemName = scannerInputUser.getNameItemScanner();

        try {
            library.returnBorrowedItem(itemName);
        }
        catch (Exception e){
            messagePrinter.print(e.getMessage());
        }
    }
}
