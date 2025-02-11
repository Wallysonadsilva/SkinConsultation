package gui;

import manager.ConsultationManager;
import models.Patient;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class BookConsultationUI extends JFrame {
    private JTextField nameField, surnameField, specializationField, dateTimeField;
    private final ConsultationManager manager;

    public BookConsultationUI(ConsultationManager manager) {
        this.manager = manager;

        setTitle("Book Consultation");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setupUI();
        setVisible(true);
    }

    private void setupUI() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Patient Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Surname:"));
        surnameField = new JTextField();
        panel.add(surnameField);

        panel.add(new JLabel("Specialization:"));
        specializationField = new JTextField();
        panel.add(specializationField);

        panel.add(new JLabel("Date (YYYY-MM-DDTHH:MM):"));
        dateTimeField = new JTextField();
        panel.add(dateTimeField);

        JButton bookButton = new JButton("Book Consultation");
        bookButton.addActionListener(e -> bookConsultation());

        panel.add(new JLabel(""));
        panel.add(bookButton);

        add(panel);
    }

    private void bookConsultation() {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String specialization = specializationField.getText();
        String dateTimeStr = dateTimeField.getText();

        if (name.isEmpty() || surname.isEmpty() || specialization.isEmpty() || dateTimeStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Patient patient = new Patient(name, surname, "N/A", "N/A", "P" + System.currentTimeMillis());

        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr);
            manager.bookConsultation(patient, specialization, dateTimeStr);
            JOptionPane.showMessageDialog(this, "Consultation booked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Use YYYY-MM-DDTHH:MM", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
