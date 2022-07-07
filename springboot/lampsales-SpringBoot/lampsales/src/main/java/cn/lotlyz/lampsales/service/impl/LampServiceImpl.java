package cn.lotlyz.lampsales.service.impl;

import cn.lotlyz.lampsales.dao.LampDao;
import cn.lotlyz.lampsales.model.Lamp;
import cn.lotlyz.lampsales.service.LampSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (^_^)
 * 灯具服务实现类
 * @Author: Liyezhi
 * @Date: 2022/6/25 18:52
 */
@Service
public class LampServiceImpl implements LampSevice {

    @Autowired
    LampDao lampDao;

    @Override
    public int insertSelective(Lamp row) {
        return lampDao.insertSelective(row);
    }

    @Override
    public int deleteByPrimaryKey(Integer lampId) {
        return lampDao.deleteByPrimaryKey(lampId);
    }

    @Override
    public int updateByPrimaryKeySelective(Lamp row) {
        return lampDao.updateByPrimaryKeySelective(row);
    }

    @Override
    public List<Lamp> selectByPrimaryKey(Integer lampId) {
        return lampDao.selectByPrimaryKey(lampId);
    }

    @Override
    public List<Lamp> selectAll() {
        return lampDao.selectAll();
    }
}
