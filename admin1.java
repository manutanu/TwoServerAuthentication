/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arushi
 */
public class admin1 extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String s1=request.getParameter("admin");
        String s2=request.getParameter("pass");
        if(s1.equals("admin")&& s2.equals("password"))
        {
            System.out.println("hi admin1");
            response.sendRedirect("admin2");
        }
        else
        
            out.println("INVALID ADMIN ID  OR  PASSWORD !!!");
             RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
            rd.include(request, response);
           
        }
    }
