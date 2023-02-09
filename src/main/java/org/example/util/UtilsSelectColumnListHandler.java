package org.example.util;

import org.apache.commons.dbutils.QueryRunner;
 import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.example.entity.Nation;

import java.sql.Connection;
 import java.sql.SQLException;
 import java.util.List;

/**
 * 询数据（ColumnListHandler会返回结果中指定的列）
 */
public class UtilsSelectColumnListHandler {
     public static void main(String[] args) throws SQLException {
         //创建dbUtils里面的QueryRunner对象
         QueryRunner queryRunner = new QueryRunner();
         //sql语句
         String sql = "select * from nation where N_ID>?";
         //获取数据库连接
         Connection connection = JdbcUtil2.getConnection();
         //存参数值的数组
         Object[] params = {1};
         //执行查询，并以数组的形式返回查询结果（new ColumnListHandler<>()返回结果中指定的列）
         List<Nation> strs = queryRunner.query(connection,sql, new ColumnListHandler<Nation>("N_NAME"),params);
         //List<Object> strs = queryRunner.query(connection,sql, new ColumnListHandler<>("name"),params);
         System.out.println(strs);
         for(Object item:strs){
                 System.out.println(item);
             }
         //关闭数据库连接
         connection.close();
     }
 }