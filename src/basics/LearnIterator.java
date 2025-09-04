package basics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LearnIterator {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ram");
        names.add("Shyam");
        names.add("Hari");

        Iterator<String> it = names.iterator();
        while (it.hasNext()){
            if(it.next().startsWith("R")){
                it.remove();;
            }
        }
        System.out.println(names);
    }
}
