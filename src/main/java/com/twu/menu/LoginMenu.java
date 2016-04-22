package com.twu.menu;


import com.twu.IO.MessagePrinter;
import com.twu.IO.ScannerInputUser;
import com.twu.control.Library;

public class LoginMenu implements Menu {
    private MessagePrinter messagePrinter;
    private Library library;
    private ScannerInputUser scannerInputUser;
    private boolean userAuthenticated;
    private final boolean AUTHENTICATED = true;
    private final boolean NOT_AUTHENTICATED = false;
    private final String PASSWORD_MESSAGE ="Password ? : ";
    private final String USER_NAME_MESSAGE ="Username? : ";

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
        messagePrinter.print(PASSWORD_MESSAGE);
        return scannerInputUser.getInputLoginUser();
    }

    protected String getUserNameInput() {
        messagePrinter.print(USER_NAME_MESSAGE);
        return  scannerInputUser.getInputLoginUser();
    }

    public boolean isUserAuthenticated() {
        return userAuthenticated;
    }
}
