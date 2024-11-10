
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String uname = request.getParameter("username");
        String pass = request.getParameter("password");
        String age = request.getParameter("age");
        String section = request.getParameter("section");
        String rollNo = request.getParameter("rollNo");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String city = request.getParameter("city");
        String sex = request.getParameter("sex");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/seci?autoReconnect=true&useSSL=false", "root", "0057");
            PreparedStatement ps = con.prepareStatement("insert into studentData values(0,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, uname);
            ps.setInt(2, Integer.parseInt(age));
            ps.setString(3, section);
            ps.setString(4, rollNo);
            ps.setString(5, email);
            ps.setString(6, pass);
            ps.setString(7, city);
            ps.setString(8, phone);
            ps.setString(9, sex);
            ps.executeUpdate();
            response.sendRedirect("login.html");

        } catch (Exception e) {
            System.out.println(e);
            out.println(e);
            response.sendRedirect("register.html");
        }
    }
}
