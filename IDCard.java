package com.example.library;

public class IDCard extends Member{

    private String dateCreated;

    public IDCard(String memberName, String actNumber, String dateCreated){
        super(memberName, actNumber);
        this.dateCreated = dateCreated;
    }

    public String getDateCreated(){return dateCreated;}

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
