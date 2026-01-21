package ProjectWiseLearning.OOPS.SmartLibrary.model;

public class Member extends Person {

    private int borrowedBooks;

    public Member(int id, String name) {
        super(id, name);
    }

    @Override
    public String getRole() {
        return "MEMBER";
    }
}
