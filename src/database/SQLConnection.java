package database;

import java.sql.*;

public class SQLConnection {

//    public Statement stm;
//    public ResultSet rs;
//    public Connection conn;
//
//    private final String driver = "com.mysql.cj.jdbc.Driver";
//    private final String path = "jdbc:mysql://localhost:3306/beauty_checker?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//    private final String user = "root";
//    private final String pass = "";
//
//    public void setConn() {
//        try {
//            System.getProperty("jdbc.Driver", driver);
//            conn = DriverManager.getConnection(path, user, pass);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public void disconnect() {
//        try {
//            conn.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public void executeSQL(String SQL) {
//        try {
//            stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            rs = stm.executeQuery(SQL);
//        } catch (SQLException throwables) {
//            System.out.println("Error: " + throwables);
//        }
//    }
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/beauty_checker?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}
