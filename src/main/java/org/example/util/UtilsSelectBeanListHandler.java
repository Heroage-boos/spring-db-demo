package org.example.util;
import org.apache.commons.dbutils.QueryRunner;
 import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.example.entity.Nation;


import java.sql.Connection;
 import java.sql.SQLException;
 import java.util.List;

/**
 * 查询数据，并将查询数据转成实际对象（BeanListHandler会返回查询到的所有记录）
 */
public class UtilsSelectBeanListHandler {
     public static void main(String[] args) throws SQLException {
              //创建dbUtils里面的QueryRunner对象
              QueryRunner queryRunner = new QueryRunner();
              //sql语句
              String sql = "select * from nation where N_ID>?";
              //获取数据库连接
              Connection connection = JdbcUtil2.getConnection();
              //存参数值的数组
              Object[] params = {1};
              //执行查询，并以数组的形式返回查询结果（new BeanListHandler()返回查询到的所有记录，并转成对象）
              List<Nation> nations = queryRunner.query(connection,sql, new BeanListHandler<Nation>(Nation.class),params);
              System.out.println(nations);
              //关闭数据库连接
              connection.close();
          }
 }