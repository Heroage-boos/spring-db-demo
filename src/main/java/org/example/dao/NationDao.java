package org.example.dao;

import org.example.entity.Nation;

import java.util.List;

public interface NationDao {
    //添加方法
    void add(Nation nation);
    //修改方法
    void updateNation(Nation nation);

    //删除方法
    void deleteNation(Integer id);

    //查询全部
    List<Nation> findAllNation();

    //查询国家名（根据id）
    Nation findNationInfo(String id);
}
