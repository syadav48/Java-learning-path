package LLD.designPattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Region implements Location{
    private String name;
    private List<Location> children = new ArrayList<>();
    Region(String name){
        this.name = name;
    }
    public void add(Location location){
        children.add(location);
    }
    @Override
    public void showHierachy() {

        for (Location location: children){
          location.showHierachy();        }
    }
}
