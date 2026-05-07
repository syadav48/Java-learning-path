package LTMClinet.notes;

class Box<T>{
    private T value;
    void setValue(T value){
        this.value = value;
    }
    T getValue(){
        return value;
    }
}
public class GenericClass {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        Box<Integer> box1 = new Box<>();
        box.setValue("Hello");
        box1.setValue(5);
        System.out.println(box.getValue());
    }
}
