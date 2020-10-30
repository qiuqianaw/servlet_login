package Userdata;

public class Userdata {
    private String userName;
    private String passWord;

    public Userdata(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
