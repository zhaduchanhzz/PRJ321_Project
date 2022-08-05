/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.DiscountCode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhadu
 */
public class DiscountCodeDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public DiscountCode getCode(String content) {
        try {
            String sql = "select *  FROM DiscountCode where code = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, content);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new DiscountCode(rs.getInt(1), rs.getString(2),rs.getDouble(3));
            }
        } catch (Exception ex) {
            Logger.getLogger(DiscountCode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateCode(DiscountCode code) {
        String sql = "UPDATE [dbo].[DiscountCode]\n"
                + "   SET [Status] = ?\n"
                + " WHERE code= ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setInt(1, code.getStatus());
            ps.setString(2, code.getContent());
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
