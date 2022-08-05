/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Encrypt.Encrypt;
import Entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chien
 */
public class CustomerDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Customer> getAllUser() {
        List<Customer> list = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[Customer]";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void addUserToDB(Customer user) {
        try {
            String sql = "INSERT INTO [dbo].[Customer]\n"
                    + "           ([cname]\n"
                    + "           ,[cphone]\n"
                    + "           ,[cAddress]\n"
                    + "           ,[username]\n"
                    + "           ,[password]\n"
                    + "           ,[status]\n"
                    + "           ,[role]\n"
                    + "           ,[questIndex]\n"
                    + "           ,[answer]\n"
                    + "           ,[pass2]\n"
                    + "           ,[email])\n"
                    + "     VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getCname());
            ps.setString(2, user.getCphone());
            ps.setString(3, user.getcAddress());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getStatus());
            ps.setInt(7, user.getRole());
            ps.setInt(8, user.getQuestindex());
            ps.setString(9, user.getAnswer());
            ps.setString(10, user.getPass2());
            ps.setString(11, user.getEmail());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delUser(String name) {
        String sql = "delete select *  FROM Customer\n"
                + "where UserName = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Customer getUserByUserName(String Username) {
        String sql = "select *  FROM Customer where UserName = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, Username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11), rs.getString(12));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Customer getCustomer(String username, String pass) {
        try {
            String sql = "select *  FROM Customer where UserName = ? and Password = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11), rs.getString(12));
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateUser(Customer cus) {
        String sql = "UPDATE [dbo].[Customer]\n"
                + "   SET [cname] = ?\n"
                + "      ,[cphone] = ?\n"
                + "      ,[cAddress] = ?\n"
                + "      ,[username] = ?\n"
                + "      ,[password] = ?\n"
                + "      ,[status] = ?\n"
                + "      ,[role] = ?\n"
                + "      ,[questIndex] = ?\n"
                + "      ,[answer] = ?\n"
                + "      ,[pass2] = ?\n"
                + "      ,[email] = ?\n"
                + " WHERE cid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, cus.getCname());
            ps.setString(2, cus.getCphone());
            ps.setString(3, cus.getcAddress());
            ps.setString(4, cus.getUsername());
            ps.setString(5, cus.getPassword());
            ps.setInt(6, cus.getStatus());
            ps.setInt(7, cus.getRole());
            ps.setInt(8, cus.getQuestindex());
            ps.setString(9, cus.getAnswer());
            ps.setString(10, cus.getPass2());
            ps.setString(11, cus.getEmail());
            ps.setInt(12, cus.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public String getCustomerName(int cid) {
        String s = "";
        String sql = "Select Customer.cname From Customer where Customer.cid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            if (rs.next()) {
                s = rs.getString(1);
                return rs.getString(1);
            }
        } catch (Exception e) {
        }

        return null;
    }

    public Customer getcusbyemail(String Username, String email) {
        String sql = "select *  FROM Customer where UserName = ? and email =?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, Username);
            ps.setString(2, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11), rs.getString(12));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999999);
        return String.format("%09d", number);
    }

    public static void main(String[] args) {
        DAO.CustomerDAO dao = new CustomerDAO();
        List<Customer> list = dao.getAllUser();
        try {
            Encrypt en = new Encrypt();
            for (Customer customer : list) {
                System.out.println(customer.getUsername());
                System.out.println(en.decrypt(customer.getPassword()));
            }
//        
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
