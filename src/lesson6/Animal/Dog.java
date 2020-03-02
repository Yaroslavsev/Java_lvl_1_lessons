package lesson6.Animal;

public class Dog extends Animal {

    static int dogCount;
    private boolean longRun;

    public Dog() {
        dogCount++;
        animalCount++;
    }

    public Dog (String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        dogCount++;
        animalCount++;
    }

    public Dog (String name, String color, int age, boolean longRun) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.longRun = longRun;
        dogCount++;
        animalCount++;
    }

    public static void printDogCount() {
        System.out.println("Собак было создано: " + dogCount + " шт.");
    }

    @Override
    public void printInfo() {
        System.out.println("Имя: " + name + " |" + " Цвет: " + color + " |" + " Возраст: " + age + " |" + " Умеет далеко бегать: " + longRun);
    }

    @Override
    public void run(int lengthRun) {
        if (!this.longRun & lengthRun > 400 || this.longRun & lengthRun > 600) {
            System.out.println("Собаки столько не бегают!");
        } else {
            super.run(lengthRun);
        }
    }

    @Override
    public void swim(int lengthSwim) {
        if (lengthSwim > 10) {
            System.out.println("Собаки столько не плавают!");
        } else {
            super.swim(lengthSwim);
        }
    }

    @Override
    public void jump(double heightJump) {
        if (heightJump > 0.5) {
            System.out.println("Собаки так высоко не прыгают!");
        } else {
            super.jump(heightJump);
        }
    }
}
