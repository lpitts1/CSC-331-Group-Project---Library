import java.util.Scanner;

public class members {

    Scanner input = new Scanner(System.in);
    Member allMembers[] = new Member[20];

    public static int count = 0;

    public void addMember(Member m) {
        for (int i = 0; i < count; i++) {
            if (m.actNumber.equalsIgnoreCase(
                    allMembers[i].actNumber)) {
                System.out.println("Member" + m.actNumber + "already exists.");

                return;
            }

        }
        if (count <= 20) {
            allMembers[count] = m;
            count++;
        }
    }

    public void showMembers()
        {
            System.out.println("Member Name\t\tAccount Number");
            for (int i = 0; i<count; i++){
                System.out.println(allMembers[i].memberName + "\t\t"+ allMembers[i].actNumber);
            }
        }

    public int memberStatus()
    {
        System.out.println("Enter Account Number:");

        String actNumber = input.nextLine();

        for (int i = 0; i<count; i++){
            if(allMembers[i].actNumber.equalsIgnoreCase(actNumber)){
                return i;
            }
        }

        System.out.println("Member is not registered, please register member");

        return -1;
    }

    public void checkOut(books book){
        int memberIndex = this.memberStatus();

        if (memberIndex != -1){
            System.out.println("Checking out");

            book.showAllBooks();
            book b = book.checkOut();

            System.out.println("Checking out");
            if (b != null){
                if(allMembers[memberIndex].booksCount <= 3){
                    System.out.println("adding book");
                    allMembers[memberIndex].borrowedBooks[allMembers[memberIndex].booksCount] = b;
                    allMembers[memberIndex].booksCount++;
                    return;
                }
                else{
                    System.out.println("You cannot borrow more than 3 books.");
                    return;
                }
            }
        System.out.println("Book not available");
        }
    }
    public void checkIn(books book){
        int memberIndex = this.memberStatus();
        if (memberIndex != -1){
            System.out.println("Here are the books currently borrowed:");

            Member m = allMembers[memberIndex];

            for (int i = 0; i < m.booksCount; i++){

                System.out.println(m.borrowedBooks[i].bookName
                + "by" + m.borrowedBooks[i].authorName);
            }
        System.out.println("Enter name of book to be checked in:");
        String name = input.nextLine();

        for(int i = 0; i < m.booksCount; i++){
            if (name.equalsIgnoreCase(m.borrowedBooks[i].bookName)){
                book.checkIn(m.borrowedBooks[i]);
                m.borrowedBooks[i] = null;

                return;
                }
            }
        System.out.println("Book" + name + "not found.");
        }
    }
}
