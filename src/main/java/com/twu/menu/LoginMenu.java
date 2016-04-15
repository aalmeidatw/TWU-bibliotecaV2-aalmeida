package com.twu.menu;


import com.twu.IO.MessagePrinter;
import com.twu.IO.ScannerInputUser;
import com.twu.control.Library;

public class LoginMenu implements Menu {
    private MessagePrinter messagePrinter;
    private Library library;
    private ScannerInputUser scannerInputUser;
    private boolean userAuthenticated;
    private static boolean AUTHENTICATED = true;
    private static boolean NOT_AUTHENTICATED = false;

    public LoginMenu(Library library, MessagePrinter messagePrinter, ScannerInputUser scannerInputUser) {
        this.messagePrinter = messagePrinter;
        this.library = library;
        this.scannerInputUser = scannerInputUser;
     }

    @Override
    public void execute() {
        String userName = getUserNameInput();
        String password = getPasswordInput();

        setUserStatus(userName, password);
    }

    protected void setUserStatus(String userName, String password) {

        if (library.loginUser(userName, password)){
            this.userAuthenticated = AUTHENTICATED;
            library.setUserAuthenticated(library.returnUserInfo(userName));
        } else
            this.userAuthenticated = NOT_AUTHENTICATED;
    }

    protected String getPasswordInput() {
        messagePrinter.print("PassWord : ");
        return scannerInputUser.getInputLoginUser();
    }

    protected String getUserNameInput() {
        messagePrinter.print("UserName : ");
        return  scannerInputUser.getInputLoginUser();
    }

    public boolean isUserAuthenticated() {
        return userAuthenticated;
    }
}
