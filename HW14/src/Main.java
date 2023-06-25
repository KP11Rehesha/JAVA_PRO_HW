import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {
    public static <T> List<T> toList(T[] arr) {
        return Arrays.asList(arr);
    }

    public static void main(String[] args) {
        Integer[] numbers ={1,2,3,4,5,6,7,8,9,10};
        List<Integer> numberlist = toList(numbers);
        System.out.println(numberlist);

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(apple1);
        appleBox.addFruit(apple2);

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(orange1);
        orangeBox.addFruit(orange2);

        System.out.println("Apple box weight = "+appleBox.getWeight());
        System.out.println("Orange box weight = "+orangeBox.getWeight());


        Apple apple3 = new Apple();
        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(apple3);

        System.out.println("Apple2 box weight = "+appleBox2.getWeight());

        System.out.println("Compare apple box 1 and orange box 1: "+appleBox.compare(orangeBox));
        System.out.println("Compare apple box 1 and  apple box 2: "+appleBox.compare(appleBox2));

        appleBox.merge(appleBox2);
        System.out.println("Apple box 1 weight after merge = "+appleBox.getWeight());
        System.out.println("Apple box 2 weight after merge = "+appleBox2.getWeight());

    }
}

class Fruit {
    protected float weight;

    public float getWeight() {
        return weight;
    }

}

class Apple extends Fruit {
    {
        weight = 1.0f;
    }
}

class Orange extends Fruit {
    {
        weight = 1.5f;
    }
}

class Box<T> {
    private List<T> fruits=new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float totalWeight = 0.0f;
        for (T fruit : fruits) {
            totalWeight += ((Fruit) fruit).getWeight();
        }
        return totalWeight;
    }

    public void addFruits(T[] fruit) {
        fruits.addAll(Arrays.asList(fruit)); //???
    }

    public boolean compare(Box other) {
        return this.getWeight()==other.getWeight();
    }
    public void merge(Box other){
        if(this.fruits.getClass()!=other.fruits.getClass())throw new IllegalArgumentException("Cannot merge boxes with different types of fruits");
        this.addFruits((T[]) other.fruits.toArray());
        other.fruits.clear();
    }
}