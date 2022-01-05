package com.lujun61.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

@RequestMapping(value = "/lujun61")
public class MyController {
    @RequestMapping(value = "/some.do", method = RequestMethod.GET)
    public ModelAndView doSome() {
        //处理some.do请求的控制器方法
        ModelAndView mv = new ModelAndView();

         /*添加数据：框架将数据放入到request作用域对象中*/
        //request.setAttribute(key, value);
        mv.addObject("msg", "在框架中访问静态资源");
        mv.addObject("fun", "doSome方法执行了！");

         /* 配置视图解析器后的写法：逻辑名称 */
        mv.setViewName("result");

        return mv;
    }
}












