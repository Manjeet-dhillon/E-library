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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mahboob
 */
public class adminloginfilter implements Filter {

    public void init(FilterConfig f) {

    }

    public void destroy() {

    }

    public void doFilter(ServletRequest rq, ServletResponse rs, FilterChain f) {
        try {
            PrintWriter pw = rs.getWriter();

            if (rq.getParameter("password").length() >= 8) {
                f.doFilter(rq, rs);
            } else {
                pw.println("<script>alert('Password not valid');</script>");
                RequestDispatcher rd = rq.getRequestDispatcher("//index.html");
                rd.include(rq, rs);
            }
        } catch (Exception e) {

        }
    }
}
