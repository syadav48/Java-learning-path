package LLD.designPattern.composite;

public class Village implements Location{
    private String name;
    Village(String name){
        this.name = name;
    }
    public void showHierachy() {
        System.out.println("Village:" + name);
    }
}
