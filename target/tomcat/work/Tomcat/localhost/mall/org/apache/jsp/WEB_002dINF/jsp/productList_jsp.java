/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-07-10 06:04:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.mall.pojo.Activitys;
import com.mall.pojo.Goods;
import java.util.List;

public final class productList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin.release();
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\"/>\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\r\n");
      out.write("    <meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black-translucent\" />\r\n");
      out.write("    <meta name=\"format-detection\" content=\"telephone=no\" />\r\n");
      out.write("    <meta name=\"msapplication-tap-highlight\" content=\"no\" />\r\n");
      out.write("    <title>商品列表</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path);
      out.write("/statics/css/bootstrap/css/bootstrap.min.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path);
      out.write("/statics/css/productList.css\"/>\r\n");
      out.write("\r\n");
      out.write("   <script src=\"");
      out.print(path);
      out.write("/statics/js/jquery-1.9.1.min.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(path);
      out.write("/statics/css/bootstrap/js/bootstrap.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function salesCom(check){\r\n");
      out.write("\t$.post(\"searchSort\",{check:check},function(data){\r\n");
      out.write("\t\tfor(var i = 0 ; i <data.length ; i++){\r\n");
      out.write("\t\t\t$('#sal').remove();\r\n");
      out.write("\t\t\tvar html = '<div class=\"col-xs-6 produc\" id=\"sal\">';\r\n");
      out.write("\t\t\thtml += '<img src=\"'+data[i].images[0]+'\" class=\"img-responsive img-rounded\" onclick=\"showComInfo('+data[i].gid+')\">';\r\n");
      out.write("\t\t\thtml += '<span style=\"font-size: 10px;\">'+data[i].title+'</span>';\r\n");
      out.write("\t\t\thtml += '<div class=\"ripao\">'+'日抛三售'+'</div>';\r\n");
      out.write("\t\t\thtml += '<div class=\"huiyuanjia\">现价：￥'+data[i].price+'</div>';\r\n");
      out.write("\t\t\thtml += '<span style=\"color:#b0b0b0\">'+data[i].number+'人付款</span>';\r\n");
      out.write("\t\t\thtml += '</div>';\r\n");
      out.write("\t\t\t$('#salesComs').append(html);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"white_content\" id=\"light\">\r\n");
      out.write("    <div class=\"container-fluid zuiwai\">\r\n");
      out.write("        <form action=\"\" method=\"post\">\r\n");
      out.write("            <div class=\"col-xs-12 hezi\">\r\n");
      out.write("                <div class=\"Ptitle\">品牌：</div>\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-xs-12 hezi\">\r\n");
      out.write("                <div class=\"Ptitle\">佩戴时间：</div>\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-xs-12 hezi\">\r\n");
      out.write("                <div class=\"Ptitle\">直径：</div>\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fforEach_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-xs-12 hezi\">\r\n");
      out.write("                <div class=\"Ptitle\">价格区间(元)：</div>\r\n");
      out.write("                <div class=\"col-xs-4\">\r\n");
      out.write("                    <input type=\"text\" placeholder=\"最低价\" class=\"inputPrice\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-xs-3\">\r\n");
      out.write("                    ——\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-xs-4\">\r\n");
      out.write("                    <input type=\"text\" placeholder=\"最高价\" class=\"inputPrice\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-xs-12 hezi\">\r\n");
      out.write("                <div class=\"Ptitle\">颜色：</div>\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fforEach_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-xs-12 hezi\">\r\n");
      out.write("                <div class=\"Ptitle\">类别：</div>\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fforEach_005f4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-xs-12 anniu\">\r\n");
      out.write("                <input type=\"reset\" value=\"重置\" class=\"chongzhi\">\r\n");
      out.write("                <input type=\"submit\" value=\"确定\" class=\"queding\" id=\"submit\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"fade\" class=\"black_overlay\" onclick=\"yincang()\"></div>\r\n");
      out.write("<div class=\"container-fluid navbar-fixed-top\" style=\"padding-right: 0;padding-left: 0;\">\r\n");
      out.write("    <div class=\"col-xs-12 yanjing\">\r\n");
      out.write("        <div class=\"col-xs-2\" style=\"padding-right: 0;\">\r\n");
      out.write("            <a href=\"index\" id=\"Fhui\" style=\"text-align: left;\">\r\n");
      out.write("                <img src=\"");
      out.print(path);
      out.write("/statics/imageSelf/fanhui.png\" width=\"19%\"/>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"col-xs-12 biaotilan\">\r\n");
      out.write("        <span class=\"col-xs-3\">\r\n");
      out.write("            销量<img src=\"");
      out.print(path);
      out.write("/statics/imageSelf/jiagehei.png\" width=\"12%\" onclick=\"salesCom(1)\">\r\n");
      out.write("                <img src=\"");
      out.print(path);
      out.write("/statics/imageSelf/jiagehui.png\" width=\"12%\" onclick=\"salesCom(2)\">\r\n");
      out.write("        </span>\r\n");
      out.write("        <span class=\"col-xs-3\">\r\n");
      out.write("            价格<img src=\"");
      out.print(path);
      out.write("/statics/imageSelf/jiagehei.png\" width=\"12%\" onclick=\"salesCom(3)\">\r\n");
      out.write("                <img src=\"");
      out.print(path);
      out.write("/statics/imageSelf/jiagehui.png\" width=\"12%\" onclick=\"salesCom(4)\">\r\n");
      out.write("        </span>\r\n");
      out.write("        <span class=\"col-xs-3\">\r\n");
      out.write("            新品<img src=\"");
      out.print(path);
      out.write("/statics/imageSelf/jiagehei.png\" width=\"12%\" onclick=\"salesCom(5)\">\r\n");
      out.write("               <img src=\"");
      out.print(path);
      out.write("/statics/imageSelf/jiagehui.png\" width=\"12%\" onclick=\"salesCom(6)\">\r\n");
      out.write("        </span>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"container-fluid\" style=\"margin-top: 80px;\" id=\"salesComs\">\r\n");
      out.write("    \t");

    		List<Goods> selectHotComInfo =(List) request.getSession().getAttribute("selectComInfo");
    			for(int i = 0 ; i < selectHotComInfo.size() ; i++){
    				Goods goods = selectHotComInfo.get(i);
    				pageContext.setAttribute("goods",goods);
    	
      out.write("\r\n");
      out.write("    \t   <div class=\"col-xs-6 produc\" id=\"sal\">\r\n");
      out.write("\t            <img src=\"");
      out.print(path);
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.images[0]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"img-responsive img-rounded\" onclick=\"showComInfo('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.gid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\">\r\n");
      out.write("\t            <span style=\"font-size: 10px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t            <div class=\"ripao\">日抛三售</div>\r\n");
      out.write("\t            <!-- <div class=\"huiyuanjia\">会员价：￥40.9</div> -->\r\n");
      out.write("\t            <div>\r\n");
      out.write("\t                <span style=\"color: #ff5555\">￥");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t                <span style=\"color:#b0b0b0\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.number}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("人付款</span>\r\n");
      out.write("\t            </div>\r\n");
      out.write("     \t   </div>\r\n");
      out.write("    \t");

    			}
    	
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("    .xuanzhong{\r\n");
      out.write("        background-color:red;\r\n");
      out.write("        color:white;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    function shaixuan() {\r\n");
      out.write("        document.getElementById('light').style.display='block';\r\n");
      out.write("        document.getElementById('fade').style.display='block';\r\n");
      out.write("    }\r\n");
      out.write("    function yincang() {\r\n");
      out.write("        document.getElementById('light').style.display='none';\r\n");
      out.write("        document.getElementById('fade').style.display='none';\r\n");
      out.write("    }\r\n");
      out.write("    $(function(){\r\n");
      out.write("        var  information = \"\";\r\n");
      out.write("        $(\".xuan\").click(function(){\r\n");
      out.write("        \t$(\".xuan\").removeClass(\"xuanzhong\");\r\n");
      out.write("            $(this).toggleClass(\"xuanzhong\");\r\n");
      out.write("        });\r\n");
      out.write("        $(\"#submit\").click(function(){\r\n");
      out.write("           var xuanList = $(\".xuan\");\r\n");
      out.write("           for(var xuan in xuanList ){\r\n");
      out.write("               if($(xuan).hasClass('xuanzhong')){\r\n");
      out.write("                   var message = $(this).text();\r\n");
      out.write("                   information += message;\r\n");
      out.write("               }\r\n");
      out.write("           }\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("    function showComInfo(gid){\r\n");
      out.write("    \twindow.location.href=\"productDetails/\"+gid;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/jsp/productList.jsp(51,16) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setBegin(1);
    // /WEB-INF/jsp/productList.jsp(51,16) name = end type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setEnd(4);
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                    <div class=\"col-xs-4 pinpai xuan\">\r\n");
          out.write("                        品牌品牌\r\n");
          out.write("                    </div>\r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /WEB-INF/jsp/productList.jsp(59,16) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setBegin(1);
    // /WEB-INF/jsp/productList.jsp(59,16) name = end type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setEnd(4);
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                    <div class=\"col-xs-3 peidai xuan\">\r\n");
          out.write("                        半年抛\r\n");
          out.write("                    </div>\r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f2.setParent(null);
    // /WEB-INF/jsp/productList.jsp(67,16) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setBegin(1);
    // /WEB-INF/jsp/productList.jsp(67,16) name = end type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setEnd(3);
    int[] _jspx_push_body_count_c_005fforEach_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f2 = _jspx_th_c_005fforEach_005f2.doStartTag();
      if (_jspx_eval_c_005fforEach_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                    <div class=\"col-xs-4 zhijing xuan\">\r\n");
          out.write("                        14.0以下\r\n");
          out.write("                    </div>\r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f2.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin.reuse(_jspx_th_c_005fforEach_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f3.setParent(null);
    // /WEB-INF/jsp/productList.jsp(87,16) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f3.setBegin(1);
    // /WEB-INF/jsp/productList.jsp(87,16) name = end type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f3.setEnd(6);
    int[] _jspx_push_body_count_c_005fforEach_005f3 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f3 = _jspx_th_c_005fforEach_005f3.doStartTag();
      if (_jspx_eval_c_005fforEach_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                    <div class=\"col-xs-2 yanse xuan\">\r\n");
          out.write("                        黑\r\n");
          out.write("                    </div>\r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f3.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin.reuse(_jspx_th_c_005fforEach_005f3);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f4 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f4.setParent(null);
    // /WEB-INF/jsp/productList.jsp(95,16) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setBegin(1);
    // /WEB-INF/jsp/productList.jsp(95,16) name = end type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setEnd(3);
    int[] _jspx_push_body_count_c_005fforEach_005f4 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f4 = _jspx_th_c_005fforEach_005f4.doStartTag();
      if (_jspx_eval_c_005fforEach_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                    <div class=\"col-xs-4 leibie xuan\">\r\n");
          out.write("                        彩色隐形\r\n");
          out.write("                    </div>\r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f4.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fend_005fbegin.reuse(_jspx_th_c_005fforEach_005f4);
    }
    return false;
  }
}
