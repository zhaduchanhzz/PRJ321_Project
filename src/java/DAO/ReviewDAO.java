/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.Review;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhadu
 */
public class ReviewDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void insertReview(Review review) {
        try {
            String sql = "INSERT INTO [dbo].[Review]\n"
                    + "           ([pid]\n"
                    + "           ,[cid]\n"
                    + "           ,[Comment]\n"
                    + "           ,[grade])\n"
                    + "     VALUES(?,?,?,?)";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, review.getPid());
            ps.setInt(2, review.getCid());
            ps.setString(3, review.getComment());
            ps.setInt(4, review.getGrade());

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ReviewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Review> getReviewbypid(String pid) {
        List<Review> list = new ArrayList<>();
        String sql = "Select * from Review where pid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Review(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Review checkReview(String pid, int cid) {
        String sql = "Select * from Review where pid = ? and cid =?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, pid);
            ps.setInt(2, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Review(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public int countreview(String pid) {
        String sql = "Select count(grade)  from Review where pid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int sumreviewbyid(String pid) {
        String sql = "Select sum(grade)  from Review where pid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
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

    public static void main(String[] args) {
        ReviewDAO dao = new ReviewDAO();
        System.out.println(dao.countreview("P03"));
        System.out.println(dao.sumreviewbyid("P03"));
        System.out.println(dao.getReviewbypid("P03"));
        double avg = 0;
        double sum = (double) dao.sumreviewbyid("P03");
        double count = (double) dao.countreview("P03");

        avg = (double) dao.sumreviewbyid("P03") / dao.countreview("P03");
        double roundOff = Math.round(avg * 10.0) / 10.0;

        System.out.println(roundOff);
    }

}
