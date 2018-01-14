package com.springboot.dao;

import com.springboot.entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
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
	    return true;
	}
	}catch(SQLException se){
	    return false;
	}finally{
	    try {
		if(!connection.isClosed())
		    connection.close();
	    } catch (SQLException ex) {
		Logger.getLogger(MySqlStudentDao.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	return false;
    }

    @Override
    public Student getStudentById(int id) {
	try{
	    Student s=new Student(0,"NoData","NoData");
	if((connection=MySqlConnection.getConnection())!=null){
	PreparedStatement ps = connection.prepareStatement("select * from student where id=?");
	ps.setInt(1, id);
	ResultSet rs =ps.executeQuery();
	rs.next();
	s = new Student(rs.getInt("id"),rs.getString("name"),rs.getString("course"));
	return s;	
	
	}else
	    return s;
	}catch(SQLException se){
	    return new Student(0,"NoData","NoData");
	}catch(Exception ex){
	    return new Student(0,"NoData","NoData");
	}finally{
	    try {
		if(!connection.isClosed())
		    connection.close();
	    } catch (SQLException ex) {
		Logger.getLogger(MySqlStudentDao.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
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
