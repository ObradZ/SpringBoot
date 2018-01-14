package com.springboot.dao;

import com.springboot.entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
	connection = MySqlConnection.getConnection();
	try {
	    if (connection!= null) {
		PreparedStatement ps = connection.prepareStatement("insert into student(id,name,course) values(null,?,?);  ");
		ps.setString(1, student.getName());
		ps.setString(2, student.getCourse());
		ps.execute();
		return true;
	    }
	} catch (SQLException se) {
	    return false;
	} finally {
	    try {
		if (!connection.isClosed()) {
		    connection.close();
		}
	    } catch (SQLException ex) {
		Logger.getLogger(MySqlStudentDao.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	return false;
    }

    @Override
    public Student getStudentById(int id) {
	connection = MySqlConnection.getConnection();
	try {
	    Student s = new Student(0, "NoData", "NoData");
	    if (connection!= null) {
		PreparedStatement ps = connection.prepareStatement("select * from student where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		s = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("course"));
		return s;

	    } else {
		return s;
	    }
	} catch (SQLException se) {
	    return new Student(0, "NoData", "NoData");
	} catch (Exception ex) {
	    return new Student(0, "NoData", "NoData");
	} finally {
	    try {
		if (!connection.isClosed()) {
		    connection.close();
		}
	    } catch (SQLException ex) {
		Logger.getLogger(MySqlStudentDao.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }

    @Override
    public String removeStudentById(int id) {
	connection=MySqlConnection.getConnection();
	try {
	    if (connection!= null) {
		PreparedStatement ps = connection.prepareStatement("delete from student where id=?");
		ps.setInt(1, id);
		ps.execute();
		return "All went nice!:)";

	    } else {
		return "not good. else";
	    }
	} catch (SQLException se) {
	    return "SQLException";
	} catch (Exception ex) {
	    return "Exception";
	} finally {
	    try {
		if (!connection.isClosed()) {
		    connection.close();
		}
	    } catch (SQLException ex) {
		Logger.getLogger(MySqlStudentDao.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }

    @Override
    public Collection<Student> returnAllStudents() {
	connection = MySqlConnection.getConnection();
	try {
	    if (connection!= null) {

		List<Student> students = new ArrayList<Student>();
		Statement st = connection.createStatement();
		st.execute("select * from student;");
		ResultSet rs = st.getResultSet();

		while (rs.next()) {
		    students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("course")));
		}

		return students;
	    }
	} catch (SQLException se) {
	    return null;
	}catch(Exception e){
	    return null;
	}finally{
	      try {
		if (!connection.isClosed()) {
		    connection.close();
		}
	    } catch (SQLException ex) {
		return null;
	    }catch(Exception e){
		return null;
	    }
	}
	    return null;
    }

    @Override
    public String updateStudent(Student student) {
	connection = MySqlConnection.getConnection();
	try {
	    if (connection!= null) {
		PreparedStatement ps = connection.prepareStatement("update student set name=?,course=? where id=?");
		ps.setString(1, student.getName());
		ps.setString(2, student.getCourse());
		ps.setInt(3, student.getId());
		ps.execute();
		return "Updated!";

	    } else {
		return "Not good!";
	    }
	} catch (SQLException se) {
	    return se.getMessage();
	} catch (Exception ex) {
	    return "Exception";
	} finally {
	    try {
		if (!connection.isClosed()) {
		    connection.close();
		}
	    } catch (SQLException ex) {
		return "SQL2.";
	    }catch(Exception e){
		return "ex";
	    }
	}
    }

}
