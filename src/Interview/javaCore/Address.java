package Interview.javaCore;

public class Address implements Cloneable {
    private String streetNo;
    private String houseNo;

    public Address(String streetNo, String houseNo) {
        this.streetNo = streetNo;
        this.houseNo = houseNo;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }
    @Override
    public Address clone(){
       try {
            return (Address) super.clone();
       } catch (CloneNotSupportedException e){
           throw new AssertionError();
       }
    }
    @Override
    public String toString() {
        return streetNo;
    }
}
