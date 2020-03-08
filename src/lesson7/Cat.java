package lesson7;

import java.util.Random;

public class Cat {

    Random randomCat = new Random();

    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name) {
        this.name = name;
        this.appetite = randomCat.nextInt(25);
        this.fullness = false;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFullness() {
        return fullness;
    }

    public void eat(Plate plate){
        if (plate.getFood() < appetite) {
            System.out.println("Коту " + name + " не хватает корма. Сытость: " + fullness);
        } else {
            fullness = true;
            System.out.println("Кот " + name + " поел " + appetite + ". Сытость: " + fullness);
            plate.decreaseFood(this);
        }
    }
}
