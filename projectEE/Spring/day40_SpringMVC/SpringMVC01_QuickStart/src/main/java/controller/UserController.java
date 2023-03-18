package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    //设置映射路径为/save,即外部访问路径
    @RequestMapping("/save")
    //设置当前操作返回结果为指定的json数据,本质上是一个字符串
    @ResponseBody
    public String save(){
        System.out.println("User save ...");
        return "{'info':'springmvc'}";
    }
}
