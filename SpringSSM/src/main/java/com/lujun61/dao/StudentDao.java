package com.lujun61.dao;

import com.lujun61.entity.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);
    List<Student> selectStudent();
}
