package Hospital_Management_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor {
  private Connection connection;
  public Doctor(Connection connection) {
    this.connection = connection;
  }


  public void showDoctor() {
    // Implementation for showing patient details
    String query = "SELECT * FROM doctor";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      ResultSet resultset = preparedStatement.executeQuery();
      System.out.println("+-----------+---------------------+-------------------+");
      System.out.println("| ID        | Name                | specialization    |");
      System.out.println("+-----------+---------------------+--------+----------+");
      while (resultset.next()) {
        System.out.printf("| %-10d| %-20s| %-17s|\n", resultset.getInt("id"), resultset.getString("name"),
            resultset.getInt("specialization"));
        System.out.println("+-----------+---------------------+-------------------+");

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public boolean getDoctorById(int id) {
    // Implementation for getting patient by id
    String query = "SELECT * FROM doctors WHERE id = ?";
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
