/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-07-10 07:50:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class settings_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");

	String path = request.getContextPath();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\" />\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\r\n");
      out.write("<title>设置</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(path);
      out.write("/statics/css/style.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"href=\"");
      out.print(path);
      out.write("/statics/css/bootstrap/css/bootstrap.min.css\" />\r\n");
      out.write("<script src=\"");
      out.print(path);
      out.write("/statics/js/jquery-1.9.1.min.js\"type=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("<script src=\"");
      out.print(path);
      out.write("/statics/css/bootstrap/js/bootstrap.js\"type=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("<style>\r\n");
      out.write(".avatar {\r\n");
      out.write("\twidth: 60px;\r\n");
      out.write("\theight: 60px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".settings ul:nth-child(1) li {\r\n");
      out.write("\tmargin-top: 8px;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tline-height: initial;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".settings ul li {\r\n");
      out.write("\tline-height: 48px;\r\n");
      out.write("\tpadding: 0 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".userInfo {\r\n");
      out.write("\tline-height: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".exit {\r\n");
      out.write("\twidth: 70%;\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\tbackground-color: #ff5555;\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("\tpadding: 8px 0;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tborder-radius: 20px;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\tmargin-bottom: 10px;\r\n");
      out.write("\toutline: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"header\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-xs-4\" onclick=\"location='/mall/catrs/mineself'\">\r\n");
      out.write("\t\t\t\t<span class=\"glyphicon glyphicon-menu-left\" aria-hidden=\"true\"></span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-xs-4 title\">设置</div>\r\n");
      out.write("\t\t\t<div class=\"col-xs-4\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"content settings\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-3\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"avatar\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"");
      out.print(path);
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.avatar}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-7 userInfo\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-xs-12\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-xs-12\">\r\n");
      out.write("\t\t\t\t\t\t\t\tID:<span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userinfo.uid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-2\" style=\"line-height: 60px;\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<div class=\"row\" onclick=\"location='safe'\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-10\">账户与安全</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-2\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"glyphicon glyphicon-menu-right\" aria-hidden=\"true\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<div class=\"row\" onclick=\"location='address'\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-10\">我的收货地址</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-2\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"glyphicon glyphicon-menu-right\" aria-hidden=\"true\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"footer\">\r\n");
      out.write("\t\t<button type=\"button\" class=\"exit\" onclick=\"signout()\">退出当前账户</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction signout() {\r\n");
      out.write("\t\t$.post(\"signout\", function() {\r\n");
      out.write("\t\t\twindow.location.href = \"/mall/index\"\r\n");
      out.write("\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
