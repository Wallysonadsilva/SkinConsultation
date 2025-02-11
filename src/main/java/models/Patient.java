package models;

public class Patient extends Person {
    private String patientId;

    public Patient() {}

    public Patient(String name, String surname, String dateOfBirth, String mobileNumber, String patientId) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.patientId = patientId;
    }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " (Patient ID: " + patientId + ")";
    }
}
