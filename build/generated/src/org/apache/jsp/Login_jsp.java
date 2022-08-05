package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\">\n");
      out.write("        <link href=\"Css/login.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"https://www.google.com/recaptcha/api.js\" async defer></script> \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid mt-3 form-control\" style=\"form{display: block;}\">\n");
      out.write("\n");
      out.write("            <form action=\"LoginController\" method=\"Post\" class=\"d-inline\">\n");
      out.write("                <div class=\"form-group col-sm-3\">\n");
      out.write("                    <label for=\"myUserName\">UserName</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control \"\n");
      out.write("                           id=\"myUserName\" placeholder=\"UserName\" name=\"user\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group col-sm-3\" >\n");
      out.write("                    <label for=\"myPassword\">Password</label>\n");
      out.write("                    <input type=\"password\" class=\"form-control\"\n");
      out.write("                           id=\"myPassword\" placeholder=\"Password\" name=\"password\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("                <div class=\"g-recaptcha\" data-sitekey=\"6LfzKBwdAAAAADPH1sh8A41d1QR0dyVTNtskva9h\"\n");
      out.write("                     data-theme =\"dark\" data-size =\"normal\"\n");
      out.write("                     ></div>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary\">Sign in</button>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <form action=\"Register.jsp\" method=\"Post\" class=\"d-inline\">\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary\">Register</button>\n");
      out.write("            </form>\n");
      out.write("            <div>\n");
      out.write("                <a href=\"forget.jsp\" class=\"back\">/>\n");
      out.write("                    Forgot password?</a>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <a href=\"HomePage\" class=\"back\"><img src=\"img/png-clipart-clockwise-arrow-rotation-circle-computer-icons-arrow-text-circular-thumbnail.png\" alt=\"\" height=\"12px\"/>\n");
      out.write("                    Back to Home</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
