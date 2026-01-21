package ProjectWiseLearning.OOPS.SmartLibrary.model;

public abstract class Person {
    protected final int id;
    protected String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract String getRole();
}
