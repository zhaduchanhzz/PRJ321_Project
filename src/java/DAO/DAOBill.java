/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.Bill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhadu
 */
public class DAOBill {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void updateStt(String oID, int stt) {

        int n = 0;
        String sql = "update Bill set status = ? where oID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, stt);
            pre.setString(2, oID);
            n = pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateBill(Bill bi) {
        String sql = "update Bill set dateCreate=?,cname=?,cphone=?,cAddress=?,"
                + "total=?,status=?, cid=?,discount= ? where oID=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql

            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1, bi.getDateCreate());
            pre.setString(2, bi.getCname());
            pre.setString(3, bi.getCphone());
            pre.setString(4, bi.getCaddress());
            pre.setDouble(5, bi.getTotal());
            pre.setInt(6, bi.getStatus());
            pre.setInt(7, bi.getCid());
            pre.setInt(8, bi.getDiscount());
            pre.setInt(9, bi.getOid());

            pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertBill(Bill bill) {
        String sql = "INSERT INTO [dbo].[Bill]\n"
                + "           ([dateCreate]\n"
                + "           ,[cname]\n"
                + "           ,[cphone]\n"
                + "           ,[cAddress]\n"
                + "           ,[total]\n"
                + "           ,[status]\n"
                + "           ,[cid]\n"
                + "           ,[discount])"
                + " values(Getdate(),?,?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, bill.getCname());
            pre.setString(2, bill.getCphone());
            pre.setString(3, bill.getCaddress());
            pre.setDouble(4, bill.getTotal());
            pre.setInt(5, 0);
            pre.setInt(6, bill.getCid());
            pre.setInt(7, bill.getDiscount());
            pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void changeStatus(String id, int status) {
        int n = 0;
        String sql = "update Bill set status=? where oID=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, status);
            pre.setString(2, id);
            n = pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (n > 0) {
            System.out.println("Updated");
        }
    }

    public void updateTotal(String id, double money) {
        int n = 0;
        String sql = "update Bill set total=total+? where oID=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setDouble(1, money);
            pre.setString(2, id);
            n = pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (n > 0) {
            System.out.println("Updated");
        }
    }

    public void removeBill(String id) {
        int n = 0;
        String sql = "delete from Bill where oID=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            n = pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (n > 0) {
            System.out.println("Removed");
        }
    }

    public List<Bill> getAllBill() {
        List<Bill> list = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[Bill]";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bill(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Bill> getBillbyproductid(String pid) {
        List<Bill> list = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[Bill] where pid =";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bill(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int getLastbillid() {
        int max = 0;
        List<Bill> list = new ArrayList<>();
        String query = "select max(oID) from Bill";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return max;
    }

    public static void main(String[] args) {
        DAOBill dao = new DAOBill();
        Bill bill = new Bill(0, "", "ha duc ", "00000", "trung quoc", 400, 1, 4, 0);
        dao.insertBill(bill);
    }
}
