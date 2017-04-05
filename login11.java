/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import aa.RSA;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arushi
 */
public class login11 extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String s1=request.getParameter("acc_no");
        String s2=request.getParameter("password");
        
        try
        {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection con=DriverManager.getConnection("jdbc:odbc:dsnarushi","sa","niit");
           Statement stat=con.createStatement();
           ResultSet rs=stat.executeQuery("select * from sent_mail ");
           
           
           while(rs.next())
               {
                        
                  String s11=(String) rs.getString("account_no");
              
                  String s33=(String) rs.getString("email");
                          String s22=(String) rs.getString("password");
                       if(s1.equals(s11) && s2.equals(s22))
                         
                       {
                            out.println("YOU HAVE LOGIN SUCCESSFULLY entered otp!!... ");
                           ServletContext con1=request.getServletContext();
                           con1.setAttribute("acc_no",s1 );
                           con1.setAttribute("pass",s2 );
                           con1.setAttribute("email",s33 );
                            RSA rsa = new RSA();
                           
                      //      RequestDispatcher rd=request.getRequestDispatcher("RSA");
                        //    rd.include(request, response);
                       }
               } 
             
           
        } 
     catch(Exception e)
     {
          out.println("INVALID ACCOUNT NO.  OR  PASSWORD !!");
         System.out.println("bye..............");
     }
        
        
        
    }
}
