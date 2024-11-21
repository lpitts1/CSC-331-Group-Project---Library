import java.util.Scanner;

public class Library {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // create object of book class
        books ob = new books();
        // create object of member class
        members obMember = new members();

        int choice;
        int searchChoice;

        do{
            ob.dispMenu();
            choice = input.nextInt();

            switch(choice){
                case 1:
                    book b = new book();
                    ob.newBook(b);
                    break;

                case 2:
                    ob.upgradeBookQty();
                    break;

                case 3:
                    System.out.println("Press 1 to search with book serial number.");
                    System.out.println("Press 2 to search with author name");
                    searchChoice = input.nextInt();

                    switch(searchChoice){
                        case 1:
                            ob.searchBySno();

                        case 2:
                            ob.searchAuthor();
                    }break;

                case 4:
                    ob.showAllBooks();

                case 5:
                    Member m = new Member();
                    obMember.addMember(m);
                    break;

                case 6:
                    obMember.showMembers();
                    break;

                case 7:
                    obMember.checkOut(ob);
                    break;

                case 8:
                    obMember.checkIn(ob);
                    break;

                default:

                    System.out.println("Enter number between 0 and 8");
            }
        }
        while (choice != 0);



    }
}
