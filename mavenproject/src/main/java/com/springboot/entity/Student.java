package com.springboot.entity;


public class Student {
private int id;
private String name;
private String course;

    public Student(int id, String name, String course) {
	this.id = id;
	this.name = name;
	this.course = course;
    }

    public Student() {
	
    }

    /**
     * @return the id
     */
    public int getId() {
	return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the course
     */
    public String getCourse() {
	return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(String course) {
	this.course = course;
    }


}
