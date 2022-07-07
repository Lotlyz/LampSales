package cn.lotlyz.lampsales.dao;

import cn.lotlyz.lampsales.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (^_^)
 * 会员Dao
 * @Author: Liyezhi
 * @Date: 2022/6/24 1:42
 */

@Mapper
public interface UserDao {

    /**
     * 添加
     * @param row
     * @return
     */
    int insert(User row);

    /**
     * 按需添加
     * @param row
     * @return
     */
    int insertSelective(User row);

    /**
     * 删除
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 按需修改
     * @param row
     * @return
     */
    int updateByPrimaryKeySelective(User row);

    /**
     * 修改
     * @param row
     * @return
     */
    int updateByPrimaryKey(User row);

    /**
     * 根据id查询
     * @param userId
     * @return
     */
    List<User> selectByPrimaryKey(Integer userId);

    /**
     * 查询所有
     * @return
     */
    List<User> selectAll();


}