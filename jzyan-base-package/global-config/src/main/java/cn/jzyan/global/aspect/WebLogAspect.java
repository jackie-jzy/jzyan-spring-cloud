package cn.jzyan.global.aspect;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @ProjectName : global-config
 * @FileName : WebLogAspect
 * @Version : 1.0.0
 * @Package : cn.jzyan.global.aspect
 * @Description : 统一日志处理
 * @Author : jzyan
 * @CreateDate : 2019/12/05 10:22
 */
@Slf4j
@Aspect
@Component
public class WebLogAspect {
    /**
     * controller 层出入参日志记录
     *
     * @param joinPoint 切点
     * @return
     */
    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        /**
         * 获取 request 中包含的请求参数
         */
        String uuid = UUID.randomUUID().toString();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        /**
         * 获取切点请求参数(class,method)
         */
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //获取浏览器信息
        String ua = request.getHeader("User-Agent");
        //转成UserAgent对象
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);
        //获取浏览器信息
        Browser browser = userAgent.getBrowser();
        //获取系统信息
        OperatingSystem os = userAgent.getOperatingSystem();
        //系统名称
        String system = os.getName();
        //浏览器名称
        String browserName = browser.getName();

        Object result = joinPoint.proceed();
        /**
         * 入参日志
         */
        log.info("\n\t[LOG-START]\n\tRequestMark: {}\n\tRequestIP: {}\n\tSystem: {}\n\tBrowserName: {}\n\tContentType:{}\n\tRequestUrl: {}\n\t" +
                        "RequestMethod: {}\n\tRequestParams: {}\n\tTargetClassAndMethod: {}#{}\n\tResponseParams: {}\n\t[LOG-END]", uuid, request.getRemoteAddr(), system, browserName,
                request.getHeader("Content-Type"), request.getRequestURL(), request.getMethod(), new Gson().toJson(joinPoint.getArgs()),
                method.getDeclaringClass().getName(), method.getName(), new Gson().toJson(result));
        return result;

    }
}
