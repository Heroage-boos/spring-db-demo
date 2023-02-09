package org.example.dao.impl;

import org.example.dao.NationDao;
import org.example.entity.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class NationDaoImpl implements NationDao {
    //注入jdbcTemplate
    private JdbcTemplate jdbcTemplate;

    public void add(Nation nation) {
        //创建sql语句
        String sql="insert into nation (N_ID,N_NAME) values (?,?,?)";
        //调用方法实行
        int update=jdbcTemplate.update(sql,nation.getN_ID(),nation.getN_Name());
        //返回成功1
        System.out.println(update);
    }
    public void updateNation(Nation nation) {
        String sql = "UPDATE   nation.N_Name SET  N_Name = ? WHERE n_id = ?";
        Object[] args = {nation.getN_ID(),nation.getN_Name()};
        int updat = jdbcTemplate.update(sql,args);
//        System.out.println('修改'+updat);
    }

    public void deleteNation(Integer id) {
        String sql ="DELETE FROM user_db.t_user WHERE user_id = ?";
        int updat = jdbcTemplate.update(sql,id);
        System.out.println(updat);
    }

    public List<Nation> findAllNation() {
        String sql = "select * from t_user";
        List<Nation> nationList =jdbcTemplate.query(sql,new BeanPropertyRowMapper<Nation>(Nation.class));
        return nationList;

    }

    public Nation findNationInfo(String id) {
        return null;
    }
}

