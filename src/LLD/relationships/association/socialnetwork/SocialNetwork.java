package LLD.relationships.association.socialnetwork;

public class SocialNetwork {
    public static void main(String[] args) {
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        alice.follow(bob);
        alice.follow(charlie);
        bob.follow(alice);

        alice.sendMessage("Hello world!", "10:00 AM");
        bob.sendMessage("Learning OOP!", "10:30 AM");


        for(User u: alice.getFollowing()){
            System.out.println("alice following:" + u.getName());
        }

        for (User u : bob.getFollowers())
            System.out.println("  - " + u.getName());

        for (Message m : alice.getMessages())
            System.out.println("  [" + m.getTimeStamp() + "] " + m.getContent());



    }
}
