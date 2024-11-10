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

public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
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
            out.println("    <title>User Information Table</title>");
            out.println("    <style>");
            out.println("        /* Body styling to match registration page */");
            out.println("        body {");
            out.println("            margin: 0;");
            out.println("            font-family: Arial, sans-serif;");
            out.println("            background: linear-gradient(135deg, #4a90e2, #50c9c3);");
            out.println("            display: flex;");
            out.println("            justify-content: center;");
            out.println("            align-items: center;");
            out.println("            height: 100vh;");
            out.println("        }");
            out.println("");
            out.println("        /* Table container styling */");
            out.println("        .table-container {");
            out.println("            width: 90%;");
            out.println("            max-width: 1000px;");
            out.println("            background-color: #ffffff;");
            out.println("            padding: 2rem;");
            out.println("            border-radius: 12px;");
            out.println("            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);");
            out.println("            overflow-x: auto;");
            out.println("            margin-top: 20px;");
            out.println("        }");
            out.println("");
            out.println("        h2 {");
            out.println("            text-align: center;");
            out.println("            color: #333;");
            out.println("            font-size: 1.8rem;");
            out.println("            margin-bottom: 1rem;");
            out.println("        }");
            out.println("");
            out.println("        /* Table styling */");
            out.println("        table {");
            out.println("            width: 100%;");
            out.println("            border-collapse: collapse;");
            out.println("            font-size: 1rem;");
            out.println("            color: #333;");
            out.println("        }");
            out.println("");
            out.println("        th, td {");
            out.println("            padding: 12px 15px;");
            out.println("            text-align: left;");
            out.println("            border-bottom: 1px solid #ddd;");
            out.println("        }");
            out.println("");
            out.println("        th {");
            out.println("            background-color: #4a90e2;");
            out.println("            color: #ffffff;");
            out.println("            font-weight: bold;");
            out.println("            text-align: left;");
            out.println("        }");
            out.println("        tr:nth-child(even) {");
            out.println("            background-color: #f2f2f2;");
            out.println("        }");
            out.println("        tr:hover {");
            out.println("            background-color: #e0e7ff;");
            out.println("        }");
            out.println("        /* Responsive styling */");
            out.println("        @media (max-width: 600px) {");
            out.println("            th, td {");
            out.println("                padding: 10px;");
            out.println("                font-size: 0.9rem;");
            out.println("            }");
            out.println("        }");
            out.println("");
            out.println("        /* Button styling */");
            out.println("        form {");
            out.println("            display: inline-block;");
            out.println("            margin: 10px 10px 0 0;");
            out.println("        }");
            out.println("        input[type='submit'] {");
            out.println("            padding: 10px 20px;");
            out.println("            font-size: 1rem;");
            out.println("            font-weight: bold;");
            out.println("            color: #ffffff;");
            out.println("            background-color: #4a90e2;");
            out.println("            border: none;");
            out.println("            border-radius: 6px;");
            out.println("            cursor: pointer;");
            out.println("            transition: background-color 0.3s ease, transform 0.2s ease;");
            out.println("        }");
            out.println("        input[type='submit']:hover {");
            out.println("            background-color: #005bb5;");
            out.println("            transform: scale(1.05);");
            out.println("        }");
            out.println("        input[type='submit']:active {");
            out.println("            background-color: #003f7f;");
            out.println("            transform: scale(0.98);");
            out.println("        }");
            out.println("    </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("");
            out.println("    <div class='table-container'>");
            out.println("        <h2>User Information</h2>");
            out.println("        <table>");
            out.println("            <thead>");
            out.println("                <tr>");
            out.println("                    <th>ID</th>");
            out.println("                    <th>Username</th>");
            out.println("                    <th>Age</th>");
            out.println("                    <th>Section</th>");
            out.println("                    <th>Roll no</th>");
            out.println("                    <th>Email</th>");
            out.println("                    <th>Password</th>");
            out.println("                    <th>City</th>");
            out.println("                    <th>Phone</th>");
            out.println("                    <th>Sex</th>");
            out.println("                </tr>");
            out.println("            </thead>");
            out.println("            <tbody>");
            out.println("                <tr>");
            out.println("                    <td>" + rs.getInt(1) + "</td>");
            out.println("                    <td>" + rs.getString(2) + "</td>");
            out.println("                    <td>" + rs.getInt(3) + "</td>");
            out.println("                    <td>" + rs.getString(4) + "</td>");
            out.println("                    <td>" + rs.getString(5) + "</td>");
            out.println("                    <td>" + rs.getString(6) + "</td>");
            out.println("                    <td>" + rs.getString(7) + "</td>");
            out.println("                    <td>" + rs.getString(8) + "</td>");
            out.println("                    <td>" + rs.getString(9) + "</td>");
            out.println("                    <td>" + rs.getString(10) + "</td>");
            out.println("                </tr>");
            out.println("            </tbody>");
            out.println("        </table>");
            out.println("<form action='edit' method='get'>");
            out.println("    <input type='submit' value='EDIT'>");
            out.println("</form>");
            out.println("<form action='delete' method='post'>");
            out.println("    <input type='submit' value='DELETE'>");
            out.println("</form>");
            out.println("<form action='logout' method='post'>");
            out.println("    <input type='submit' value='LOGOUT'>");
            out.println("</form>");
            out.println("    </div>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect("login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
