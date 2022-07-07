package cn.lotlyz.lampsales.controller;

import cn.lotlyz.lampsales.model.Sale;
import cn.lotlyz.lampsales.service.SaleService;
import cn.lotlyz.lampsales.vo.SaleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (^_^)
 * 销售单
 * @Author: Liyezhi
 * @Date: 2022/6/27 20:34
 */
@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    SaleService saleService;

    @RequestMapping("/findOne" )
    public List<Sale> findOne(Integer saleId){
        System.out.println("根据订单id查询订单信息");
        return saleService.selectByPrimaryKey(saleId);
    }

    @RequestMapping("/findAll" )
    public List<Sale> findAll(){
        System.out.println("查询所有订单信息");
        return saleService.selectByAll();
    }

    @RequestMapping("/findAllVo" )
    public List<SaleVo> findAllVo(){
        System.out.println("查询所有VO订单信息");
        return saleService.selectByAllVo();
    }

    @RequestMapping("/insert" )
    public int  insert(Sale row){
        System.out.println("添加一个订单");
        return saleService.insertSelective(row);
    }
    @RequestMapping("/delete" )
    public int  delete(Integer saleId){
        System.out.println("删除一个订单");
        return saleService.deleteByPrimaryKey(saleId);
    }

    @RequestMapping("/update" )
    public int  update(Sale row){
        System.out.println("修改订单信息");
        return saleService.updateByPrimaryKeySelective(row);
    }

}
