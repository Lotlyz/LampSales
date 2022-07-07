package cn.lotlyz.lampsales.dao;

import cn.lotlyz.lampsales.model.Lamp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LampDao {

    /**
     * 添加
     * @param row
     * @return
     */
    int insert(Lamp row);

    /**
     * 按需添加
     * @param row
     * @return
     */
    int insertSelective(Lamp row);

    /**
     * 删除
     * @param lampId
     * @return
     */
    int deleteByPrimaryKey(Integer lampId);

    /**
     * 按需修改
     * @param row
     * @return
     */
    int updateByPrimaryKeySelective(Lamp row);

    /**
     * 修改
     * @param row
     * @return
     */
    int updateByPrimaryKey(Lamp row);

    /**
     * 根据id查询
     * @param lampId
     * @return
     */
    List<Lamp> selectByPrimaryKey(Integer lampId);


    /**
     * 查询所有
     * @return
     */
    List<Lamp> selectAll();


}