package com.lujun61.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

@RequestMapping(value = "/lujun61")
public class MyController {
    @RequestMapping(value = "/some.do", method = RequestMethod.GET)
    public ModelAndView doSome(String name, Integer age){
        System.out.println("doSome方法执行了！");
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg", "拦截器案例");
        mv.addObject("fun", "doSome方法执行了！");

        mv.setViewName("result");

        return mv;
    }
}












