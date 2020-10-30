package Controller;

import Login.Database;
import Userdata.Userdata;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");

        String username = request.getParameter("userName");
        String password = request.getParameter("userPwd");

        PrintWriter printWriter = response.getWriter();

        try {
            Database database = new Database("sa", "qwert");
            Userdata userdata = database.check(username, password);
            database.close();
            if ( userdata == null ) {
                printWriter.write("用户不存在或密码错误");
            }
            else {
                printWriter.write("欢迎你, " + userdata.getUserName() + "!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            printWriter.write("登陆失败");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
