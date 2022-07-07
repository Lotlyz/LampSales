package cn.lotlyz.lampsales.service;

import cn.lotlyz.lampsales.model.Lamp;

import java.util.List;

/**
 * (^_^)
 * 灯具
 * @Author: Liyezhi
 * @Date: 2022/6/25 18:52
 */
public interface LampSevice {

    int insertSelective(Lamp row);

    int deleteByPrimaryKey(Integer lampId);

    int updateByPrimaryKeySelective(Lamp row);

    List<Lamp> selectByPrimaryKey(Integer lampId);

    List<Lamp> selectAll();

}
