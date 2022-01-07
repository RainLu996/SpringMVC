package com.lujun61.exceptionHandler;

import com.lujun61.exception.AgeException;
import com.lujun61.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 *  ControllerAdvice注解：给控制器增强功能-----异常处理功能
 *      位置：在类的上面
 *      特点：必须让框架知道这个注解所在的包名，需要在注解扫描器中指定包名
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理异常的方法和控制器方法的定义形式一样
     *      不同的有形参：
     *          Exception ex：表示控制器方法中抛出的异常
     */
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception ex) {
        //处理NameException异常
        /**
         * 异常处理逻辑：
         *      1、需要把异常记录下来，记录到数据库、日志文件。
         *      2、发送通知，把异常信息通过邮件、短信发送给相关人员
         *      3、给用户友好的提示
         */
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "用户必须是陆俊！");
        mv.addObject("exception", ex);

        mv.setViewName("nameError");
        return mv;
    }

    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception ex) {
        //处理AgeException异常
        /**
         * 异常处理逻辑：
         *      1、需要把异常记录下来，记录到数据库、日志文件。
         *      2、发送通知，把异常信息通过邮件、短信发送给相关人员
         *      3、给用户友好的提示
         */
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "年龄必须小于80！");
        mv.addObject("exception", ex);

        mv.setViewName("ageError");
        return mv;
    }


    /*可以直接将异常处理方法注解于 Controller 之中*/
    @ExceptionHandler
    public ModelAndView doOtherException(Exception ex) {
        //处理其它类型的异常
        /**
         * 异常处理逻辑：
         *      1、需要把异常记录下来，记录到数据库、日志文件。
         *      2、发送通知，把异常信息通过邮件、短信发送给相关人员
         *      3、给用户友好的提示
         */
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "其它类型的异常！");
        mv.addObject("exception", ex);

        mv.setViewName("defaultError");
        return mv;
    }
}














