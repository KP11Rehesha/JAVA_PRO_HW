public class Dog extends Animal {
    protected static int count=0;
    @Override
    public int getMaxrundist() {
        return maxrundist = 500;
    }

    @Override
    public int getMaxswimdist() {
        return maxswimdist = 10;
    }

    public Dog(String name) {
        super(name);
        count++;
    }

}
