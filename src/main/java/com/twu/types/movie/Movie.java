package com.twu.types.movie;


import com.twu.types.Name;
import com.twu.types.item.Item;
import com.twu.types.item.PublicationYear;

public class Movie extends Item {
    private DirectorName directorName;
    private String itemType;
    private  int rate;


    public Movie(Name name, PublicationYear publicationYear, DirectorName directorName, int rate){
        super(name, publicationYear);
        this.directorName = directorName;
        this.rate = rate;
    }

    public String getDirectorName() {
        return directorName.getDirectorName();
    }

    public String getItemType() {
        return itemType;
    }

    public int getRate() {
        return rate;
    }

    public String toString(){
        return  "Movie Name: " + super.getName() + "\n"
                + "Director Name: "  + directorName.getDirectorName() + "\n"
                +  "Publication Year: " + super.getPublicationYear()
                + "\n\n";

    }
}
