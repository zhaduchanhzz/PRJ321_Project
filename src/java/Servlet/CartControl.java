/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.DAOBill;
import DAO.DAOBillDetail;
import DAO.DiscountCodeDAO;
import DAO.ProductDAO;
import Entity.Bill;
import Entity.Billdetail;
import Entity.Customer;
import Entity.DiscountCode;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zhadu
 */
@WebServlet(name = "CartControl", urlPatterns = {"/CartControl"})
public class CartControl extends HttpServlet {

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
            HttpSession session = request.getSession();
            ProductDAO dao = new ProductDAO();
            List<Product> list = (List<Product>) session.getAttribute("listP");

            String action = request.getParameter("action");

            if (action == null) {
                action = "showcart";

            }
            if (action.equalsIgnoreCase("showcart")) {
                request.getRequestDispatcher("Cart.jsp").forward(request, response);
            }
            if (action.equalsIgnoreCase("add")) {
                String pid = request.getParameter("pid");
                Product pro = dao.getProductByid(pid);
                boolean find = false;
                int indx = 0;
                if (list == null) {
                    list = new ArrayList<>();
                    if (pro != null) {
                        pro.setQuantity(1);
                        list.add(pro);
                        String quan = request.getParameter("qty");
                        if (quan != null) {
                            try {
                                int qua = Integer.parseInt(quan);
                                pro.setQuantity(qua);
                                list.remove(indx);
                                list.add(indx, pro);
                            } catch (Exception e) {
                            }
                        }
                    }
                } else {
                    if (pro != null) {
                        for (int i = 0; i < list.size(); i++) {
                            Product item = list.get(i);
                            if (item.getPid().equals(pid)) {
                                find = true;
                                indx = i;
                            }
                        }
                        if (find) {
                            Product item = list.get(indx);
                            item.setQuantity(item.getQuantity() + 1);
                            list.remove(indx);
                            list.add(indx, item);
                            String quan = request.getParameter("qty");
                            if (quan != null) {
                                try {
                                    int qua = Integer.parseInt(quan);
                                    item.setQuantity(qua);
                                    list.remove(indx);
                                    list.add(indx, item);
                                } catch (Exception e) {
                                }
                            }
                        } else {
                            pro.setQuantity(1);
                            list.add(pro);
                        }
                    }
                }
                double total = 0;
                for (Product product : list) {
                    total = product.getQuantity() * product.getPrice();
                }
                session.setAttribute("total", total);
                session.setAttribute("listP", list);
                request.getRequestDispatcher("./CartControl?action=showcart").forward(request, response);

            }
            if (action.equalsIgnoreCase("remove")) {
                String pid = request.getParameter("pid");
                Product pro = dao.getProductByid(pid);
                boolean find = false;
                int indx = 0;
                if (list == null) {
                    list = new ArrayList<>();
                    if (pro != null) {
                        pro.setQuantity(1);
                        list.add(pro);
                    }
                } else {
                    if (pro != null) {
                        for (int i = 0; i < list.size(); i++) {
                            Product item = list.get(i);
                            if (item.getPid().equals(pid)) {
                                find = true;
                                indx = i;
                            }
                        }
                        if (find) {
                            list.remove(indx);
                        }
                    }
                }
                session.setAttribute("listP", list);
                double total = 0;
                for (Product product : list) {
                    total = product.getQuantity() * product.getPrice();
                }
                session.setAttribute("total", total);
                request.getRequestDispatcher("./CartControl?action=showcart").forward(request, response);
            }
            if (action.equalsIgnoreCase("increse")) {
                String pid = request.getParameter("idd");
                Product pro = dao.getProductByid(pid);
                boolean find = false;
                int indx = 0;
                if (list == null) {
                    list = new ArrayList<>();
                    if (pro != null) {
                        pro.setQuantity(1);
                        list.add(pro);
                    }
                } else {
                    if (pro != null) {
                        for (int i = 0; i < list.size(); i++) {
                            Product item = list.get(i);
                            if (item.getPid().equals(pid)) {
                                find = true;
                                indx = i;
                            }
                        }
                        if (find) {
                            Product item = list.get(indx);
                            item.setQuantity(item.getQuantity() + 1);
                            list.remove(indx);
                            list.add(indx, item);
                        } else {
                            pro.setQuantity(1);
                            list.add(pro);
                        }
                    }
                }
                session.setAttribute("listP", list);
                double total = 0;
                for (Product product : list) {
                    total = product.getQuantity() * product.getPrice();
                }
                session.setAttribute("total", total);
                request.getRequestDispatcher("./CartControl?action=showcart").forward(request, response);

            }
            if (action.equalsIgnoreCase("decrese")) {
                String pid = request.getParameter("idd");
                Product pro = dao.getProductByid(pid);
                boolean find = false;
                int indx = 0;
                if (list == null) {
                    list = new ArrayList<>();
                    if (pro != null) {
                        pro.setQuantity(1);
                        list.add(pro);
                    }
                } else {
                    if (pro != null) {
                        for (int i = 0; i < list.size(); i++) {
                            Product item = list.get(i);
                            if (item.getPid().equals(pid)) {
                                find = true;
                                indx = i;
                            }
                        }
                        if (find) {
                            Product item = list.get(indx);
                            item.setQuantity(item.getQuantity() - 1);
                            list.remove(indx);
                            list.add(indx, item);
                        } else {
                            pro.setQuantity(1);
                            list.add(pro);
                        }
                    }
                }
                session.setAttribute("listP", list);
                double total = 0;
                for (Product product : list) {
                    total = product.getQuantity() * product.getPrice();
                }
                session.setAttribute("total", total);
                request.getRequestDispatcher("./CartControl?action=showcart").forward(request, response);

            }
            if (action.equalsIgnoreCase("discount")) {
                String checkbox = request.getParameter("chkdiscount");
                String discountcode = request.getParameter("discountcode");
                if (checkbox == null) {
                    request.setAttribute("message", "If you want to use discount code please check the check box");
                    request.getRequestDispatcher("./CartControl?action=showcart").forward(request, response);
                }
                if (checkbox != null) {
                    DiscountCodeDAO discountdao = new DiscountCodeDAO();
                    DiscountCode dis = discountdao.getCode(discountcode);
                    if (dis == null) {
                        request.setAttribute("message", "Code not exits");
                        request.getRequestDispatcher("./CartControl?action=showcart").forward(request, response);
                    }
                    if (dis != null) {
                        if (dis.getStatus() == 1) {
                            request.setAttribute("message", "Code Used by another trade");
                            request.getRequestDispatcher("./CartControl?action=showcart").forward(request, response);
                        } else {
                            dis.setStatus(1);
                            discountdao.updateCode(dis);
                            request.setAttribute("message", "Use disscount " + dis.getPercent() + " percent success");
                            session.setAttribute("discountcode", dis);
                            request.getRequestDispatcher("./CartControl?action=showcart").forward(request, response);
                        }
                    }
                }
            }
            if (action.equalsIgnoreCase("checkout")) {

                Customer cus = (Customer) session.getAttribute("acc");
                if (cus != null) {
                    request.setAttribute("mess", "moi nhap thong tin nguoi nhan");
                    RequestDispatcher dis = request.getRequestDispatcher("CheckOut.jsp");
                    dis.forward(request, response);
                } else {
                    request.setAttribute("mess", "phai dang nhap truoc");
                    RequestDispatcher dis = request.getRequestDispatcher("Login.jsp");
                    dis.forward(request, response);
                }
            }
            if (action.equalsIgnoreCase("checkoutconfim")) {
                String cname = request.getParameter("cname");
                String cphone = request.getParameter("cphone");
                String caddress = request.getParameter("caddress");
                double total = (Double) session.getAttribute("total");
                Customer cus = (Customer) session.getAttribute("acc");
                List<Product> list1 = (List<Product>) session.getAttribute("listP");

                cus.setCname(cname);
                cus.setCphone(cphone);
                cus.setcAddress(caddress);
                DAOBill daobill = new DAOBill();
                int oid = daobill.getLastbillid();
                DiscountCode dis = (DiscountCode) session.getAttribute("disscountcode");
                int discount = 0;

                if (dis != null) {
                    discount = (int) dis.getPercent();
                }

                if (list1 != null) {
                    if (cus != null) {
                        Bill bill = new Bill(0, "", cname, cphone, caddress, total, 1, cus.getId(), discount);
//                        request.setAttribute("mess", bill.toString());
//                        request.getRequestDispatcher("CheckOut.jsp").forward(request, response);
                        daobill.insertBill(bill);
                        DAOBillDetail daobilldt = new DAOBillDetail();
                        for (Product product : list) {
                            Billdetail billdetail = new Billdetail(product.getPid(), oid, product.getQuantity(), product.getPrice(), total, "");
                            daobilldt.insertBilldetail(billdetail);
                            session.removeAttribute("listP");
                            session.removeAttribute("total");
                            session.removeAttribute("disscountcode");
                        }

                        request.setAttribute("mess", "Checkout thanh cong");
                        request.getRequestDispatcher("CheckOut.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mess", "phai dang nhap truoc");
                        request.getRequestDispatcher("Login.jsp").forward(request, response);
                    }
                }
                if (list1 == null) {
                    response.sendRedirect("./HomePage");
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
