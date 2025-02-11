package gui;

import manager.ConsultationManager;
import models.Doctor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DoctorListUI extends JFrame {
    public DoctorListUI(ConsultationManager manager) {
        setTitle("List of Doctors");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        List<Doctor> doctors = manager.getDoctors();

        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        if (doctors == null || doctors.isEmpty()) {
            textArea.setText("No doctors available.");
        } else {
            StringBuilder doctorList = new StringBuilder();
            for (Doctor doctor : doctors) {
                doctorList.append(doctor.getName())
                        .append(" ")
                        .append(doctor.getSurname())
                        .append(" - Specialization: ")
                        .append(doctor.getSpecialization())
                        .append("\n");
            }
            textArea.setText(doctorList.toString());
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }
}
