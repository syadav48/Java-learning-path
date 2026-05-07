package LLD.designPattern.composite;

public class Ward implements Location{
    private String name;
    Ward(String name){
        this.name = name;
    }
    public void showHierachy() {
        System.out.println("Ward:" + name);
    }
}
