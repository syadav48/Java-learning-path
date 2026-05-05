package LTMClinet.notes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableObject {
    private final int count;
    private List<Integer> list = new ArrayList<>();
    public ImmutableObject(int count, List<Integer> list) {
        this.count = count;
        this.list = list;
    }

    public List<Integer> getList() {
        return Collections.unmodifiableList(list);
    }

    public int getCount() {
        return count;
    }
}
//public class ExtendingFinal extends ImmutableObject{
//    --> we can't extend the final and we can't change the content of the immutable class
//}
