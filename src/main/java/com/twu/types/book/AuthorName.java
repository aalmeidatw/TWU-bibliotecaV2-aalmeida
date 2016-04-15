package com.twu.types.book;


public class AuthorName {
    private String authorName;

    public AuthorName(String authorName){
        this.authorName = authorName;
    }

    public final String getAuthorName(){
        return this.authorName;
    }
}
