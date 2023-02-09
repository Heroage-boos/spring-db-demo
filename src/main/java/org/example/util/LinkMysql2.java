package org.example.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 连接数据库第二种方式——新建数据库配置文件，获取配置文件信息后，再注册数据库驱动
 * 参考文档：https://blog.csdn.net/qq_38570633/article/details/109264186
 */
public class LinkMysql2 {
     public static void main(String[] args) throws ClassNotFoundException, SQLException {
               //获取数据库连接
             Connection connection = JdbcUtil2.getConnection();
             //需要执行的sql语句
             String sql = "insert into nation(N_ID,N_NAME) values(?,?)";
             //获取预处理对象，并给参数赋值
             PreparedStatement statement = connection.prepareCall(sql);
             //重複插入會保爆红
             statement.setInt(1,21);
             statement.setString(2,"Friend");
             //执行sql语句（执行了几条记录，就返回几）
             int i = statement.executeUpdate();  //executeUpdate：执行并更新
             System.out.println(i);
             //关闭jdbc连接
             JdbcUtil2.closeResource(null,statement,connection);
         }
 }