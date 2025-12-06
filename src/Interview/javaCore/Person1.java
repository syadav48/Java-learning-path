package Interview.javaCore;

public class Person1 implements Cloneable{
    private String name;
    private Address address;
    public Person1(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public Person1(Person1 originalCopy) {
        this.name = originalCopy.name;
        this.address = originalCopy.address;
    }
    @Override
    public Person1 clone(){
        try {
            Person1 cloned = (Person1) super.clone();
            cloned.address = address.clone();
            return cloned;

        }  catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    @Override
    public String toString() {
        return "Person{name='" + name + "', address=" + address + "}";
    }
}
