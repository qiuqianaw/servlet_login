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

        //从前端获取username和password
        String username = request.getParameter("userName");
        String password = request.getParameter("userPwd");

        //声明输出流
        PrintWriter printWriter = response.getWriter();

        try {
            //连接数据库 -> 前端数据和数据库数据做比对 -> 关闭数据库连接
            //成功or失败进行相应操作，输出流
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
