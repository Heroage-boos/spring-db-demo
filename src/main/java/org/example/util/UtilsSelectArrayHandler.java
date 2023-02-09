package org.example.util;
import org.apache.commons.dbutils.QueryRunner;
 import org.apache.commons.dbutils.handlers.ArrayHandler;


        import java.sql.Connection;
 import java.sql.SQLException;
 import java.util.Arrays;

       public class UtilsSelectArrayHandler {
     public static void main(String[] args) throws SQLException {
              //创建dbUtils里面的QueryRunner对象
              QueryRunner queryRunner = new QueryRunner();
              //sql语句
              String sql = "select * from nation where N_ID>?";
              //获取数据库连接
              Connection connection = JdbcUtil2.getConnection();
              //存参数值的数组
              Object[] params = {1};
              //执行查询，并以数组的形式返回查询结果（new ArrayHandler()只会返回第一条记录）
              Object[] objects = queryRunner.query(connection,sql, new ArrayHandler(),params);
              System.out.println(Arrays.toString(objects));
              System.out.println("\n");
              //关闭数据库连接
              connection.close();
          }
 }