package com.springboot.dao;

import com.springboot.entity.Student;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("fakeData")
public class FakeDataStudentDao implements StudentDao {

    private static Map<Integer, Student> students;

    static {
	students = new HashMap<Integer, Student>() {
	    {
		put(1, new Student(1, "Mark", "Biology"));
		put(2, new Student(2, "Stive", "ComputerScience"));
		put(3, new Student(3, "Johnny", "Math"));
		put(4, new Student(4, "Nicol", "Languges"));
	    }
	};

    }

    @Override
    public Collection<Student> returnAllStudents() {
	return this.students.values();
    }

    @Override
    public Student getStudentById(int id) {
	if (this.students.get(id) != null) {
	    return this.students.get(id);
	} else {
	    return new Student(0, "NoData", "NoData");
	}
    }

    @Override
    public String removeStudentById(int id) {
	if (this.students.containsKey(id)) {
	    this.students.remove(id);
	    return "done!";
	} else {
	    return "No student with that id!";
	}
    }

    @Override
    public String updateStudent(Student student) {

	Student s = this.students.get(student.getId());
	s.setCourse(student.getCourse());
	s.setName(student.getName());
	return "cool";
    }

    @Override
    public boolean addStudent(Student student) {
	if (this.students.containsKey(student.getId())) {
	    return false;
	} else {
	    Student s = new Student(student.getId(),student.getName(),student.getCourse());
	    this.students.put(s.getId(),s);
	    return true;
	}
    }
}
