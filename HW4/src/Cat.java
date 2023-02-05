public class Cat extends Animal {
    protected static int count=0;
    @Override
    public int getMaxrundist() {
        return maxrundist = 200;
    }


    public Cat(String name) {
        super(name);
        count++;
    }
}