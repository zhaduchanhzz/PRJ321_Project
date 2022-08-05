/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import Entity.Category;
import Entity.Customer;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ManageProductController", urlPatterns = {"/ManageProduct"})
public class ManageProductController extends HttpServlet {

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
        ProductDAO pdao = new ProductDAO();
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        Customer user = (Customer) session.getAttribute("acc");
        if (action == null) {
            if (user.getRole() < 1) {
                response.sendRedirect("./Homepage");
            }
            if (user.getRole() == 1) {
                action = "listbyid&?id=" + user.getId();
            }
            if (user.getRole() >= 2) {
                action = "listall";
            }
        }
        if (action.equals("listall")) {
            List<Product> managep = pdao.getAllProduct();
            request.setAttribute("managep", managep);
            request.getRequestDispatcher("ManageProduct.jsp").forward(request, response);
        }
        if (action.equalsIgnoreCase("listbyid")) {
            String id = request.getParameter("id");
            int idd = 0;
            if (id == null) {
                id = user.getId() + "";
                try {
                    idd = Integer.parseInt(id);
                } catch (Exception e) {
                }
            }
            List<Product> listP = pdao.getProductByCustomerID(idd);
            request.setAttribute("managep", listP);
            request.getRequestDispatcher("ManageProduct.jsp").forward(request, response);
        }
        if (action.equalsIgnoreCase("add")) {
            CategoryDAO catedao = new CategoryDAO();
            List<Category> listcate = catedao.getAllCategory();
            request.setAttribute("listcate", listcate);
            String submit = request.getParameter("submit");
            if (submit == null) {
                request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
            } else {
                String pid = request.getParameter("pid");
                String pname = request.getParameter("pname");
                String quantity = request.getParameter("quantity");
                String price = request.getParameter("price");
                String image = request.getParameter("image");
                String desc = request.getParameter("des");
                String cateid = request.getParameter("cate");
                int quan = 0;
                double pricee = 0;
                int cate = 0;

                try {
                    quan = Integer.parseInt(quantity);
                    cate = Integer.parseInt(cateid);
                    pricee = Double.valueOf(price);
                } catch (Exception e) {
                }

                Product pro = new Product(pid, pname, quan, pricee, image, desc, 1, cate, user.getId(), 0);
                ProductDAO prodao = new ProductDAO();
                prodao.insertProduct(pro);
                System.out.println(pro);
                response.sendRedirect("./ManageProduct");

            }
        }
        if (action.equalsIgnoreCase("update")) {

            CategoryDAO catedao = new CategoryDAO();
            List<Category> listcate = catedao.getAllCategory();
            request.setAttribute("listcate", listcate);
            String submit = request.getParameter("submit");
            if (submit == null) {
                String pid = request.getParameter("pid");
                ProductDAO prodao = new ProductDAO();

                Product pro = prodao.getProductByid(pid);
                List<Product> aaa = new ArrayList<Product>();
                aaa.add(pro);

                request.setAttribute("update", aaa);
                request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
            } else {
                String pid = request.getParameter("pid");
                ProductDAO prodao = new ProductDAO();

                Product pro = prodao.getProductByid(pid);
                String pname = request.getParameter("pname");
                String quantity = request.getParameter("quantity");
                String price = request.getParameter("price");
                String image = request.getParameter("image");
                String desc = request.getParameter("des");
                String cateid = request.getParameter("cate");
                int quan = 0;
                double pricee = 0;
                int cate = 0;

                try {
                    quan = Integer.parseInt(quantity);
                    cate = Integer.parseInt(cateid);
                    pricee = Double.parseDouble(price);

                } catch (Exception e) {
                }
                pro.setPname(pname);
                pro.setQuantity(quan);
                pro.setPrice(pricee);
                pro.setCateid(cate);
                pro.setDecs(desc);
                pro.setImg(image);
                System.out.println(pro);
                prodao.updateProduct(pro);
                response.sendRedirect("./ManageProduct");

            }

        }
        if (action.equalsIgnoreCase("delete")) {
            String pid = request.getParameter("pid");
            ProductDAO dao = new ProductDAO();
            dao.removeProduct(pid);
            response.sendRedirect("./ManageProduct");

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
