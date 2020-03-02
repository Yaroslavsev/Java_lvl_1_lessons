package lesson6.Animal;

public class Cat extends Animal {

    static int catCount;

    public Cat() {
        catCount++;
        animalCount++;
    }

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        catCount++;
        animalCount++;
    }

    public static void printCatCount() {
        System.out.println("Кошек было создано: " + catCount + " шт.");
    }

    @Override
    public void run(int lengthRun) {
        if (lengthRun > 200) {
            System.out.println("Кошки столько не бегают!");
        } else {
            super.run(lengthRun);
        }
    }

    @Override
    public void swim(int lengthSwim) {
        System.out.println("Кошки не умеют плавать!");

    }

    @Override
    public void jump(double heightJump) {
        if (heightJump > 2) {
            System.out.println("Кошки так высоко не прыгают!");
        } else {
            super.jump(heightJump);
        }
    }
}
