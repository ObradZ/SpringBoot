package com.springboot.dao;

import com.springboot.entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mySql")
public class MySqlStudentDao implements StudentDao {
    
    Connection connection;
    
    
    @Override
    public boolean addStudent(Student student) {
	try{
	if((connection=MySqlConnection.getConnection())!=null){
	    PreparedStatement ps = connection.prepareStatement("insert into student(id,name,course) values(null,?,?);  ");
	    ps.setString(1,student.getName());
	    ps.setString(2, student.getCourse());
	    ps.execute();
	    connection.close();
	    return true;
	}
	}catch(SQLException se){
	    return false;
	}
	return false;
    }

    @Override
    public Student getStudentById(int id) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String removeStudentById(int id) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Student> returnAllStudents() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String updateStudent(Student student) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
