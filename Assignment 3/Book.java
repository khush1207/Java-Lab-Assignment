public class Book{
    public String title;
    public double price;
    public String ISBN;
    public String genre;
    public String author;
    public Book(){
        title = null;
        price = 0.00;
        ISBN = null;
        genre = null;
        author = null;
    }
    public Book(String title, double price, String ISBN, String genre, String author) throws InvalidPriceException, InvalidGenreException{
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        if (price < 0)
            throw new InvalidPriceException("Price cannot be negative");
        if (!genre.equals("Fiction") && !genre.equals("Non-fiction") && !genre.equals("Auto-biography"))
            throw new InvalidGenreException("Invalid genre of book: " + title);
        this.genre = genre;
        this.price = price;
    }
    public Book(String title, String author, String genre)throws InvalidGenreException{
        this.title = title;
        this.author = author;
        if (!genre.equals("Fiction") && !genre.equals("Non-fiction") && !genre.equals("Auto-biography"))
            throw new InvalidGenreException("Invalid genre of book: " + title);
        this.genre = genre;
    }
    public Book(String ISBN, double price) throws InvalidPriceException{
        this.ISBN = ISBN;
        if(price < 0){
            throw new InvalidPriceException("Price cannot be negative");
        }
        this.price = price;
    }
    public Book(Book other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot copy a null Book");
        }
        this.title = other.title;
        this.author = other.author;
        this.genre = other.genre;
        this.ISBN = other.ISBN;
        this.price = other.price;
    }
}
