/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.Product;
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
 * @author Chien
 */
public class ProductDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getDouble(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByCateID(String cateID) {
        List<Product> list = new ArrayList<>();
        String sql = "Select * from Product where CateID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, cateID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getDouble(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByCustomerID(int cus) {
        List<Product> list = new ArrayList<>();
        String sql = "Select * from Product where addbycid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cus);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getDouble(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchProduct(String type, String search) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product where " + type + " like '%" + search + "%'";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getDouble(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductByid(String pid) {
        String sql = "Select * from Product where pid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getDouble(10));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void insertProduct(Product pro) {
        try {
            String sql = "INSERT INTO [dbo].[Product]\n"
                    + "           ([pid]\n"
                    + "           ,[pname]\n"
                    + "           ,[quantity]\n"
                    + "           ,[price]\n"
                    + "           ,[image]\n"
                    + "           ,[description]\n"
                    + "           ,[status]\n"
                    + "           ,[cateID]\n"
                    + "           ,[addbycid]\n"
                    + "           ,[avgvote])"
                    + "     VALUES(?,?,?,?,?,?,?,?,?,?)";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, pro.getPid());
            ps.setString(2, pro.getPname());
            ps.setInt(3, pro.getQuantity());
            ps.setDouble(4, pro.getPrice());
            ps.setString(5, pro.getImg());
            ps.setString(6, pro.getDecs());
            ps.setInt(7, pro.getStatus());
            ps.setInt(8, pro.getCateid());
            ps.setInt(9, pro.getAddbycid());
            ps.setDouble(10, pro.getAvgvote());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void removeProduct(String pid) {
        try {
            String sql = "DELETE FROM [dbo].[Product]\n"
                    + "      WHERE pid = ?";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateProduct(Product pro) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [pname] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[image] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[status] = ?\n"
                + "      ,[cateID]  = ?\n"
                + "      ,[addbycid]  = ?\n"
                + "      ,[avgvote] = ?\n"
                + " WHERE pid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, pro.getPname());
            ps.setInt(2, pro.getQuantity());
            ps.setDouble(3, pro.getPrice());
            ps.setString(4, pro.getImg());
            ps.setString(5, pro.getDecs());
            ps.setInt(6, pro.getStatus());
            ps.setInt(7, pro.getCateid());
            ps.setInt(8, pro.getAddbycid());
            ps.setDouble(9, pro.getAvgvote());
            ps.setString(10, pro.getPid());

            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public int countproduct() {
        String sql = "Select count(*)  from Product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Product> getProductbypage(int page) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product order by pname offset ? rows fetch next 8 rows only";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (page - 1) * 8);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getDouble(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        dao.removeProduct("2222");

    }
}
