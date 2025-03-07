package Hospital_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HospitalManagementSystem {
  private static final String url = "jdbc:mysql://localhost:3306/hospital";
  private static final String user = "root";
  private static final String password = "12345";

  public static void bookAppointment(Patient patient,Doctor doctor,Connection connection, Scanner scanner) {
    // Implementation for booking appointment
    System.out.println("Enter patient id: ");
    int patientId = scanner.nextInt();
    System.out.println("Enter doctor id: ");
    int doctorId = scanner.nextInt();
    System.out.println("Enter appointment date(YYYY-MM-DD): ");
    String date = scanner.next();
    if(patient.getPatientById(patientId) && doctor.getDoctorById(doctorId)){
      if(checkAvailability(doctorId, date, connection)){
        try {
          String query = "INSERT INTO appointment(patient_id,doctor_i, appointment_date) VALUES(?,?,?)";
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          preparedStatement.setInt(1, patientId);
          preparedStatement.setInt(2, doctorId);
          preparedStatement.setString(3, date);
          int affectedRows = preparedStatement.executeUpdate();
          if (affectedRows > 0) {
            System.out.println("Appointment booked successfully");
          } else {
            System.out.println("Appointment booking failed");
          }
        } catch (SQLException e) {
          e.printStackTrace();

    }
  }
  else{
    System.out.println("Doctor not available on this date");
  }
} }

  public static boolean checkAvailability(int doctorId, String date, Connection connection) {
    // Implementation for checking availability
    String query = "SELECT * FROM appointments WHERE doctor_id = ? AND date = ?";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, doctorId);
      preparedStatement.setString(2, date);
      ResultSet resultset = preparedStatement.executeQuery();
      if (resultset.next()) {
        return false;
      } else {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public static void main(String[] args) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("JDBC Driver not found");
      e.printStackTrace();
    }
    Scanner scanner = new Scanner(System.in);
    try {
      Connection connection = DriverManager.getConnection(url, user, password);
      System.out.println("Connected to the database");
      Patient patient = new Patient(connection, scanner);
      Doctor doctor = new Doctor(connection);
      while (true) {
        System.out.println("1. Add Patients\n2. View Patients\n3. View Doctors\n4. Book Appointment\n5. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
          case 1:
            patient.addPatient();
            break;
          case 2:
            patient.showPatient();
            break;
          case 3:
            doctor.showDoctor();
            break;
          case 4:
            bookAppointment(patient, doctor, connection, scanner);
            break;
          case 5:
            System.out.println("Exiting...");
            connection.close();
            scanner.close();
            System.exit(0);
          default:
            System.out.println("Invalid choice");
        }
      }
    } catch (SQLException e) {
      System.out.println("Connection failed");
      e.printStackTrace();
    }
  }

}