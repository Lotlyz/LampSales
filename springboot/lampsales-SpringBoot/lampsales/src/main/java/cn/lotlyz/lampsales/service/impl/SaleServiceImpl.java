package cn.lotlyz.lampsales.service.impl;

import cn.lotlyz.lampsales.dao.SaleDao;
import cn.lotlyz.lampsales.model.Sale;
import cn.lotlyz.lampsales.service.SaleService;
import cn.lotlyz.lampsales.vo.SaleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (^_^)
 * 销售单
 * @Author: Liyezhi
 * @Date: 2022/6/25 18:54
 */
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleDao saleDao;

    @Override
    public List<Sale> selectByPrimaryKey(Integer saleId) {
        return saleDao.selectByPrimaryKey(saleId);
    }

    @Override
    public List<Sale> selectByAll() {
        return saleDao.selectByAll();
    }

    @Override
    public List<SaleVo> selectByAllVo() {
        return saleDao.selectByAllVo();
    }

    @Override
    public int insert(Sale row) {
        return saleDao.insert(row);
    }

    @Override
    public int insertSelective(Sale row) {
        return saleDao.insertSelective(row);
    }

    @Override
    public int deleteByPrimaryKey(Integer saleId) {
        return saleDao.deleteByPrimaryKey(saleId);
    }

    @Override
    public int updateByPrimaryKeySelective(Sale row) {
        return saleDao.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(Sale row) {
        return saleDao.updateByPrimaryKey(row);
    }
}
