package org.example.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

//获取到db.properties文件中的数据库信息
public class JdbcUtil {
    //私有变量
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    //静态块
            static{
                try{
                       //1.新建属性集对象
                       Properties properties = new Properties();
                       //2通过反射，新建字符输入流，读取db.properties文件
                       InputStream input = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
                       //3.将输入流中读取到的属性，加载到properties属性集对象中
                       properties.load(input);
                       //4.根据键，获取properties中对应的值
                       driver = properties.getProperty("driver");
                       url = properties.getProperty("url");
                       user = properties.getProperty("user");
                       password = properties.getProperty("password");
                       System.out.println("driver:--"+driver);
                    System.out.println("url:--"+url);
                    System.out.println("user:--"+user);
                    System.out.println("password:--"+password);
                   }catch(Exception e){
                       e.printStackTrace();
                   }
    }

    //返回数据库连接
    public static Connection getConnection() {
        try {
            //注册数据库的驱动
            Class.forName("driver");
            System.out.println("驱动");
            //获取数据库连接（里面内容依次是：主机名和端口、用户名、密码）
            Connection connection = DriverManager.getConnection(url, user, password);
            //返回数据库连接
            if (connection!=null){
                System.out.println("连接成功！");
            }else{
                System.out.println("连接失败！");
            }
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

