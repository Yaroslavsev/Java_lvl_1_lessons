package lesson6.Animal;

public class Animal {

    String name;
    String color;
    int age;
    static int animalCount;

    public Animal() {
    }

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        animalCount++;
    }

    public void printInfo() {
        System.out.println("Имя: " + name + " |" + " Цвет: " + color + " |" +  " Возраст: " + age);
    }

    public static void printAnimalCount() {
        System.out.println("Животных было создано: " + animalCount + " шт.");
    }

    public void run(int lengthRun) {
        System.out.println(name + " пробежал " + lengthRun + " м.");
    }

    public void swim(int lengthSwim) {
        System.out.println(name + " проплыл " + lengthSwim + " м.");
    }

    public void jump(double heightJump) {
        System.out.println(name + " прыгнул на " + heightJump + " м.");
    }
}
