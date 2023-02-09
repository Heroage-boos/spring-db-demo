package org.example.util;

import org.example.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

 public class LinkMysql {
     public static void main(String[] args) throws ClassNotFoundException, SQLException {
               //获取数据库连接
                Connection connection = JdbcUtil.getConnection();
                //需要执行的sql语句
                String sql = "insert into nation(N_ID,N_NAME) values(?,?)";
                //获取预处理对象，并给参数赋值
                PreparedStatement statement = connection.prepareCall(sql);
                statement.setInt(1,14);
                statement.setString(2,"frnend");
                //执行sql语句（插入了几条记录，就返回几）
                int i = statement.executeUpdate();  //executeUpdate：执行并更新
                System.out.println(i);
                //关闭jdbc连接
                statement.close();
                connection.close();
            }
}