package com.springboot.dao;

import com.springboot.entity.Student;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class StudentDao {

    private static Map<Integer,Student> students;
    
    static{
	students  = new HashMap<Integer,Student>(){
	    {
		put(1,new Student(1,"Mark","Biology"));
		put(1,new Student(1,"Stive","ComputerScience"));
		put(1,new Student(1,"Johnny","Math"));
		put(1,new Student(1,"Nicol","Languges"));
	    }
	};
	
    }
    public Collection<Student> returnAllStudents(){
	return this.students.values();
    }
}
