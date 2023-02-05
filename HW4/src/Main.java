public class Main {
    public static void main(String[] args) {
        Dog bobik = new Dog("Bobik");
        bobik.run(100);
        bobik.swim(11);
        System.out.println("");

        Animal zhyk =new Dog("Zhyk");
        zhyk.run(500);
        zhyk.swim(8);
        System.out.println("");

        Cat pyshok = new Cat("Pushok");
        pyshok.run(150);
        pyshok.swim(200);
        System.out.println("");

        System.out.println(
                    "There are " + Animal.count + " animals\n"+
                    "There are " + Cat.count + " cats\n"+
                    "There are " + Dog.count + " dogs"
        );
    }
}