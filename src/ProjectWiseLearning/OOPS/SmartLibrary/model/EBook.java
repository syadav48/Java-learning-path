package ProjectWiseLearning.OOPS.SmartLibrary.model;

public class EBook extends Book {

    private double fileSize;

    public EBook(String isbn, String title, double fileSize) {
        super(isbn, title);
        this.fileSize = fileSize;
    }

    @Override
    public double getPrice() {
        return 200.0;
    }
}
