/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arushi
 */
public class register extends HttpServlet {

    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      String s1=request.getParameter("login_id");
        String s2=request.getParameter("email_id");
        String s3=request.getParameter("account_number");
        String s4=request.getParameter("name");
        String s5=request.getParameter("address");
        String s6=request.getParameter("phone");
      
        
        try
        {
           System.out.println("hi....................");
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           
            Connection con=DriverManager.getConnection("jdbc:odbc:dsnarushi","sa","niit");
            
            Statement stat=con.createStatement();
            
            stat.executeUpdate("insert into register1 values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')");
           
            
        }
        catch(Exception e)
        {
            
        }
    }
}