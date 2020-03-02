package lesson6;

import lesson6.Animal.Animal;
import lesson6.Animal.Cat;
import lesson6.Animal.Dog;

public class Main {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Morkovka", "ginger", 3);
        Cat cat2 = new Cat("Tosik", "white", 2);
        Cat cat3 = new Cat("Bastinda", "ginger", 5);

        Dog dog1 = new Dog("Tuman", "grey", 1);
        Dog dog2 = new Dog("Bobik", "black", 4, true);
        Dog dog3 = new Dog("Sharik", "white", 6);
        Dog dog4 = new Dog("Kairat", "ginger", 7, true);

        cat1.run(200);
        cat2.swim(3);
        cat3.jump(2);
        System.out.println();

        dog1.run(500);
        dog2.run(550);
        dog3.run(200);
        dog4.swim(5);
        System.out.println();

        Animal.printAnimalCount();
        Cat.printCatCount();
        Dog.printDogCount();




    }
}
