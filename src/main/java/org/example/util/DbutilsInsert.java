package org.example.util;

import org.apache.commons.dbutils.QueryRunner;
import org.example.util.JdbcUtil2;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接数据库的第三种方式：新建数据库配置文件，获取配置文件信息后，再通过DButils工具包连接数据库
 * 参考地址:https://blog.csdn.net/qq_38570633/article/details/109264186
 */
public class DbutilsInsert {
     public static void main(String[] args) throws SQLException {
            //创建dbUtils里面的QueryRunner对象
             QueryRunner queryRunner = new QueryRunner();
             //sql语句
             String sql = "insert into nation(N_ID,N_NAME) values(?,?)";
             //存参数值的数组
             Object[] objects = {15,"小红"};
             //获取数据库连接
             Connection connection = JdbcUtil2.getConnection();
             //执行sql语句，并返回影响的行数
             int i = queryRunner.update(connection,sql,objects);
             System.out.println(i);
             //关闭数据库连接
             connection.close();
         }
 }