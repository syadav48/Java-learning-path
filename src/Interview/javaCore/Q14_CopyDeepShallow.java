package Interview.javaCore;


public class Q14_CopyDeepShallow {
    public static void main(String[] args) {
        Person1 originalCopy = new Person1("Suryoday", new Address("J.C Khan Road", "22/3/B"));
        // shallow copying:
//        Person1 shallowCopy = new Person1(originalCopy);
//        shallowCopy.setName("Roshan");
//        shallowCopy.getAddress().setHouseNo("22/3/A");
//
        // deep copying
        Person1 deepCopy = originalCopy.clone();
        deepCopy.setName("Rahul");
        deepCopy.getAddress().setHouseNo("22/2/B");

        System.out.println("Original Person:" + originalCopy.getName());
        System.out.println("Shallow Person:" + originalCopy.getAddress().getHouseNo());
    }
}
