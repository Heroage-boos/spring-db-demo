package org.example.util;

import org.apache.commons.dbutils.QueryRunner;


import java.sql.Connection;
 import java.sql.SQLException;

/**
 * 删除数据库内数据
 */
public class DbutilsDelete {
     public static void main(String[] args) throws SQLException {
          //创建dbUtils里面的QueryRunner对象
           QueryRunner queryRunner = new QueryRunner();
           //sql语句
           String sql = "delete from nation where N_ID=?";
           //存参数值的数组
           Object[] objects = {19};
           //获取数据库连接
           Connection connection = JdbcUtil2.getConnection();
           //执行sql语句，并返回影响的行数
           int i = queryRunner.update(connection,sql,objects);
           System.out.println(i);
           //关闭数据库连接
           connection.close();
       }
 }