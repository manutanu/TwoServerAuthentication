/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import aa.customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arushi
 */
public class admin2 extends HttpServlet {
    int count;
    List l=new ArrayList();
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           System.out.println("hi admin2");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection con=DriverManager.getConnection("jdbc:odbc:dsnarushi","sa","niit");
           Statement stat=con.createStatement();
           ResultSet rs=stat.executeQuery("select * from register1");
           
           
           while(rs.next())
               {
                        
                     System.out.println("aa.................................");   
                        customer c=new customer(rs.getString("Login_id"),rs.getString("Email"),rs.getString("Account_No"),rs.getString("Name"),rs.getString("Address"),rs.getString("Phone"));
                        l.add(c);
                        System.out.println("hi" +l);
                      
                       
               } 
             request.setAttribute("list", l);
            RequestDispatcher rd=request.getRequestDispatcher("admin_info.jsp");
                        rd.forward(request, response);
                       
           System.out.println("hi.............................");
           System.out.println(l);
          
           
        } 
     catch(Exception e)
     {
         System.out.println("bye..............");
     }
    }
}