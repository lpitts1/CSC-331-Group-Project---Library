package com.example.library;
/**
 * This is the ID Card for a library member, it inherits from Member
 *
 * This tracks the member's name, account number, and the date the account was created
 */
public class IDCard extends Member{

    private String dateCreated;
    /**
     * Constructs the IDCard with the parameters:
     *
     * @param memberName
     * @param actNumber
     * @param dateCreated
     */
    public IDCard(String memberName, String actNumber, String dateCreated){
        super(memberName, actNumber);
        this.dateCreated = dateCreated;
    }
    /**
     * Returns the data the IDCard was created
     * @return date the IDCard was created
     */
    public String getDateCreated(){return dateCreated;}
    /**
     * Updates the date created of the IDCard
     * @param dateCreated
     */
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
