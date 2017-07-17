package datab.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnection {

  public static void main(String[] args) {
    try {
      //Not needed in new JDBC drivers (4+)
      //Class.forName("com.mysql.jdbc.Driver");
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                                                          "root", "root");

      String creatPro = "create table Product(Name varchar(50), Price float, Quantity int";
      String insertEmp = "insert into Employee VALUES (?, ?)";
      PreparedStatement statement = connection.prepareStatement(insertEmp);
      statement.setString(1, "Abhay");
      statement.setInt(2, 1200);

//      ResultSet rs = statement.executeQuery("select * from Employee");
      int rs = statement.executeUpdate();
//      while (rs.next()) {
//        System.out.println(rs.getString("NAME") + "\t\t"
//                           + rs.getInt("SALARY"));
//      }

      System.out.println(rs);
      connection.close();

    } catch (SQLException e) {
      System.err.println(e);
    }
  }

}
