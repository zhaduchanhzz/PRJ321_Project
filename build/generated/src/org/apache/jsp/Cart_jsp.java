package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entity.DiscountCode;
import DAO.CustomerDAO;
import java.util.List;
import Entity.Product;

public final class Cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"Css/Cart.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("        <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <!------ Include the above in your HEAD tag ---------->\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div>\n");
      out.write("                <a href=\"HomePage\" class=\"back \" style=\"font-size: 20px\">\n");
      out.write("                    <img src=\"img/png-clipart-clockwise-arrow-rotation-circle-computer-icons-arrow-text-circular-thumbnail.png\" alt=\"\" height=\"15px\"/>\n");
      out.write("                    Back to Home\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <aside class=\"col-lg-9\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div class=\"table-responsive\">\n");
      out.write("                            <table class=\"table table-borderless table-shopping-cart\">\n");
      out.write("                                <thead class=\"text-muted\">\n");
      out.write("                                    <tr class=\"small text-uppercase\">\n");
      out.write("                                        <th scope=\"col\">Product</th>\n");
      out.write("                                        <th scope=\"col\" width=\"120\">Quantity</th>\n");
      out.write("                                        <th scope=\"col\" width=\"120\">Price</th>\n");
      out.write("                                        <th scope=\"col\" width=\"120\">Seller</th>\n");
      out.write("                                        <th scope=\"col\" width=\"120\">Amount</th>\n");
      out.write("                                        <th scope=\"col\" class=\"text-right d-none d-md-block\" width=\"200\"></th>\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                ");

                                    double total = 0;
                                
      out.write("\n");
      out.write("                                <tbody>\n");
      out.write("                                    ");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
      _jspx_th_c_forEach_0.setParent(null);
      _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.listP}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      _jspx_th_c_forEach_0.setVar("o");
      int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
      try {
        int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
        if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\n");
            out.write("                                        ");
 Product item = (Product) pageContext.getAttribute("o");
                                            DAO.CustomerDAO dao = new CustomerDAO();
                                            String seller = dao.getCustomerName(item.getAddbycid());
                                            double amount = (item.getQuantity() * item.getPrice());
                                            total += amount;
                                        
            out.write("\n");
            out.write("                                        <tr>\n");
            out.write("                                            <td>\n");
            out.write("                                                <figure class=\"itemside align-items-center\">\n");
            out.write("                                                    <div class=\"aside\"><img src=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.img}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\" class=\"img-sm\"></div>\n");
            out.write("                                                    <figcaption class=\"info\"> <a href=\"#\" class=\"title text-dark\" data-abc=\"true\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.pname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</a>\n");
            out.write("                                                        <!--<p class=\"small text-muted\">SIZE:M <br> Brand: Cantabil</p>-->\n");
            out.write("                                                    </figcaption>\n");
            out.write("                                                </figure>\n");
            out.write("                                            </td>\n");
            out.write("                                            <td > <button><a href=\"./CartControl?action=decrese&idd=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.pid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">-</a></button>\n");
            out.write("                                                ");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.quantity}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\n");
            out.write("                                                <button><a href=\"./CartControl?action=increse&idd=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.pid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">+</a></button></td>\n");
            out.write("\n");
            out.write("                                            <td>\n");
            out.write("                                                <div class=\"price-wrap\"> <var id=\"price\" class=\"price\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</var> <small class=\"text-muted\"> $VND</small> </div>\n");
            out.write("                                            </td>\n");
            out.write("\n");
            out.write("                                            <td>\n");
            out.write("                                                <div class=\"price-wrap\"> <var class=\"price\">");
            out.print(seller);
            out.write("</var> <small class=\"text-muted\"> </small> </div>\n");
            out.write("                                            </td>\n");
            out.write("                                            <td>\n");
            out.write("                                                <div class=\"price-wrap\"> <var class=\"price\">");
            out.print(amount);
            out.write("</var> <small class=\"text-muted\"> </small> </div>\n");
            out.write("                                            </td>\n");
            out.write("                                            <td class=\"text-right d-none d-md-block\"> <a data-original-title=\"Save to Wishlist\" title=\"\" href=\"\" class=\"btn btn-light\" data-toggle=\"tooltip\" data-abc=\"true\"> <i class=\"fa fa-heart\"></i></a> <a href=\"CartControl?action=remove&pid=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.pid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\" class=\"btn btn-light btn-round\" data-abc=\"true\"> Remove</a> </td>\n");
            out.write("                                        </tr>\n");
            out.write("                                    ");
            int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_forEach_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_forEach_0.doFinally();
        _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
      }
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </aside>\n");
      out.write("                <style>\n");
      out.write("                    input.larger {\n");
      out.write("                        width: 25px;\n");
      out.write("                        height: 25px;\n");
      out.write("                    }\n");
      out.write("                </style>\n");
      out.write("                <aside class=\"col-lg-3\">\n");
      out.write("                    <div class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("\n");
      out.write("                    ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_0.setPageContext(_jspx_page_context);
      _jspx_th_c_if_0.setParent(null);
      _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.discountcode == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
      if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        <div class=\"card\">\n");
          out.write("                            <div class=\"card-body\">\n");
          out.write("                                <form action=\"CartControl?action=discount\"method=\"post\">\n");
          out.write("                                    <dl class=\"dlist-align\">\n");
          out.write("                                        <dt>Have discount code?</dt> &nbsp;&nbsp;\n");
          out.write("                                        <input type=\"checkbox\" class=\"larger\" name=\"chkdiscount\"><br>\n");
          out.write("                                    </dl>\n");
          out.write("                                    <input type=\"text\" name=\"discountcode\"><br>\n");
          out.write("                                    <input type=\"submit\" value=\"Use Discount code\">\n");
          out.write("                                </form>\n");
          out.write("\n");
          out.write("                                <dl class=\"dlist-align\">\n");
          out.write("                                    <dt>Total: ");
          out.print(total);
          out.write("</dt> \n");
          out.write("                                    <dd class=\"text-right text-dark b ml-3\"><strong>VND</strong></dd>\n");
          out.write("                                </dl>\n");
          out.write("                                <hr> <a href=\"#\" class=\"btn btn-out btn-primary btn-square btn-main\" data-abc=\"true\"> Check Out </a>\n");
          out.write("                                <a href=\"HomePage\" class=\"btn btn-out btn-success btn-square btn-main mt-2\" data-abc=\"true\">Continue Shopping</a>\n");
          out.write("                            </div>\n");
          out.write("                        </div>\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      out.write("\n");
      out.write("                    ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_1.setPageContext(_jspx_page_context);
      _jspx_th_c_if_1.setParent(null);
      _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.discountcode != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
      if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        <div class=\"card\">\n");
          out.write("                            <div class=\"card-body\">\n");
          out.write("                                <form action=\"CartControl?action=discount\"method=\"post\">\n");
          out.write("                                    <dl class=\"dlist-align\">\n");
          out.write("                                        <dt>Have discount code?</dt> &nbsp;&nbsp;\n");
          out.write("                                        <input type=\"checkbox\" class=\"larger\" name=\"chkdiscount\" checked=\"\"><br>\n");
          out.write("                                    </dl>\n");
          out.write("                                    <input type=\"text\" name=\"discountcode\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${discountcode.content}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"><br>\n");
          out.write("                                </form>\n");
          out.write("\n");
          out.write("                                <dl class=\"dlist-align\">\n");
          out.write("                                    ");

                                        DiscountCode dis = (DiscountCode) session.getAttribute("discountcode");
                                        if (dis != null) {
                                            total = total - (total * dis.getPercent() / 100);
                                        }
                                    
          out.write("\n");
          out.write("                                    <dt>Total after discount : ");
          out.print(total);
          out.write("</dt> \n");
          out.write("                                    <dd class=\"text-right text-dark b ml-3\"><strong>VND</strong></dd>\n");
          out.write("                                </dl>\n");
          out.write("                                <hr> <a href=\"Cartcontrol?action=checkout\" class=\"btn btn-out btn-primary btn-square btn-main\" data-abc=\"true\"> Check Out </a>\n");
          out.write("                                <a href=\"HomePage\" class=\"btn btn-out btn-success btn-square btn-main mt-2\" data-abc=\"true\">Continue Shopping</a>\n");
          out.write("                            </div>\n");
          out.write("                        </div>\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");

                        session.setAttribute("total", total);
                    
      out.write("\n");
      out.write("                </aside>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
