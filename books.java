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

    public void showAllBooks(){

    }

    public void upgradeBookQty(){

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
