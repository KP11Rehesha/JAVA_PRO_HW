package Phonebook;

import java.util.ArrayList;

public class Phonebook {
    private ArrayList<Record> records;

    public Phonebook() {
        records = new ArrayList<Record>();
    }

    public void add(Record record) {
        records.add(record);
    }

    public Record find(String name) {
        for (Record record : records) {
            if (record.getName().equals(name)) {
                return record;
            }
        }
        return null;
    }

    public ArrayList<Record> findAll(String name) {
        ArrayList<Record> foundRecords = new ArrayList<Record>();
        for (Record record : records) {
            if (record.getName().equals(name)) {
                foundRecords.add(record);
            }
        }
        if (foundRecords.size() > 0) {
            return foundRecords;
        } else {
            return null;
        }
    }
}