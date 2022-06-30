package com.cqu.pls.aspect;

import com.cqu.pls.utils.VerifyUtil;
import com.cqu.pls.utils.result.DataResult;
import com.cqu.pls.utils.result.code.Code;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Aspect
@Component
public class AroundCut {
    public static final String POINT_CUT =
            "execution(* com.cqu.pls.controller.AddressinfoController.*(..)) || " +
            "execution(* com.cqu.pls.controller.AdvertisementinfoController.*(..)) || " +
            "execution(* com.cqu.pls.controller.AuthorityController.*(..)) || " +
            "execution(* com.cqu.pls.controller.BuildinfoController.*(..)) || "+
            "execution(* com.cqu.pls.controller.CarchangeController.*(..)) || " +
            "execution(* com.cqu.pls.controller.CarinfoController.*(..)) || " +
            "execution(* com.cqu.pls.controller.CertificateinfoController.*(..)) || " +
            "execution(* com.cqu.pls.controller.CommunicationinfoController.*(..)) || " +
            "execution(* com.cqu.pls.controller.CompanyinfoController.*(..)) || " +
            "execution(* com.cqu.pls.controller.EmployeeinfoController.*(..)) || " +
            "execution(* com.cqu.pls.controller.FixinfoController.*(..)) || " +
            "execution(* com.cqu.pls.controller.MachineinfoController.*(..)) || " +
            "execution(* com.cqu.pls.controller.MaterialtypeController.*(..)) || " +
            "execution(* com.cqu.pls.controller.MatetialinfoController.*(..)) || " +
            "execution(* com.cqu.pls.controller.MerchandiseinfoController.*(..)) || " +
            "execution(* com.cqu.pls.controller.PurchasesaleController.*(..)) || " +
            "execution(* com.cqu.pls.controller.TransportationinfoController.*(..)) || " +
            "execution(* com.cqu.pls.controller.UserController.*(..))" ;

    /**
     * 判断用户的登录是否有效
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(AroundCut.POINT_CUT)
    public DataResult checkSession(ProceedingJoinPoint pjp) throws Throwable {
        //获取session
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        //判断用户登录是否有效
        System.out.println(session.getAttributeNames());
        if(VerifyUtil.isNull(session.getAttribute("userInfo"))){
            //返回登录失效
            return DataResult.errByErrCode(Code.LOGIN_OUT);
        }
        return (DataResult) pjp.proceed();
    }
}
