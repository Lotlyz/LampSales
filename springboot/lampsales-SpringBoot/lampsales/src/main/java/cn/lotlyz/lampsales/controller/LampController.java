package cn.lotlyz.lampsales.controller;

import cn.lotlyz.lampsales.model.Lamp;
import cn.lotlyz.lampsales.service.LampSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (^_^)
 * 灯具
 * @Author: Liyezhi
 * @Date: 2022/6/26 23:18
 */

@RestController
@RequestMapping("/lamp")
public class LampController {


    @Autowired
    LampSevice lampSevice;

    @RequestMapping("/findOne" )
    public List<Lamp> findOne(Integer lampId){
        System.out.println("根据灯具id查询灯具信息");
        return lampSevice.selectByPrimaryKey(lampId);
    }

    @RequestMapping("/findAll" )
    public List<Lamp> findAll(){
        System.out.println("查询所有灯具信息");
        return lampSevice.selectAll();
    }

    @RequestMapping("/insert" )
    public int  insert(Lamp row){
        System.out.println("添加一个灯具");
        return lampSevice.insertSelective(row);
    }
    @RequestMapping("/delete" )
    public int  delete(Integer lampId){
        System.out.println("删除一个灯具");
        return lampSevice.deleteByPrimaryKey(lampId);
    }

    @RequestMapping("/update" )
    public int  update(Lamp row){
        System.out.println("修改灯具信息");
        return lampSevice.updateByPrimaryKeySelective(row);
    }
}
