public class Animal {

    private String name;
    protected static int count=0;
    protected int maxrundist;
    protected int maxswimdist;

    public int getMaxrundist() {
        return maxrundist = 0;
    }

    public int getMaxswimdist() {
        return maxswimdist = 0;
    }

    public Animal(String name) {
        this.name = name;
        count++;
    }

    protected void run(int distance) {
        if (getMaxrundist() == 0) {
            System.out.println(name + " can`t swim");
        } else if (distance < getMaxrundist()) {
            System.out.println(name + " run " + distance + "m");
        } else {
            System.out.println(name + " cannot run that far");
        }
    }

    protected void swim(int distance) {
        if (getMaxswimdist() == 0) {
            System.out.println(name + " can`t swim");
        } else if (distance < getMaxswimdist()) {
            System.out.println(name + " swam " + distance + "m");
        } else {
            System.out.println(name + " cannot swim that far");
        }
    }
}
