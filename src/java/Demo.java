/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mahboob
 */
public class Demo implements Filter {

    public void init(FilterConfig f) {

    }

    public void destroy() {

    }

    public void doFilter(ServletRequest rq, ServletResponse rs, FilterChain f) {
        try {

            PrintWriter pw = rs.getWriter();
            HttpServletRequest request = (HttpServletRequest) rq;
            HttpSession hs = request.getSession(true);
            if (hs.getAttribute("user") == null) {
                pw.println("<script>alert('login first');</script>");
            } else {
                pw.println("<script>alert('filter is running');</script>");
                f.doFilter(rq, rs);
            }
        } catch (Exception e) {

        }
    }
}
