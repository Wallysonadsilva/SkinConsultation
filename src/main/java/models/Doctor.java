package models;

public class Doctor extends Person {
    private String medicalLicenseNumber;
    private String specialization;

    public Doctor() {}

    public Doctor(String name, String surname, String dateOfBirth, String mobileNumber,
                  String medicalLicenseNumber, String specialization) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.medicalLicenseNumber = medicalLicenseNumber;
        this.specialization = specialization;
    }

    public String getMedicalLicenseNumber() { return medicalLicenseNumber; }
    public String getSpecialization() { return specialization; }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " - " + specialization;
    }
}
