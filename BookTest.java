 public class BookTest {
    public static void main(String[] args) {
        Fiction fictionBook = new Fiction("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Classic");
        NonFiction nonFictionBook = new NonFiction("Sapiens", "Yuval Noah Harari", 2011, "History");
        ScienceFiction scifiBook = new ScienceFiction("Dune", "Frank Herbert", 1965, "Interplanetary Society");

        // Displaying details of each book
        fictionBook.displayDetails();
        System.out.println();

        nonFictionBook.displayDetails();
        System.out.println();

        scifiBook.displayDetails();
    }
}
