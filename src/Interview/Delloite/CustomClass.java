package Interview.Delloite;

import java.util.Objects;

public class CustomClass {
    private final int num;
    private final String name;

    public CustomClass(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CustomClass that = (CustomClass) o;
        return num == that.num && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, name);
    }
}
