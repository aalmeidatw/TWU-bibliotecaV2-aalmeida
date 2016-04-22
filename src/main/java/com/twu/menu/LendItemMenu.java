package com.twu.menu;


import com.twu.IO.MessagePrinter;
import com.twu.IO.ScannerInputUser;
import com.twu.control.Library;

public class LendItemMenu implements Menu {
    private MessagePrinter messagePrinter;
    private Library library;
    private ScannerInputUser scannerInputUser;
    private final String TYPE_ITEM_NAME_MESSAGE = "Type ItemName To Lend :";

    public LendItemMenu(Library library, MessagePrinter messagePrinter, ScannerInputUser scannerInputUser){
        this.messagePrinter = messagePrinter;
        this.scannerInputUser = scannerInputUser;
        this.library = library;
    }

    @Override
    public void execute() {
        messagePrinter.print(TYPE_ITEM_NAME_MESSAGE);
        String itemName = scannerInputUser.getNameItemScanner();

        try {
            library.lendItem(itemName);
        }
        catch (Exception e){
            messagePrinter.print(e.getMessage());
        }
    }
}
