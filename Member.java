import java.util.Scanner;

public class Member {

    String memberName;
    String actNumber;

    book borrowedBooks[] = new book[3];
    public int booksCount = 0;

    Scanner input = new Scanner(System.in);

    public Member()
    {
        System.out.println("Enter Member's Name:");

        this.memberName = input.nextLine();

        System.out.println("Enter Account Number:");
        this.actNumber = input.nextLine();
    }
}
