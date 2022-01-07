package com.lujun61.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description 拦截器：看做是多个Controller中公用的功能，集中到拦截器中统一处理。使用的是aop的思想
 * @author Jun Lu
 * @date 2022-01-06 23:27:51
 */
public class MyInterceptor2 implements HandlerInterceptor{
    /**
     * preHandle叫做【预处理方法】
     *     重要！是整个项目的门户！
     *     参数：Object handler--->被拦截的控制器对象
     *     返回值：
     *          true：通过了拦截器的验证，可以继续执行处理器方法
     *          false：未通过了拦截器的验证，不可以继续执行处理器方法
     *     特点：
     *      1、方法在控制器方法之前执行。用户的请求首先到达此方法
     *      2、在这个方法中可以获取请求信息，验证请求是否合法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                            Object handler) throws Exception {
        System.out.println("preHandle方法2执行了！");
        return false;
    }

    /**
     * postHandle叫做【后处理方法】
     *     参数：
     *         Object handler-------------->被拦截的控制器对象
     *         ModelAndView modelAndView--->处理器方法的返回值
     *     特点：
     *      1、方法在控制器方法之后执行
     *      2、在这个方法中可以获取【处理器方法的返回值】，并可以对其进行修正
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle方法2执行了！");
    }

    /**
     * afterCompletion是最后执行的方法。
     *   【当前拦截器中preHandle返回值为true且被执行，其必定执行；为false，且未被执行，其必定不执行】
     *     参数：
     *         Object handler--->被拦截的控制器对象
     *         Exception ex----->程序中发生的异常
     *     特点：
     *      1、方法在【请求】处理完成后执行的。
     *          框架中规定：当视图处理完成后，就认为请求处理完成
     *      2、一般用来做资源的关闭操作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion方法2执行了！");
    }
}
