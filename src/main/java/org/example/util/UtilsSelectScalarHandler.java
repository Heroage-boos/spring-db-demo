package org.example.util;

import org.apache.commons.dbutils.QueryRunner;
 import org.apache.commons.dbutils.handlers.ScalarHandler;

 import java.sql.Connection;
 import java.sql.SQLException;

/**
 * 查询单数据
 */
public class UtilsSelectScalarHandler {
     public static void main(String[] args) throws SQLException {
               //创建dbUtils里面的QueryRunner对象
               QueryRunner queryRunner = new QueryRunner();
               //sql语句
               String sql = "select min(N_ID) from nation";
               //获取数据库连接
               Connection connection = JdbcUtil2.getConnection();
               //存参数值的数组
               Object[] params = {};
               //执行查询，并以数组的形式返回查询结果（new ScalarHandler<>()返回分组函数的值）
               int id= (int) queryRunner.query(connection,sql, new ScalarHandler<>(),params);
               // int age = queryRunner.query(connection,sql, new ScalarHandler<>(),params);
               System.out.println(id);
               //关闭数据库连接
               connection.close();
           }
 }