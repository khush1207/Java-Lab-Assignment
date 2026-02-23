import java.util.ArrayList;
public class BookMain {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<Book>();
        try {
            Book b1 = new Book("Harry Potter and The Chamber of Secrets", 12, "133887893X", "Fiction", "JK Rowling");
            books.add(b1);
            Book b2 = new Book("The Boy Who Harnessed The Wind", "William Kamkwamba", "Non-fiction");
            books.add(b2);
            Book b3 = new Book("0689818769", 8.99);
            books.add(b3);
            b3.genre = "Fiction";
            b3.title = "Frindle";
            Book b4 = new Book();
            books.add(b4);
            Book b5 = new Book(b1);
            books.add(b5);
            Book b6 = new Book("Biography", 6.99, "AUT034219", "Auto-biography", "Mahatma Gandhi");
            books.add(b6);
            Book b7 = new Book("9781408855928", 12);
            books.add(b7);
        }
        catch(InvalidPriceException | InvalidGenreException P){
            System.out.println(P.getMessage());
        }
        double avg = 0.0;
        for(Book b: books){
            System.out.println("\nName: " + b.title);
            System.out.println("Author: " + b.author);
            System.out.println("Genre: " + b.genre);
            System.out.println("ISBN: " + b.ISBN);
            System.out.println("Price: " + b.price);
            avg+=b.price;
        }
        //Average Price
        System.out.format("\nThe average price of all the books is:%.2f$\n",avg/books.size());
        //Genre based
        books.forEach(b -> {
            if (b.genre == "Fiction"){
                System.out.println("\nName: " + b.title);
                System.out.println("Author: " + b.author);
                System.out.println("ISBN: " + b.ISBN);
                System.out.println("Price: " + b.price);
            }
        });
    }
}
