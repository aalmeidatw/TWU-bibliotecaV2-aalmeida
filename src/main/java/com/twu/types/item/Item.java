package com.twu.types.item;

import com.twu.types.Name;

public  class Item {
    private Name name;
    private PublicationYear publicationYear;

    public Item(Name name, PublicationYear publicationYear){
        this.name = name;
        this.publicationYear = publicationYear;
    }

    public String getName() {
        return name.getName();
    }

    public int getPublicationYear() {
        return publicationYear.getPublicationYear();
    }
}




