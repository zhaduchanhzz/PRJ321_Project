/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Context.DBContext;
import DAO.ProductDAO;
import DAO.ReviewDAO;
import Entity.Customer;
import Entity.Product;
import Entity.Review;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Chien
 */
@WebServlet(name = "DetailController", urlPatterns = {"/Detail"})
public class DetailProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            if (action == null) {
                action = "show";
            }
            if (action.equals("show")) {
                String pid = request.getParameter("pid");
                ProductDAO dao = new ProductDAO();
                Product pro = dao.getProductByid(pid);
                List<Product> list = new ArrayList<Product>();
                list.add(pro);
                request.setAttribute("details", list);
                ReviewDAO reviewdao = new ReviewDAO();
                List<Review> listrv = new ArrayList<Review>();
                listrv = reviewdao.getReviewbypid(pid);
                request.setAttribute("listrv", listrv);
                request.getRequestDispatcher("Detail.jsp").forward(request, response);
            }
            if (action.equalsIgnoreCase("addrv")) {
                String pid = request.getParameter("pid");
                ProductDAO dao = new ProductDAO();
                Product pro = dao.getProductByid(pid);
                HttpSession session = request.getSession();
                Customer cus = (Customer) session.getAttribute("acc");
                if (cus != null) {
                    ReviewDAO reviewdao = new ReviewDAO();
                    List<Review> listrv = new ArrayList<Review>();
                    Review check = reviewdao.checkReview(pid, cus.getId());
                    if (check == null) {
                        String grade = request.getParameter("rate");
                        String comment = request.getParameter("comment");
                        int vote = 0;
                        try {
                            vote = Integer.parseInt(grade);
                        } catch (Exception e) {
                        }
                        Review review = new Review(pid, cus.getId(), comment, vote);
                        reviewdao.insertReview(review);
                        int a = reviewdao.sumreviewbyid(pid);
                        int b = reviewdao.countreview(pid);
                        double avg = (double) a / b;
                        double roundOff = Math.round(avg * 10.0) / 10.0;

                        pro.setAvgvote(roundOff);
                        dao.updateProduct(pro);
                        listrv = reviewdao.getReviewbypid(pid);
                        request.setAttribute("listrv", listrv);
                        List<Product> list = new ArrayList<Product>();
                        list.add(pro);

                        response.sendRedirect("./Detail?action=show&pid=" + pid);
                    }
                    if (check != null) {
                        List<Product> list = new ArrayList<Product>();
                        list.add(pro);
                        request.setAttribute("details", list);
                        listrv = reviewdao.getReviewbypid(pid);
                        request.setAttribute("listrv", listrv);
                        request.setAttribute("mess", "You can add only one review");
                        response.sendRedirect("./Detail?action=show&pid=" + pid);

                    }

                } else {
                    request.setAttribute("mess", "Login begfore review");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
