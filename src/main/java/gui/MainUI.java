package gui;

import manager.ConsultationManager;
import javax.swing.*;
import java.awt.*;

public class MainUI extends JFrame {
    private ConsultationManager manager;

    public MainUI() {
        setTitle("Skin Consultation System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        manager = new ConsultationManager();

        setupUI();

        setVisible(true);
    }

    private void setupUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton viewDoctorsButton = new JButton("View Doctors");
        JButton bookConsultationButton = new JButton("Book Consultation");
        JButton viewConsultationsButton = new JButton("View Consultations");
        JButton exitButton = new JButton("Exit");

        panel.add(viewDoctorsButton);
        panel.add(bookConsultationButton);
        panel.add(viewConsultationsButton);
        panel.add(exitButton);

        viewDoctorsButton.addActionListener(e -> new DoctorListUI(manager));
        bookConsultationButton.addActionListener(e -> new BookConsultationUI(manager));
        viewConsultationsButton.addActionListener(e -> new ViewConsultationsUI(manager));
        exitButton.addActionListener(e -> System.exit(0));

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainUI::new);
    }
}
