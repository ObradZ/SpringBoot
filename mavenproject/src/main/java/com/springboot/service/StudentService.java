package com.springboot.service;

import com.springboot.dao.FakeDataStudentDao;
import com.springboot.dao.StudentDao;
import com.springboot.entity.Student;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class StudentService {
@Autowired
    private StudentDao studentDao;
public Collection<Student> returnAllStudents(){
	return studentDao.returnAllStudents();
    }
public Student getStudentById(int id){
    return studentDao.getStudentById(id);
}
public String removeStudentById(int id){
    return studentDao.removeStudentById(id);
}
public String updateStudent(Student student){
    return studentDao.updateStudent(student);
}
public boolean addStudent(Student student){
    return studentDao.addStudent(student);
}
}
