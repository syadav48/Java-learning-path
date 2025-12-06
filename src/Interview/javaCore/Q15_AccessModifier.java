package Interview.javaCore;

public class Q15_AccessModifier {
    public static void main(String[] args) {
        String name = "Suryoday";
        int age = 30;
        String address = "Mandira Apartment";
        boolean isMarried = true;
        AccessModifier accessModifier = new AccessModifier(name, age, address, isMarried);
        accessModifier.setName("Surya");
        accessModifier.name = "Prahalad";
        accessModifier.setAge(31);
        //accessModifier.age = 32;
        accessModifier.setAddress("J.C Khan Road");
        accessModifier.address = "Mansatolla";
        accessModifier.setMarried(false);
        //accessModifier.isMarried() = true;

        System.out.println(accessModifier.getName() + " " + accessModifier.getAge() + " " + accessModifier.getAddress() + " " + accessModifier.isMarried());
    }
}
