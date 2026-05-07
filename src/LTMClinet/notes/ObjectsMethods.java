package LTMClinet.notes;

import java.util.Optional;

public class ObjectsMethods {
    String objtostr;
    int code;
    @Override
    public String toString() {
        return objtostr;
    }

    @Override
    public int hashCode() {
            return code;
        //return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    public static void main(String[] args) {
        ObjectsMethods obj = new ObjectsMethods();
        ObjectsMethods obj1 = new ObjectsMethods();
        obj.objtostr = "First Object";
        obj.code = 5;
        obj1.code = 5;
        System.out.println(obj.toString());
        System.out.println(obj.hashCode());
        System.out.println(obj1.hashCode());
        System.out.println(obj.equals(obj1));
        Optional.ofNullable(obj.objtostr);
    }

}
