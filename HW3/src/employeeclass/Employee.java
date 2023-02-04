package employeeclass;

public class Employee {
    private String name;
    private String Surname;
    private String secondname;
    private String position;
    private String email;
    private int age;
    private String phonenumber;

    public Employee(String name, String surname, String secondname, String position, String email, int age, String phonenumber) {
        this.name = name;
        this.Surname = surname;
        this.secondname = secondname;
        this.position = position;
        this.email = email;
        this.age = age;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getSecondname() {
        return secondname;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
}
