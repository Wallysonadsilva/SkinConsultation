import gui.MainUI;
import manager.ConsultationManager;
import models.Doctor;
import models.Patient;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    private static ConsultationManager manager = new ConsultationManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Skin Consultation System");
        System.out.println("1. Run in Console Mode");
        System.out.println("2. Open GUI Mode");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            runConsoleMode(scanner);
        } else if (choice == 2) {
            SwingUtilities.invokeLater(MainUI::new);
        } else {
            System.out.println("Invalid option. Exiting...");
        }
    }

    private static void runConsoleMode(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Skin Consultation System (Console Mode) ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. Remove Doctor");
            System.out.println("3. Print Doctors");
            System.out.println("4. Book Consultation");
            System.out.println("5. Print Consultations");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Doctor Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Surname: ");
                    String surname = scanner.nextLine();
                    System.out.println("Enter Medical License Number: ");
                    String license = scanner.nextLine();
                    System.out.println("Enter Specialization: ");
                    String specialization = scanner.nextLine();
                    manager.addDoctor(new Doctor(name, surname, "N/A", "N/A", license, specialization));
                    break;

                case 2:
                    System.out.println("Enter Medical License Number to Remove: ");
                    String licenseToRemove = scanner.nextLine();
                    manager.removeDoctor(licenseToRemove);
                    break;

                case 3:
                    manager.printDoctors();
                    break;

                case 4:
                    System.out.println("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    System.out.println("Enter Surname: ");
                    String patientSurname = scanner.nextLine();
                    System.out.println("Enter Specialization Required: ");
                    String specializationRequired = scanner.nextLine();
                    System.out.println("Enter Consultation Date (YYYY-MM-DDTHH:MM): ");
                    String dateTime = scanner.nextLine();

                    Patient patient = new Patient(patientName, patientSurname, "N/A", "N/A", "P" + System.currentTimeMillis());
                    manager.bookConsultation(patient, specializationRequired, dateTime);
                    break;

                case 5:
                    manager.printConsultations();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println(" Invalid option. Please try again.");
            }
        }
    }
}
