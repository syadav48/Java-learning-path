package ProjectWiseLearning.OOPS.SmartLibrary.util;

public final class IdGenerator {
    private static int counter = 1000;

    public static int generateId() {
        return ++counter;
    }
}

