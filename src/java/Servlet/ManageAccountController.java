/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.CustomerDAO;
import Entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chien
 */
@WebServlet(name = "ManageAccountController", urlPatterns = {"/ManageAccount"})
public class ManageAccountController extends HttpServlet {

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
                action = "listall";
            }
            if (action.equalsIgnoreCase("listall")) {
                CustomerDAO udao = new CustomerDAO();
                List<Customer> listU = udao.getAllUser();
                request.setAttribute("listU", listU);
                request.getRequestDispatcher("ManageAccount.jsp").forward(request, response);
            }
            if (action.equalsIgnoreCase("add")) {
                CustomerDAO userDAO = new CustomerDAO();
                List<Customer> listU = userDAO.getAllUser();
                request.setAttribute("listU", listU);
                String name = request.getParameter("name");
                String username = request.getParameter("user");
                String pass = request.getParameter("password");
                String repass = request.getParameter("re-password");
                String cphone = request.getParameter("cphone");
                String caddress = request.getParameter("caddress");
                String pass2 = request.getParameter("pass2");
                String questindex = request.getParameter("questindex");
                String answer = request.getParameter("answer");
                String email = request.getParameter("email");
                Customer checkUser = userDAO.getUserByUserName(username);
                int questindexx = 0;
                try {
                    questindexx = Integer.parseInt(questindex);
                } catch (Exception e) {
                }
                if (name.equals("") || username.equals("") || pass.equals("") || cphone.equals("") || caddress.equals("") || pass2.equals("") || answer.equals("")) {
                    request.setAttribute("mess1", "Please enter full field");
                    request.getRequestDispatcher("ManageAccount.jsp").forward(request, response);
                } else {
                    if (checkUser != null) {
                        request.setAttribute("mess1", "The user already exist!");
                        request.getRequestDispatcher("ManageAccount.jsp").forward(request, response);
                    } else {
                        Customer user = new Customer(name, cphone, caddress, username, pass, 1, 0, questindexx, answer, pass2, email);
                        userDAO.addUserToDB(user);
                        request.setAttribute("mess3", "Create successfully!");
                        request.getRequestDispatcher("ManageAccount.jsp").forward(request, response);
                    }
                }
            }
            if (action.equalsIgnoreCase("block")) {
                CustomerDAO dao = new CustomerDAO();
                String username = request.getParameter("us");
                Customer user = dao.getUserByUserName(username);
                user.setStatus(0);
                dao.updateUser(user);
                response.sendRedirect("./ManageAccount");
            }
            if (action.equalsIgnoreCase("unblock")) {
                CustomerDAO dao = new CustomerDAO();
                String username = request.getParameter("us");
                Customer user = dao.getUserByUserName(username);
                user.setStatus(1);
                dao.updateUser(user);
                response.sendRedirect("./ManageAccount");
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
