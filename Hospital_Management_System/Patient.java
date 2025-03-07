package Hospital_Management_System;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Patient {
  private Connection connection;
  private Scanner scanner;

  public Patient(Connection connection, Scanner scanner) {
    this.connection = connection;
    this.scanner = scanner;
  }

  public void addPatient() {
    System.out.println("Enter patient name: ");
    String name = scanner.next();
    System.out.println("Enter patient age: ");
    int age = scanner.nextInt();
    System.out.println("Enter patient gender");
    String gender = scanner.next();
    try {
      String query = "INSERT INTO patients(name,age,gender) VALUES(?,?,?)";
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, name);
      preparedStatement.setInt(2, age);
      preparedStatement.setString(3, gender);
      int affectedRows = preparedStatement.executeUpdate();
      if (affectedRows > 0) {
        System.out.println("Patient added successfully");
      } else {
        System.out.println("Patient addition failed");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void showPatient() {
    // Implementation for showing patient details
    String query = "SELECT * FROM patients";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      ResultSet resultset = preparedStatement.executeQuery();
      System.out.println("+-----------+---------------------+--------+----------+");
      System.out.println("| ID        | Name                | Age    | Gender   |");
      System.out.println("+-----------+---------------------+--------+----------+");
      while (resultset.next()) {
        System.out.printf("| %-10d| %-20s| %-7d| %-9s|\n", resultset.getInt("id"), resultset.getString("name"),
            resultset.getInt("age"), resultset.getString("gender"));
            System.out.println("+-----------+---------------------+--------+----------+");
        
    } }catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public boolean getPatientById(int id) {
    // Implementation for getting patient by id
    String query = "SELECT * FROM patients WHERE id = ?";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, id);
      ResultSet resultset = preparedStatement.executeQuery();
      if (resultset.next()) {
           return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
}
}
