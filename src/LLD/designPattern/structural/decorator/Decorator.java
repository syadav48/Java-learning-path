package LLD.designPattern.structural.decorator;

public class Decorator {
    public static void main(String[] args) {
        Coffee coffee = new Espresso();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription());
        System.out.println("Total Cost:" + coffee.getCost());
    }
}
