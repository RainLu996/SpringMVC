package com.lujun61.controller;

import com.lujun61.entity.Student;
import com.lujun61.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService service;

    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student) {
        ModelAndView mv = new ModelAndView();
        String tips = "注册失败！";

        int nums = service.insertStudent(student);
        if (nums > 0) {
            //注册成功
            tips = "学生【" + student.getName() + "】注册成功！";
        }
        //添加数据
        mv.addObject("tips", tips);

        //制定结果页面
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> addStudent() {
        return service.selectStudent();
    }
}















