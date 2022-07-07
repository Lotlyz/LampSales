package cn.lotlyz.lampsales.dao;

import cn.lotlyz.lampsales.model.Sale;
import cn.lotlyz.lampsales.vo.SaleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SaleDao {

    /**
     * 添加
     * @param row
     * @return
     */
    int insert(Sale row);

    /**
     * 按需添加
     * @param row
     * @return
     */
    int insertSelective(Sale row);

    /**
     * 删除
     * @param saleId
     * @return
     */
    int deleteByPrimaryKey(Integer saleId);

    /**
     * 按需修改
     * @param row
     * @return
     */
    int updateByPrimaryKeySelective(Sale row);

    /**
     * 修改
     * @param row
     * @return
     */
    int updateByPrimaryKey(Sale row);

    /**
     * 根据id查询
     * @param saleId
     * @return
     */
    List<Sale> selectByPrimaryKey(Integer saleId);

    /**
     * 查询所有
     * @return
     */
    List<Sale> selectByAll();

    /**
     * 多表联合查询销售单信息
     * @return
     */
    List<SaleVo> selectByAllVo();

}