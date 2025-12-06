package Interview.javaCore;

public class AccessModifier {
    public String name;
    private int age;
    protected String address;
    boolean married;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public AccessModifier(String name, int age, String address, boolean married) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.married = married;
    }
}
