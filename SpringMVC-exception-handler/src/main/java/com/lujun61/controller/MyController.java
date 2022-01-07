package com.lujun61.controller;

import com.lujun61.exception.AgeException;
import com.lujun61.exception.MyUserException;
import com.lujun61.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

@RequestMapping(value = "/lujun61")
public class MyController {
    @RequestMapping(value = "/some.do", method = RequestMethod.GET)
    public ModelAndView doSome(String name, Integer age) throws MyUserException {
        ModelAndView mv = new ModelAndView();

        //根据请求抛出异常
        if (!"lujun".equals(name)) {
            throw new NameException("非法入侵！");
        }

        if (age == null || age > 80) {
            throw new AgeException("老头子！");
        }

        mv.addObject("msg", "异常集中处理案例");
        mv.addObject("fun", "doSome方法执行了！");

        mv.setViewName("result");

        return mv;
    }



    /* 可以直接将异常处理方法注解于 Controller 之中；但是一般将异常处理方法专门定义在一个类中，作为全局的异常处理类 */
    /*@ExceptionHandler
    public ModelAndView doOtherException(Exception ex) {
        //处理其它类型的异常
        *//**
         * 异常处理逻辑：
         *      1、需要把异常记录下来，记录到数据库、日志文件。
         *      2、发送通知，把异常信息通过邮件、短信发送给相关人员
         *      3、给用户友好的提示
         *//*
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "其它类型的异常！");
        mv.addObject("exception", ex);

        mv.setViewName("defaultError");
        return mv;
    }*/
}












