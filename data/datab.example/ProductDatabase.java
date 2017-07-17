package datab.example;

import java.sql.*;

public class ProductDatabase {

  // JDBC driver name and database URL
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost:3306/inventory";

  //  Database credentials
  static final String USER = "root";
  static final String PASS = "root";

  static Connection conn;
  static Statement statement;
  static PreparedStatement ps;
  static String sql;
  static Statement s;

  private void init() {
    try {
      Class.forName(JDBC_DRIVER);

      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      System.out.println("Creating statement...");

      s = conn.createStatement();
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println(e);
    }
  }

  public ResultSet fetchData() throws SQLException {
    init();
    sql = "select * from Product";

    return s.executeQuery(sql);
  }

  public int insertSql(String s, float p, int a) throws SQLException {
    init();
    String insert = "insert into Product values ( ? , ? , ? )";
    ps = conn.prepareStatement(insert);
    ps.setString(1, s);
    ps.setFloat(2, p);
    ps.setInt(3, a);

    return ps.executeUpdate();
  }

  public void connectionClose() throws SQLException {
    System.out.println("Closing database connection");

    conn.close();
  }

  public int deleteSql(String s) throws SQLException {
    init();

    String sql = "delete from Product where name=?";
    ps = conn.prepareStatement(sql);
    ps.setString(1, s);

    return ps.executeUpdate();
  }
}
