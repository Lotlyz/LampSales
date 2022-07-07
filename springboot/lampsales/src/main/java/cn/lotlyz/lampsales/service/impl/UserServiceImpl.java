package cn.lotlyz.lampsales.service.impl;

import cn.lotlyz.lampsales.dao.UserDao;
import cn.lotlyz.lampsales.model.User;
import cn.lotlyz.lampsales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (^_^)
 * 会员服务实现类
 * @Author: Liyezhi
 * @Date: 2022/6/24 1:57
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public int insert(User row) {
        return userDao.insert(row);
    }

    @Override
    public int insertSelective(User row) {
        return userDao.insertSelective(row);
    }

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return userDao.deleteByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(User row) {
        return userDao.updateByPrimaryKeySelective(row);
    }

    @Override
    public List<User> selectByPrimaryKey(Integer userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }
}
