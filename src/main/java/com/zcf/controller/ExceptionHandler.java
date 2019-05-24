package com.zcf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.zcf.utils.MyException;

/**
 * @author chenkang
 * 
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			if (ex instanceof MyException) {
				outScript(writer, ex);
			} else {
				outScript(writer, ex);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != writer) {
				writer.flush();
				writer.close();
			}
		}
		return null;
	}

	private void outScript(PrintWriter writer, Exception ex) {
		writer.println("<script>");
		writer.println("history.back();");
		writer.println(String.format("top.layer.msg('%s');", ex.getMessage()));
		writer.println("</script>");
	}
}
