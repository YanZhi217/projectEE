package com.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.reggie.common.R;
import com.reggie.entity.User;
import com.reggie.service.UserService;
import com.reggie.utils.SMSUtils;
import com.reggie.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 发送手机验证码短信
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session) {
        //获取手机号
        String phone = user.getPhone();
        if(StringUtils.isNotEmpty(phone)){
            //生成随机四位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            //调用阿里云提供的短信服务API发送短信 签名, 模板, 手机号, 动态验证码
            log.info("code = {}", code);    //未申请到签名,所以使用发送到浏览器控制台模拟向手机发送短信
            //SMSUtils.sendMessage("瑞吉外卖", "", phone, code);
            //将生成的验证码保存到Session
            session.setAttribute(phone, code);
            return  R.success("手机验证码发送成功");
        }
        return R.error("手机短信发送失败");
    }

    /**
     * 移动端用户登录
     * @param map
     * @return
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session) {
        //使用map接收前端数据,两个数据phone,code 也可以使用DTO方式
        log.info(map.toString());
        //获取手机号
        String phone = map.get("phone").toString();
        //获取验证码
        String code = map.get("code").toString();
        //从session中获取保存的验证码
        Object codeInSession = session.getAttribute(phone);
        //进行验证码比对,页面提交验证码与session保存的验证码
        if(codeInSession != null && codeInSession.equals(code)){
            //比对成功,登陆成功
            //判断当前用户是否为新用户
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone, phone);
            User user = userService.getOne(queryWrapper);
            if(user == null){
                //如果是新用户则自动注册
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            session.setAttribute("user", user.getId());
            return  R.success(user);
        }

        return R.error("登录失败");
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @PostMapping("/loginout")
    public R<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return R.success("退出成功");
    }
    // http://localhost:8080/front/page/login.html
}
