
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

public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/seci?autoReconnect=true&useSSL=false", "root", "0057");
            PreparedStatement ps = con.prepareStatement("select * from studentData where uname=?");
            HttpSession session = request.getSession(false);
            String uname = (String) session.getAttribute("uname");
            ps.setString(1, uname);
            ResultSet rs = ps.executeQuery();
            rs.next();
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("    <meta charset='UTF-8'>");
            out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("    <title>Stylish Registration Form</title>");
            out.println("    <style>");
            out.println("        /* Body styling */");
            out.println("        body {");
            out.println("            margin: 0;");
            out.println("            font-family: Arial, sans-serif;");
            out.println("            background: linear-gradient(135deg, #4a90e2, #50c9c3);");
            out.println("            height: 100vh;");
            out.println("            display: flex;");
            out.println("            justify-content: center;");
            out.println("            align-items: center;");
            out.println("        }");
            out.println("");
            out.println("        /* Form container styling */");
            out.println("        .register-container {");
            out.println("            background-color: #ffffff;");
            out.println("            width: 350px;");
            out.println("            padding: 2rem;");
            out.println("            border-radius: 12px;");
            out.println("            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);");
            out.println("            text-align: center;");
            out.println("            animation: fadeIn 1s ease-in-out;");
            out.println("        }");
            out.println("");
            out.println("        /* Heading */");
            out.println("        .register-container h2 {");
            out.println("            color: #333;");
            out.println("            font-size: 2rem;");
            out.println("            margin-bottom: 1rem;");
            out.println("        }");
            out.println("");
            out.println("        /* Input field styling */");
            out.println("        .register-container input[type='text'],");
            out.println("        .register-container input[type='email'],");
            out.println("        .register-container input[type='password'] {");
            out.println("            width: 100%;");
            out.println("            padding: 0.8rem;");
            out.println("            margin: 0.8rem 0;");
            out.println("            border: none;");
            out.println("            border-radius: 8px;");
            out.println("            background-color: #f1f1f1;");
            out.println("            font-size: 1rem;");
            out.println("            transition: background-color 0.3s ease;");
            out.println("        }");
            out.println("");
            out.println("        .register-container input[type='text']:focus,");
            out.println("        .register-container input[type='email']:focus,");
            out.println("        .register-container input[type='password']:focus {");
            out.println("            background-color: #e0e7ff;");
            out.println("            outline: none;");
            out.println("            box-shadow: 0 0 8px rgba(72, 144, 226, 0.5);");
            out.println("        }");
            out.println("");
            out.println("        /* Submit button styling */");
            out.println("        .register-container input[type='submit'] {");
            out.println("            width: 100%;");
            out.println("            padding: 0.8rem;");
            out.println("            margin-top: 1.2rem;");
            out.println("            border: none;");
            out.println("            border-radius: 8px;");
            out.println("            background: linear-gradient(135deg, #4a90e2, #50c9c3);");
            out.println("            color: white;");
            out.println("            font-size: 1.2rem;");
            out.println("            font-weight: bold;");
            out.println("            cursor: pointer;");
            out.println("            transition: background-color 0.3s ease, transform 0.2s ease;");
            out.println("        }");
            out.println("");
            out.println("        .register-container input[type='submit']:hover {");
            out.println("            background: linear-gradient(135deg, #50c9c3, #4a90e2);");
            out.println("            transform: scale(1.05);");
            out.println("        }");
            out.println("");
            out.println("        /* Additional text link styling */");
            out.println("        .register-container .login-link {");
            out.println("            display: block;");
            out.println("            margin-top: 1.5rem;");
            out.println("            color: #333;");
            out.println("            font-size: 0.9rem;");
            out.println("        }");
            out.println("");
            out.println("        .register-container .login-link a {");
            out.println("            color: #4a90e2;");
            out.println("            text-decoration: none;");
            out.println("            font-weight: bold;");
            out.println("        }");
            out.println("");
            out.println("        .register-container .login-link a:hover {");
            out.println("            text-decoration: underline;");
            out.println("        }");
            out.println("");
            out.println("        /* Animation for the container */");
            out.println("        @keyframes fadeIn {");
            out.println("            from {");
            out.println("                opacity: 0;");
            out.println("                transform: translateY(-20px);");
            out.println("            }");
            out.println("            to {");
            out.println("                opacity: 1;");
            out.println("                transform: translateY(0);");
            out.println("            }");
            out.println("        }");
            out.println("    </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <div class='register-container'>");
            out.println("        <h2>Edit</h2>");
            out.println("        <form action='edit' method='post'>");
            out.println("            <input type='text' name='age' placeholder='age' value=" + rs.getInt(3) + " required>");
            out.println("            <input type='text' name='section' placeholder='section' value=" + rs.getString(4) + " required>");
            out.println("            <input type='text' name='rollNo' placeholder='rollNo' value=" + rs.getString(5) + " required>");
            out.println("            <input type='text' name='email' placeholder='email' value=" + rs.getString(6) + " required>            ");
            out.println("            <input type='password' name='password' placeholder='password' value=" + rs.getString(7) + " required>");
            out.println("            <input type='text' name='city' placeholder='city' value=" + rs.getString(8) + " required>");
            out.println("            <input type='text' name='phone' placeholder='phone' value=" + rs.getString(9) + " required>");
            out.println("            <input type='text' name='sex' placeholder='sex' value=" + rs.getString(10) + " required>");
            out.println("            ");
            out.println("            <input type='submit' value='Save'>");
            out.println("        </form>");
            out.println("    </div>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        String uname = (String) session.getAttribute("uname");
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
            PreparedStatement ps = con.prepareStatement("update studentData set age=?,section=?,rollNo=?,email=?,pass=?,city=?,phone=?,sex=? where uname=?");
            ps.setInt(1, Integer.parseInt(age));
            ps.setString(2, section);
            ps.setString(3, rollNo);
            ps.setString(4, email);
            ps.setString(5, pass);
            ps.setString(6, city);
            ps.setString(7, phone);
            ps.setString(8, sex);
            ps.setString(9, uname);
            ps.executeUpdate();
            response.sendRedirect("view");

        } catch (Exception e) {
            out.println(e);
            response.sendRedirect("edit");
        }
    }

}
