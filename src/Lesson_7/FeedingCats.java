
/**
 * Java 1. HomeWork 7.
 *
 * @author Pavel
 * @version 29.10.2021
 */

class Cat {

    private String name;
    private int appetite;
    private boolean fullnes;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        fullnes = false;
    }

    @Override
    public String toString() {
        return "cat " + name + " ate " + appetite + " satiety: " + fullnes;
    }

    void eat(Plate plate) {
        if (!fullnes) {
            fullnes = plate.decreaseFood(appetite);
        }
    }
}

class Plate {

    private int food;

    Plate(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "food left: " + food;
    }

    boolean decreaseFood(int portion) {
        if (food < portion) {
            return false;
        }
        this.food -= portion;
        return true;
    }

    void increaseFood() {
        this.food += 100;
    }
}

public class FeedingCats {

    public static void main(String[] args) {
        Cat[] allCat = new Cat[3];
        allCat[0] = new Cat("Barsik", 40);
        allCat[1] = new Cat("Begemot", 70);
        allCat[2] = new Cat("Puschok", 30);

        Plate plate = new Plate(100);

        for (Cat cat : allCat) {
            cat.eat(plate);
            System.out.println(cat);
        }

        System.out.println(plate);
        plate.increaseFood();
        System.out.println(plate);


        for (Cat cat : allCat) {
            cat.eat(plate);
            System.out.println(cat);
        }

        System.out.println(plate);
    }
}
