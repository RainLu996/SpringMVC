package com.lujun61.service;

import com.lujun61.entity.Student;

import java.util.List;

public interface StudentService {
    int insertStudent(Student student);
    List<Student> selectStudent();
}
