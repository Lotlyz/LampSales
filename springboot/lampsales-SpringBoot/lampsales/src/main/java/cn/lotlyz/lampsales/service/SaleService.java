package cn.lotlyz.lampsales.service;

import cn.lotlyz.lampsales.model.Sale;
import cn.lotlyz.lampsales.vo.SaleVo;

import java.util.List;

/**
 * (^_^)
 * 销售单
 * @Author: Liyezhi
 * @Date: 2022/6/25 18:53
 */

public interface SaleService {


    int insert(Sale row);

    int insertSelective(Sale row);

    int deleteByPrimaryKey(Integer saleId);

    int updateByPrimaryKeySelective(Sale row);

    int updateByPrimaryKey(Sale row);

    List<Sale> selectByPrimaryKey(Integer saleId);

    List<Sale> selectByAll();

    List<SaleVo> selectByAllVo();
}
