package models;

import java.time.LocalDateTime;

public class Consultation {
    private Doctor doctor;
    private Patient patient;
    private LocalDateTime dateTime;
    private double cost;
    private String notes;

    public Consultation() {}

    public Consultation(Doctor doctor, Patient patient, LocalDateTime dateTime, double cost, String notes) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateTime = dateTime;
        this.cost = cost;
        this.notes = notes;
    }

    public Doctor getDoctor() { return doctor; }
    public Patient getPatient() { return patient; }
    public LocalDateTime getDateTime() { return dateTime; }
    public double getCost() { return cost; }
    public String getNotes() { return notes; }

    @Override
    public String toString() {
        return "Consultation with Dr. " + doctor.getSurname() + " on " + dateTime + " (Cost: £" + cost + ")";
    }
}
