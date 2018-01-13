package com.springboot.controller;

import com.springboot.entity.Student;
import com.springboot.service.StudentService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
@Autowired
private StudentService studentService;

@RequestMapping(method = RequestMethod.GET)
public Collection<Student> returnAllStudents(){
	return studentService.returnAllStudents();
    }
@RequestMapping(value ="/{id}", method = RequestMethod.GET )
public Student getStudentById(@PathVariable("id")int id){
    return studentService.getStudentById(id);
}
@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
public String removeStudentById(@PathVariable("id")int id){
    return studentService.removeStudentById(id);
}
@RequestMapping(method=RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
public String updateStudent(@RequestBody Student student){
    return studentService.updateStudent(student);
}
@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
public boolean addStudent(@RequestBody Student student){
    return studentService.addStudent(student);
}
}
