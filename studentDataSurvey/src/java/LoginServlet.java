
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.Scanner;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String uname = request.getParameter("name");
        String pass = request.getParameter("password");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/seci?autoReconnect=true&useSSL=false", "root", "0057");
            PreparedStatement ps = con.prepareStatement("select pass from studentData where uname=?");
            ps.setString(1,uname);
            ResultSet rs=ps.executeQuery();
            rs.next();
            String realPass=rs.getString(1);
            if(pass.equals(realPass)){
               HttpSession session=request.getSession(); 
               session.setAttribute("uname",uname); 
               response.sendRedirect("view");
            }
            else{
                response.sendRedirect("login.html");
            }
            
        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect("login.html");
        }
    }

}
