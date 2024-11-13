
import java.util.Scanner;


public class book {


    public String bookName;
    public String authorName;
    public String genre;
    public int bookQty;
    public int bookQtyCopy;


    Scanner input = new Scanner(System.in);


    public book()
    {

        System.out.println("Enter Book Name:");
        this.bookName = input.nextLine();

        System.out.println("Enter Author Name:");
        this.authorName = input.nextLine();

        System.out.println("Enter Genre of Book:");
        this.genre = input.nextLine();

        System.out.println("Enter Quantity of Books:");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;
    }
}