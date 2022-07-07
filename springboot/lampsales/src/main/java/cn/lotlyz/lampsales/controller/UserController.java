package cn.lotlyz.lampsales.controller;

import cn.lotlyz.lampsales.model.User;
import cn.lotlyz.lampsales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * (^_^)
 * 会员
 * @Author: Liyezhi
 * @Date: 2022/6/24 2:10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/findOne" )
    public List<User>  findOne(Integer userId){
        System.out.println("根据会员id查询会员信息");
        return userService.selectByPrimaryKey(userId);
    }

    @RequestMapping("/findAll" )
    public List<User>  findAll(){
        System.out.println("查询所有会员信息");
        System.out.println("查到的所有会员数据："+userService.selectAll());
        return userService.selectAll();
    }

    @RequestMapping("/insert" )
    public int  insert(User row){
        System.out.println("添加一个会员");
        return userService.insertSelective(row);
    }

    @RequestMapping("/delete" )
    public int  delete(Integer userId){
        System.out.println("删除一个会员");
        return userService.deleteByPrimaryKey(userId);
    }

    @RequestMapping("/update" )
    public int  update(User row){
        System.out.println("修改会员信息");
        return userService.updateByPrimaryKeySelective(row);
    }
}
