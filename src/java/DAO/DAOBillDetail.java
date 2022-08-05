/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.Billdetail;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhadu
 */
public class DAOBillDetail {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void insertBilldetail(Billdetail bill) {
        String sql = "INSERT INTO [dbo].[BillDetail]\n"
                + "           ([pid]\n"
                + "           ,[oID]\n"
                + "           ,[quantity]\n"
                + "           ,[price]\n"
                + "           ,[total]\n"
                + "           ,[date])"
                + " values(?,?,?,?,?,Getdate())";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, bill.getPid());
            pre.setInt(2, bill.getOid());
            pre.setInt(3, bill.getQuantity());
            pre.setDouble(4, bill.getPrice());
            pre.setDouble(5, bill.getTotal());

            pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void changeQuantity(String id, int quan) {
        int n = 0;
        String sql = "update BillDetail set quantity=? where oid=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, quan);
            pre.setString(2, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBillDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (n > 0) {
            System.out.println("Updated");
        }
    }

    public void deleteBillDetail(String id) {
        int n = 0;
        String sql = "delete from BillDetail where oid=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBillDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (n > 0) {
            System.out.println("Deleted");
        }

    }

    public List<Billdetail> getAllBill() {
        List<Billdetail> list = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[Billdetail]";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Billdetail(rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Billdetail> getBillbyproductid(String pid) {
        List<Billdetail> list = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[Billdetail] where oid =";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);

            rs = ps.executeQuery();
            while (rs.next()) {
                 list.add(new Billdetail(rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
