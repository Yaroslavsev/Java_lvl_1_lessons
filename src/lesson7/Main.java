package lesson7;

public class Main {

    public static void main(String[] args) {

        Cat[] cats = {
                new Cat("Zizi"),
                new Cat("James"),
                new Cat("Fluff"),
        };

        Plate plate1 = new Plate(20);

        for (Cat i : cats) {
            i.eat(plate1);
            while (!i.isFullness()) {
                plate1.moreFood();
                i.eat(plate1);
            }
            plate1.info();
        }
    }
}
