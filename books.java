import java.util.Scanner;

public class books {

    book allBooks[] = new book[25];
    public static int count;

    Scanner input = new Scanner(System.in);


    public int compareBooks(book b1, book b2){

        if(b1.bookName.equalsIgnoreCase(b2.bookName)){
            System.out.println("This book already exists");

            return 0;
        }

        return 1;
    }

    public void newBook(book b){

        for (int i = 0; i<count; i++){
            if(this.compareBooks(b,this.allBooks[i])==0){
                return;
            }
        }
        if (count < 25){


            allBooks[count] = b;
            count++;
        }
        else{
            System.out.println("Library is Full");
        }
    }

    public void searchAuthor(){
        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();

        int flag = 0;

        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for(int i = 0; i<count; i++){
            if (authorName.equalsIgnoreCase(allBooks[i].authorName)){
                System.out.println(allBooks[i].bookName +"\t\t"
                        + allBooks[i].authorName + "\t\t"
                        + allBooks[i].genre + "\t\t"
                        + allBooks[i].bookQty + "\t\t"
                        + allBooks[i].bookQtyCopy);
                flag++;
            }
        }
        if (flag == 0){
            System.out.println("No books from that author found.");
        }
    }

    public void searchBySno()
    {

        // Display message
        System.out.println(
                "\t\t\t\tSEARCH BY SERIAL NUMBER\n");

        // Class data members
        int sNo;
        System.out.println("Enter Serial No of Book:");
        sNo = input.nextInt();

        int flag = 0;
        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {
            if (sNo == allBooks[i].sNo) {
                System.out.println(
                        allBooks[i].sNo + "\t\t"
                                + allBooks[i].bookName + "\t\t"
                                + allBooks[i].authorName + "\t\t"
                                + allBooks[i].bookQtyCopy + "\t\t"
                                + allBooks[i].bookQty);
                flag++;
                return;
            }
        }
        if (flag == 0)
            System.out.println("No Book for Serial No "
                    + sNo + " Found.");
    }


    public void showAllBooks() {
        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    allBooks[i].sNo + "\t\t"
                            + allBooks[i].bookName + "\t\t"
                            + allBooks[i].authorName + "\t\t"
                            + allBooks[i].bookQtyCopy + "\t\t"
                            + allBooks[i].bookQty);

        }
    }

    public void upgradeBookQty(){
        System.out.println(
                "\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter Serial No of Book");

        int sNo = input.nextInt();

        for (int i = 0; i < count; i++) {

            if (sNo == allBooks[i].sNo) {

                // Display message
                System.out.println(
                        "Enter No of Books to be Added:");

                int addingQty = input.nextInt();
                allBooks[i].bookQty += addingQty;
                allBooks[i].bookQtyCopy += addingQty;

                return;
            }
        }
    }

    public void dispMenu(){
        // Displaying menu
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 0 to Exit Application.");
        System.out.println(
                "Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println(
                "Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book. ");
        System.out.println("Press 8 to Check In Book");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------");

    }

    public int isAvailable(String b){
        for(int i= 0; i<count; i++){
            if(b.equalsIgnoreCase(allBooks[i].bookName)){
                if(allBooks[i].bookQtyCopy > 0){
                    System.out.println(b + "is available.");
                    return i;
                }
                System.out.println(b + "is unavailable.");
                return -1;
            }
        }
      System.out.println("No book named" + b + "exists in library.");

        return -1;
    }

    public book checkOut(){
        System.out.println("Enter name of book to be checked out:");

        String name = input.nextLine();

        int bookIndex = isAvailable(name);

        if (bookIndex!= -1){
            allBooks[bookIndex].bookQtyCopy--;
            return allBooks[bookIndex];
        }
        return null;
    }

    public void checkIn(book b){
        for (int i = 0; i < count; i++){
            if (b.equals(allBooks[i])){
                allBooks[i].bookQtyCopy++;
                return;
            }
        }
    }
}
