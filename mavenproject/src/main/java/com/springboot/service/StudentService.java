package com.springboot.service;

import com.springboot.dao.StudentDao;
import com.springboot.entity.Student;
import java.util.Collection;


public class StudentService {
    private StudentDao studentDao;
public Collection<Student> returnAllStudents(){
	return studentDao.returnAllStudents();
    }
}
