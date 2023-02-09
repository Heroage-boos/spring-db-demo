package org.example.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.example.entity.Nation;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 查询数据，并将查询数据转成实际对象（BeanHandler只会返回第一条记录）
 */
public class UtilsSelectBeanHandler {
    public static void main(String[] args) throws SQLException {
        //创建dbUtils里面的QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        //sql语句
        String sql = "select * from nation where N_ID>?";
        //获取数据库连接
        Connection connection = JdbcUtil2.getConnection();
        //存参数值的数组
        Object [] params = {1};
        //执行查询，并以数组的形式返回查询结果（new BeanHandler()只会返回第一条记录，并转成对象）
        Nation nation = queryRunner.query(connection,sql, new BeanHandler<Nation>(Nation.class),params);
        System.out.println("nation"+nation);
        System.out.println("\n");
        //关闭数据库连接
        connection.close();
    }
}