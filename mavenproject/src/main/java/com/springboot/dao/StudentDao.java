package com.springboot.dao;

import com.springboot.entity.Student;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    private static Map<Integer,Student> students;
    
    static{
	students  = new HashMap<Integer,Student>(){
	    {
		put(1,new Student(1,"Mark","Biology"));
		put(2,new Student(2,"Stive","ComputerScience"));
		put(3,new Student(3,"Johnny","Math"));
		put(4,new Student(4,"Nicol","Languges"));
	    }
	};
	
    }
    public Collection<Student> returnAllStudents(){
	return this.students.values();
    }
    public Student getStudentById(int id){
	if(this.students.get(id)!=null)
	return this.students.get(id);
	else
	    return new Student(0,"NoData","NoData");
    }
}
