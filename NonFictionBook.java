public class NonFictionBook extends Book{
    private String topic;
    private String educationLevel;
    private int publicationYear;
    //Constructor
    public NonFictionBook(String bookName, String authorName, String genre, int bookQty, int bookQtyCopy,
                          String topic, String educationLevel, int publicationYear){
        super(bookName ,authorName, genre, bookQty, bookQtyCopy);
        this.topic = topic;
        this.educationLevel = educationLevel;
        this.publicationYear = publicationYear;
    }
    //Getters and setters
    public String getTopic() {return topic;}
    public void setTopic(String topic) {this.topic = topic;}

    public String getEducationLevel() {return educationLevel;}
    public void setEducationLevel(String educationLevel) {this.educationLevel = educationLevel;}

    public int getPublicationYear() {return publicationYear;}
    public void setPublicationYear(int publicationYear) {this.publicationYear = publicationYear;}
    //Will need a details method


}
