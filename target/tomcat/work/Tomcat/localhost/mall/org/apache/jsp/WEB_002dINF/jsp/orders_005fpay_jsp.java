/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-07-10 07:26:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.mall.pojo.OrderGoods;
import com.mall.pojo.Userorder;
import java.util.List;

public final class orders_005fpay_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String path = request.getContextPath();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\" />\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\r\n");
      out.write("<title>待付款</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.print(path);
      out.write("/statics/css/bootstrap/css/bootstrap.min.css\" />\r\n");
      out.write("<script src=\"");
      out.print(path);
      out.write("/statics/js/jquery-1.9.1.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("<script src=\"");
      out.print(path);
      out.write("/statics/css/bootstrap/js/bootstrap.js\"\r\n");
      out.write("\ttype=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(path);
      out.write("/statics/css/style.css\" />\r\n");
      out.write("<style>\r\n");
      out.write(".orders .list:nth-child(1) {\r\n");
      out.write("\tmargin-top: 5px;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .list li>div {\r\n");
      out.write("\tpadding: 8px;\r\n");
      out.write("\tborder-bottom: 1px solid #E8E8E8;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .title {\r\n");
      out.write("\ttext-align: right;\r\n");
      out.write("\tcolor: #FF5555;\r\n");
      out.write("\tfont-size: 13px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .list li .main {\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .list li .info {\r\n");
      out.write("\ttext-align: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .list li .orders_footer {\r\n");
      out.write("\ttext-align: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .list li .orders_footer .pay, .orders .list li .orders_footer .log_info\r\n");
      out.write("\t{\r\n");
      out.write("\tpadding: 2px 15px;\r\n");
      out.write("\tbackground-color: white;\r\n");
      out.write("\tborder-radius: 15px;\r\n");
      out.write("\toutline: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .list li .orders_footer .pay {\r\n");
      out.write("\tborder: 1px solid #ff5555;\r\n");
      out.write("\tcolor: #ff5555;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .list li .orders_footer .log_info {\r\n");
      out.write("\tborder: 1px solid #777777;\r\n");
      out.write("\tcolor: #777777;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .list li>.main>div:nth-child(1) {\r\n");
      out.write("\tflex: 1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .list li>.main>div:nth-child(1)>div {\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\twidth: 100px;\r\n");
      out.write("\theight: 100px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .list li>.main>div:nth-child(1) img {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: 50%;\r\n");
      out.write("\tleft: 50%;\r\n");
      out.write("\ttransform: translate(-50%, -50%);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .list li>.main>div:nth-child(2) {\r\n");
      out.write("\tflex: 3;\r\n");
      out.write("\tpadding-left: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .list li>.main>div:nth-child(2)>div {\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .list li>.main>div:nth-child(2)>div>div:nth-child(1) {\r\n");
      out.write("\tflex: 4;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .price {\r\n");
      out.write("\tflex: 1;\r\n");
      out.write("\ttext-align: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .oldPrice {\r\n");
      out.write("\tcolor: #969696;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .goodsName {\r\n");
      out.write("\tfont-size: 15px;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\ttext-overflow: ellipsis;\r\n");
      out.write("\tdisplay: -webkit-box;\r\n");
      out.write("\t-webkit-box-orient: vertical;\r\n");
      out.write("\t-webkit-line-clamp: 3;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .param {\r\n");
      out.write("\tcolor: #969696;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tmargin-top: 5px;\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .param>div:nth-child(1) {\r\n");
      out.write("\tflex: 4;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".orders .param>div:nth-child(2) {\r\n");
      out.write("\tflex: 1;\r\n");
      out.write("\ttext-align: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".bar li {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\twidth: 20%;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tbackground-color: white;\r\n");
      out.write("\tpadding: 10px 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".bar .active {\r\n");
      out.write("\tcolor: #FF5555;\r\n");
      out.write("\tborder-bottom: 2px solid #FF5555;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction goevaluate() {\r\n");
      out.write("\t\twindow.location.href = \"selectOrderByStatus0\";\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"header\">\r\n");
      out.write("\t\t<div class=\"row\" onclick=\"location='mineself'\">\r\n");
      out.write("\t\t\t<div class=\"col-xs-4\">\r\n");
      out.write("\t\t\t\t<span class=\"glyphicon glyphicon-menu-left\" aria-hidden=\"true\"></span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-xs-4 title\">代付款订单</div>\r\n");
      out.write("\t\t\t<div class=\"col-xs-4\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<ul class=\"bar\">\r\n");
      out.write("\t\t<li onclick=\"location='selectAllOrder'\">全部</li>\r\n");
      out.write("\t\t<li onclick=\"location='selectOrderByStatus0'\" class=\"active\">待付款</li>\r\n");
      out.write("\t\t<li onclick=\"location='selectOrderByStatus1'\">代发货</li>\r\n");
      out.write("\t\t<li onclick=\"location='selectOrderByStatus2'\">待收货</li>\r\n");
      out.write("\t\t<li onclick=\"location='selectOrderByStatus3'\">待评价</li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<div class=\"content orders\">\r\n");
      out.write("\t\t\t<ul class=\"list\">\r\n");
      out.write("\t\t\t\t");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/jsp/orders_pay.jsp(176,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/orders_pay.jsp(176,4) '${UserOrder}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${UserOrder}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/jsp/orders_pay.jsp(176,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("userOrder");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\t<li>\r\n");
            out.write("\t\t\t\t\t\t<div class=\"title\">未付款</div> \t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t\t");
            if (_jspx_meth_c_005fset_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
              return;
            out.write("\r\n");
            out.write("\t\t\t\t\t\t");
            //  c:forEach
            org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
            _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
            _jspx_th_c_005fforEach_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
            // /WEB-INF/jsp/orders_pay.jsp(180,6) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
            _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/orders_pay.jsp(180,6) '${orderGoods}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${orderGoods}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
            // /WEB-INF/jsp/orders_pay.jsp(180,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005fforEach_005f1.setVar("goods");
            int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
            try {
              int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
              if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t <div class=\"main\">\r\n");
                  out.write("\t\t\t\t\t\t\t\t<div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t<div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\t<img src=\"");
                  out.print(path);
                  out.write('/');
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.image}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
                  out.write("\" />\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t</div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t<div>\r\n");
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t<div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"goodsName\">");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
                  out.write("</div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"price\">\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\t\t<div>￥");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
                  out.write("</div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\t\t<del class=\"oldPrice\">￥");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
                  out.write("</del>\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t<div class=\"param\">\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\t<div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\t\t<span>颜色:<span>");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.colour}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
                  out.write("</span></span>&nbsp;&nbsp; <span>规格:<span>左");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.specification}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
                  out.write("</span></span>\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\t<div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\t\tx<span>");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.num}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
                  out.write("</span>\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t</div>\r\n");
                  out.write("\t\t\t\t\t\t\t</div>\r\n");
                  out.write("\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (java.lang.Throwable _jspx_exception) {
              while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
            } finally {
              _jspx_th_c_005fforEach_005f1.doFinally();
              _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
            }
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t\t<div class=\"info\">\r\n");
            out.write("\t\t\t\t\t\t\t共<span>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${orderGoods.size()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</span>件商品&nbsp;&nbsp;合计:￥<span>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userOrder.payment}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</span>\r\n");
            out.write("\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t\t<div class=\"orders_footer\">\r\n");
            out.write("\t\t\t\t\t\t\t<button type=\"button\" class=\"pay\">去付款</button>\r\n");
            out.write("\t\t\t\t\t\t</div>\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t</li>\r\n");
            out.write("\t\t\t\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
        _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      }
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/jsp/orders_pay.jsp(179,6) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/orders_pay.jsp(179,6) '${userOrder.orderGoods}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${userOrder.orderGoods}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/jsp/orders_pay.jsp(179,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("orderGoods");
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}
