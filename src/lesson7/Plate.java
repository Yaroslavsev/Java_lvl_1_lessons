package lesson7;

public class Plate {

    private int food;

    public Plate(int food){
        this.food = food;
    }

    public void moreFood(){
            food += 5;
        System.out.println("Добавляем 5 едениц еды");
    }

    public void decreaseFood (Cat cat){
        food -= cat.getAppetite();
    }

    public void info(){
        System.out.println("Еды осталось: " + food);
    }

    public int getFood() {
        return food;
    }
}
