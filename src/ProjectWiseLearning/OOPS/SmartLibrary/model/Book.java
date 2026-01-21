package ProjectWiseLearning.OOPS.SmartLibrary.model;

public abstract class Book {
    protected final String isbn;
    public String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public abstract double getPrice();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}

