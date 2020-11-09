//package loginandregister;
//
//import database.SQLConnection;
//
//import javax.swing.*;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//public class ControlPerson {
//
//    SQLConnection connection = new SQLConnection();
//
////    public void insert(ModelPerson mod) {
////        try {
////            connection.setConn();
////            PreparedStatement pst = connection.conn.prepareStatement("INSERT INTO person (id, firstName, lastName, email, password) VALUES (?, ?, ?, ?, ?");
////            pst.setInt(1, mod.getId());
////            pst.setString(2, mod.getFirstName());
////            pst.setString(3, mod.getLastName());
////            pst.setString(4, mod.getEmail());
////            pst.setString(5, mod.getPassword());
////            pst.executeUpdate();
////            System.out.println("Data of " + mod.getFirstName() + " Registered");
////        } catch (SQLException e) {
////            System.out.println("Error: " + e);
////        }
////    }
//
//    public void insert(ModelPerson mod) {
//        try {
//            connection.setConn();
//            PreparedStatement pst = connection.conn.prepareStatement("INSERT INTO person (firstName, lastName, email, password) VALUES (?, ?, ?, ?");
////            pst.setInt(1, mod.getId());
//            pst.setString(2, mod.getFirstName());
//            pst.setString(3, mod.getLastName());
//            pst.setString(4, mod.getEmail());
//            pst.setString(5, mod.getPassword());
//            pst.executeUpdate();
//            System.out.println("Data of " + mod.getFirstName() + " Registered");
//        } catch (SQLException e) {
//            System.out.println("Error: " + e);
//        }
//    }
//
//    public void update(ModelPerson mod, int id) {
//        connection.setConn();
//        try {
//            if (mod.getFirstName().equals("")) {
//                JOptionPane.showMessageDialog(null, "Add your first name");
//            } else if (mod.getLastName().equals("")) {
//                JOptionPane.showMessageDialog(null, "Add your last name");
//            } else if (mod.getEmail().equals("")) {
//                JOptionPane.showMessageDialog(null, "Add your email!!");
//            } else if (mod.getPassword().equals("")) {
//                JOptionPane.showMessageDialog(null, "Enter your password");
//            }
//            PreparedStatement pst = connection.conn.prepareStatement("UPDATE person SET firstName= ?, lastName= ?, email= ?, password= ?");
//            pst.setString(1, mod.getFirstName());
//            pst.setString(2, mod.getLastName());
//            pst.setString(3, mod.getEmail());
//            pst.setString(4, mod.getPassword());
//            pst.setInt(5, id);
//            pst.execute();
//        } catch (SQLException sqlException) {
//            JOptionPane.showMessageDialog(null, "Error updating data because" + sqlException);
//        }
//        connection.disconnect();
//    }
//
//    public void delete(int id) {
//        connection.setConn();
//        try {
//            PreparedStatement pst = connection.conn.prepareStatement("DELETE FROM person WHERE id= '" + id + "'");
//            pst.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Successfully Deleted");
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error deleting element. Try Again!!");
//        } finally {
//            connection.disconnect();
//        }
//    }
//
//    public void setInTable(String SQL, JTable table) {
//        String id = null;
//
//        connection.setConn();
//        ArrayList datas = new ArrayList();
//        String[] Columns = new String[]{"", "ID", "Name", "Email"};
//        connection.executeSQL(SQL);
//        try {
//            connection.rs.first();
//            do {
//                datas.add(new Object[]{
//                        "",
//                        connection.rs.getString("id"),
//                        connection.rs.getString("firstName") + " " + connection.rs.getString("lastName"),
//                        connection.rs.getString("email")});
//            } while (connection.rs.next());
//        } catch (SQLException ex) {
////            JOptionPane.showMessageDialog(rootPane, "Registration List Empty!!!");
//        } finally {
//            connection.disconnect();
//        }
//    }
//}
