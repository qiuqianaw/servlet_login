package Test;

import Login.Database;
import Userdata.Userdata;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Database database = new Database("sa", "qwert");
        database.testConnect();
        Userdata userdata1 = database.getUser("admin");
        System.out.println(userdata1);
    }
}
