package com.lujun61.service;

import com.lujun61.dao.StudentDao;
import com.lujun61.entity.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> selectStudent() {
        return studentDao.selectStudent();
    }
}
