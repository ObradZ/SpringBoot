/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.dao;

import com.springboot.entity.Student;
import java.util.Collection;


public interface StudentDao {

    boolean addStudent(Student student);

    Student getStudentById(int id);

    String removeStudentById(int id);

    Collection<Student> returnAllStudents();

    String updateStudent(Student student);
    
}
