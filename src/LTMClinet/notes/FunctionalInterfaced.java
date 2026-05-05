package LTMClinet.notes;
@FunctionalInterface
public interface FunctionalInterfaced {
    abstract void execute();

    public static void main(String[] args) {
        FunctionalInterfaced interfaced = () -> System.out.println("Executing this interface..");
        interfaced.execute();
    }
}

