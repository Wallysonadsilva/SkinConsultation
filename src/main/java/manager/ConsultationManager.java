package manager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import models.Consultation;
import models.Doctor;
import models.Patient;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConsultationManager {
    private List<Doctor> doctors = new ArrayList<>();
    private List<Consultation> consultations = new ArrayList<>();
    private static final String DOCTORS_FILE = "doctors.json";
    private static final String CONSULTATIONS_FILE = "consultations.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ConsultationManager() {
        objectMapper.registerModule(new JavaTimeModule());
        loadDoctors();
        loadConsultations();
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }


    // Add Doctor and Save to File
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        saveDoctors();
    }

    // Remove Doctor and Save to File
    public void removeDoctor(String medicalLicenseNumber) {
        doctors.removeIf(doctor -> doctor.getMedicalLicenseNumber().equals(medicalLicenseNumber));
        saveDoctors();
    }

    // Print All Doctors
    public void printDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("❌ No doctors available.");
        } else {
            doctors.forEach(System.out::println);
        }
    }

    // Book a Consultation
    public void bookConsultation(Patient patient, String specialization, String dateTime) {
        Optional<Doctor> availableDoctor = doctors.stream()
                .filter(doctor -> doctor.getSpecialization().equalsIgnoreCase(specialization))
                .findFirst();

        if (availableDoctor.isPresent()) {
            Consultation consultation = new Consultation(availableDoctor.get(), patient,
                    LocalDateTime.parse(dateTime), 25, "No notes yet");
            consultations.add(consultation);
            saveConsultations();
            System.out.println("Consultation booked successfully with Dr. " + availableDoctor.get().getSurname());
        } else {
            System.out.println("No available doctor found for specialization: " + specialization);
        }
    }

    // Print All Consultations
    public void printConsultations() {
        if (consultations.isEmpty()) {
            System.out.println("No consultations available.");
        } else {
            consultations.forEach(System.out::println);
        }
    }

    // Save Doctors to JSON
    private void saveDoctors() {
        try {
            objectMapper.writeValue(new File(DOCTORS_FILE), doctors);
        } catch (IOException e) {
            System.out.println("Error saving doctors: " + e.getMessage());
        }
    }

    //Save Consultations to JSON
    private void saveConsultations() {
        try {
            objectMapper.writeValue(new File(CONSULTATIONS_FILE), consultations);
            System.out.println("Consultations saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving consultations: " + e.getMessage());
        }
    }

    //Load Doctors from JSON
    private void loadDoctors() {
        try {
            File file = new File(DOCTORS_FILE);
            if (file.exists() && file.length() > 0) {
                doctors = objectMapper.readValue(file, new TypeReference<List<Doctor>>() {});
                System.out.println("Doctors loaded successfully.");
            } else {
                System.out.println("No saved doctors found.");
            }
        } catch (IOException e) {
            System.out.println("Error loading doctors: " + e.getMessage());
        }
    }

    //Load Consultations from JSON
    private void loadConsultations() {
        try {
            File file = new File(CONSULTATIONS_FILE);
            if (file.exists() && file.length() > 0) {
                consultations = objectMapper.readValue(file, new TypeReference<List<Consultation>>() {});
                System.out.println("Consultations loaded successfully." + consultations.size());
            } else {
                System.out.println("No saved consultations found.");
            }
        } catch (IOException e) {
            System.out.println("Error loading consultations: " + e.getMessage());
        }
    }
}
