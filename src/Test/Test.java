package Test;

import Login.Database;
import Userdata.Userdata;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //传参数的时候使用自己的数据库账户名(sa)密码
        Database database = new Database("sa", "qwert");
        //测试是否连接成功
        database.testConnect();
        //从数据库取出数据测试
//        Userdata userdata1 = database.getUser("admin");
//        System.out.println(userdata1);
    }
}
