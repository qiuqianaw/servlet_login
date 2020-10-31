# JavaWeb_Login_QiuQian

*未更新完成*

## 环境

- SQL Server数据库连接
- HTML, Java, Servlet, SQL Server, Tomcat
- JDK14, Tomcat9.0.37

## Database

数据库中包含以下数据：

| useername | password |
| --------- | -------- |
| admin     | admin    |
| qiuqian   | qiuqian  |

- 在构造方法中完成SQL数据库连接
- testConnection();//连接测试
- getUser();//从数据库获取用户数据
- check();//前端传入数据和数据库数据做比对

## LoginServlet

1. 从前端获取username及password
2. 与数据库数据做比对
   - 数据匹配：PrintWriter 欢迎你 + 用户名
   - 数据不匹配： 用户名或密码错误/登陆失败

## 使用许可

[MIT](LICENSE) ©

待更新