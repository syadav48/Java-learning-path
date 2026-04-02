package Interview.Delloite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class  ImmutableClass {
    private final String id;
    private final String name;
    private final List<String> roles;

    public ImmutableClass(String id, String name, List<String> roles) {
        this.id = id;
        this.name = name;
        this.roles = roles == null ? Collections.emptyList() : new ArrayList<>(roles);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getRoles() {
        return Collections.unmodifiableList(roles);
    }

}
