package manager;

import models.Doctor;
import models.Patient;
import models.Consultation;

public interface SkinConsultationManager {
    void addDoctor(Doctor doctor);
    void removeDoctor(String medicalLicenseNumber);
    void printDoctors();
    void bookConsultation(Patient patient, String specialization, String dateTime);
}

