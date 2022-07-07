package cn.lotlyz.lampsales.service;

import cn.lotlyz.lampsales.model.User;

import java.util.List;

/**
 * (^_^)
 * 会员
 * @Author: Liyezhi
 * @Date: 2022/6/24 1:56
 */
public interface UserService {

    int insert(User row);

    int insertSelective(User row);

    int deleteByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User row);

    List<User> selectByPrimaryKey(Integer userId);

    List<User> selectAll();
}
