import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/seci?autoReconnect=true&useSSL=false", "root", "0057");
            PreparedStatement ps = con.prepareStatement("delete from studentData where uname=?");
            HttpSession session = request.getSession(false);
            String uname = (String) session.getAttribute("uname");
            ps.setString(1,uname);
            ps.executeUpdate();
            response.sendRedirect("login.html");
        } catch (Exception e) {
            out.println(e);
        }

    }
}
