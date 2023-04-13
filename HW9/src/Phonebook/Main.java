package Phonebook;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.add(new Record("John Doe", "123-456-7890"));
        phonebook.add(new Record("Jane Smith", "555-555-1234"));
        phonebook.add(new Record("John Doe", "999-999-9999"));

        Record record1 = phonebook.find("Jane Smith");
        if (record1 != null) {
            System.out.println("Phone number for " + record1.getName() + ": " + record1.getPhoneNumber());
        } else {
            System.out.println("Record not found.");
        }

        ArrayList<Record> records = phonebook.findAll("John Doe");
        if (records != null) {
            for (Record record2 : records) {
                System.out.println("Phone number for " + record2.getName() + ": " + record2.getPhoneNumber());
            }
        } else {
            System.out.println("Record not found.");
        }

    }
}
