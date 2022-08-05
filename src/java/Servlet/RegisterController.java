/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.CustomerDAO;
import Encrypt.Encrypt;
import Entity.Customer;
import Recaptcha.VerifyUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chien
 */
public class RegisterController extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignInController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignInController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
//        processRequest(request, response);
        CustomerDAO userDAO = new CustomerDAO();

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
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        //verify 
        //System.out.println(gRecaptchaResponse);
        boolean valid = VerifyUtils.verify(gRecaptchaResponse);
        if (valid) {
            if (name.equals("") || username.equals("") || pass.equals("") || cphone.equals("") || caddress.equals("") || pass2.equals("") || answer.equals("")) {
                request.setAttribute("mess1", "Please enter full field");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            } else {
                if (checkUser != null) {
                    request.setAttribute("mess2", "The user already exist!");
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                } else if (!pass.equals(repass)) {
                    request.setAttribute("mess3", "Re-password must be same password");
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                } else {
                    Encrypt en;
                    try {
                        en = new Encrypt();
                        pass = en.encrypt(pass);
                        pass2 = en.encrypt(pass2);
                    } catch (Exception ex) {
                        Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Customer user = new Customer(name, cphone, caddress, username, pass, 1, 0, questindexx, answer, pass2, email);
                    userDAO.addUserToDB(user);
                    request.setAttribute("mess", "Create success");

                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }

            }
        } else {
            request.setAttribute("mess", "Missed the captra");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
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
