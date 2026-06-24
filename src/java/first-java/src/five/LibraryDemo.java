package five;

class Library{
    int availableBooks = 3;

    public void borrowBook(int bookRequested){
        int[] books = {101, 102, 103};
        System.out.println("Book Request : "+books[bookRequested]);
    }
}
public class LibraryDemo {
    public static void main(String[] args) {
        Library library = new Library();;
        library.borrowBook(2);
    }
}
