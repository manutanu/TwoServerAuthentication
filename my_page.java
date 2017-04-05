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
public class my_page extends HttpServlet {

    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String s1=request.getParameter("acc_no");
        String s2=request.getParameter("new_pass");
        
         System.out.println("to.................."+s1);
        System.out.println("to.................."+s2);  
         try
        {
           
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           
            Connection con=DriverManager.getConnection("jdbc:odbc:dsnarushi","sa","niit");
            
            Statement stat=con.createStatement();
            
            stat.executeUpdate("UPDATE sent_mail SET password='"+s2+"' where account_no='"+s1+"'");
        }
        catch(Exception e)
        {
            
        }
        
        
    }
}
