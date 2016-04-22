package com.twu.IO;


import java.util.Scanner;

public class ScannerInputUser {
    private Scanner scanner = new Scanner(System.in);

    public String getUserInfoScanner(){
        return scanner.next().toUpperCase();
    }

    public String getNameItemScanner(){
        return scanner.nextLine();
    }

    public String getInputLoginUser(){
        return scanner.next();
    }
}






