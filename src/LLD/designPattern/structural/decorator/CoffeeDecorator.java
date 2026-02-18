package LLD.designPattern.structural.decorator;

public abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee; // 👈 accessible to child decorators

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}
