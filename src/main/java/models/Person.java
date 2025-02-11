package models;

public class Person {
    private String name;
    private String surname;
    private String dateOfBirth;
    private String mobileNumber;

    public Person() {}

    public Person(String name, String surname, String dateOfBirth, String mobileNumber) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getDateOfBirth() { return dateOfBirth; }
    public String getMobileNumber() { return mobileNumber; }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
