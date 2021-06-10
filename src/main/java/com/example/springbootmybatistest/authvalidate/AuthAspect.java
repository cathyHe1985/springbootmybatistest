package com.example.springbootmybatistest.authvalidate;

import com.alibaba.fastjson.JSON;
import com.example.springbootmybatistest.dao.ReturnInfo;
import com.example.springbootmybatistest.dao.UserInfo;
import com.example.springbootmybatistest.mapper.RoleInfoMapper;
import com.example.springbootmybatistest.mapper.UserInfoMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.coyote.Request;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class AuthAspect {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Pointcut(value = "@annotation(com.example.springbootmybatistest.authvalidate.Auth)")
    public void annotationPointCut() {
    }

    @Around("annotationPointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取访问的目标方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //目标方法
        Method targetMethod = signature.getMethod();
        System.out.println("方法名：" + targetMethod.getName());

        if (targetMethod.isAnnotationPresent(Auth.class)) {
            //获取方法上的注解
            Auth auAnnotation= targetMethod.getAnnotation(Auth.class);
            String strAnnoValue= auAnnotation.value();

            //获取ajax头部信息
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            HttpServletRequest request = sra.getRequest();
            String strAuth= request.getHeader("Authorization");

            //获取传入的参数信息
            Object[] objArgs= joinPoint.getArgs();

            //用户验证
            String[] strAuthInfo=strAuth.split("&");
            String strUser=strAuthInfo[0];
            String strPassword=strAuthInfo[1];
            UserInfo userInfo=userInfoMapper.queryUserByNamePassword(strUser,strPassword);

            if(userInfo!=null)
            {
                return joinPoint.proceed();
            }
            else
            {
                ReturnInfo ri=new ReturnInfo();
                ri.setIsSuccess("0");
                ri.setErrorMsg("用户越权");
                ri.setInfo("[{'username':'123'},{'username':'567'}]");
                String strResult=JSON.toJSONString(ri);
                throw new RuntimeException(strResult);
            }
        } else {
            return joinPoint.proceed();
        }
    }

}
