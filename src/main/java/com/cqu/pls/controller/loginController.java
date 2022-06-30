package com.cqu.pls.controller;

import com.cqu.pls.entity.Authority;
import com.cqu.pls.entity.User;
import com.cqu.pls.service.AuthorityService;
import com.cqu.pls.service.UserService;
import com.cqu.pls.utils.result.DataResult;
import com.cqu.pls.utils.result.code.Code;
import com.cqu.pls.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class loginController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    /**
     * 用户登录
     * @param user
     * @param session
     * @return
     */
    @PostMapping("login")
    public DataResult login(@RequestBody User user, HttpSession session){
        System.out.println("sessionId = " + session.getId());
        //1.查询用户是否存在
        User loginUser = userService.loginUser(user);
        if(null == loginUser){//用户不存在
            return DataResult.errByErrCode(Code.LOGIN_NOT_EXIST);
        }
        //2.封装返回的数据,返回账号, 用户类型
        UserVo userVo = new UserVo();
        userVo.setUserId(Integer.toString(loginUser.getUserId()));
        //获取用户类型
        Authority authority = this.authorityService.queryById(loginUser.getAuthorityId());
        userVo.setAuthorityName(authority.getAuthorityName());
        //获取用户名称
        userVo.setUserName(loginUser.getUserName());
        //3.将用户数据放入session
        session.setAttribute("userInfo", userVo);
        System.out.println(session.getAttribute("userInfo"));
        //4.设置session过期时间
        session.setMaxInactiveInterval(20 * 60);
        return DataResult.successByData(userVo);
    }

    /**
     * 退出登录
     * @return
     */
    @GetMapping("loginOut")
    public DataResult loginOut(HttpSession session){
        session.removeAttribute("userInfo");
        return DataResult.succ();
    }
}
