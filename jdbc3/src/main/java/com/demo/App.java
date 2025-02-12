package com.demo;

import com.dao.StudentDao;
import com.model.Student;

public class App 
{
    public static void main( String[] args )
    {
    	StudentDao sd=new StudentDao();
    	/*
    	 * insert operation
    	 * Student s1=new Student();
    	s1.setName("Nitin");
    	s1.setCity("chennai");
    	s1.setPercentage(93.21);
    	System.out.println(sd.insertStudent(s1));*/
    	System.out.println(sd.DeleteStudentBySid(2));
    	
    	

    }
}
