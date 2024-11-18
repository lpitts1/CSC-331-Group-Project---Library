public class FictionBook extends Book {
    private String intendedAudience;
    private String series;
    private int rating;
//Constructor
    public FictionBook(String bookName, String authorName, String genre, int bookQty, int bookQtyCopy,
                       String intendedAudience, String series, int rating){
        super(bookName ,authorName, genre, bookQty, bookQtyCopy);
        this.intendedAudience = intendedAudience;
        this.series = series;
        this.rating = rating;

    }
//Getters and Setters
    public String getSeries() {return series;}
    public void setSeries(String series) {this.series = series;}

    public int getRating() {return rating;}
    public void setRating(int rating) {this.rating = rating;}

    public String getIntendedAudience() {return intendedAudience;}
    public void setIntendedAudience(String intendedAudience) {this.intendedAudience = intendedAudience;}

    //Will need a details method
}
