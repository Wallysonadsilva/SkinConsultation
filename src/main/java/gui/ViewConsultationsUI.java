package gui;

import manager.ConsultationManager;
import models.Consultation;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewConsultationsUI extends JFrame {
    public ViewConsultationsUI(ConsultationManager manager) {
        setTitle("View Consultations");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        List<Consultation> consultations = manager.getConsultations();

        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        if (consultations.isEmpty()) {
            textArea.setText("No consultations available.");
        } else {
            StringBuilder consultationList = new StringBuilder();
            for (Consultation consultation : consultations) {
                consultationList.append("Doctor: ")
                        .append(consultation.getDoctor().getSurname())
                        .append(" | Patient: ")
                        .append(consultation.getPatient().getName())
                        .append(" ")
                        .append(consultation.getPatient().getSurname())
                        .append(" | Date: ")
                        .append(consultation.getDateTime())
                        .append(" | Cost: £")
                        .append(consultation.getCost())
                        .append("\n");
            }
            textArea.setText(consultationList.toString());
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }
}
