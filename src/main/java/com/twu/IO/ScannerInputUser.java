package com.twu.IO;


import java.util.Scanner;

public class ScannerInputUser {
    Scanner scanner = new Scanner(System.in);

    public String getUserInfoScanner(){
        return scanner.nextLine().toUpperCase();
    }

    public String getNameItemScanner(){
        return scanner.nextLine();
    }

    public int getInputIndex(){
        return scanner.nextInt();

    }

    public String getInputLoginUser(){
        return scanner.next();
    }
}






