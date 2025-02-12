package com.demo;

import java.util.List;
import java.util.Random;

import com.dao.StudentDao;
import com.model.Student;

public class App 
{
    public static void main( String[] args )
    {
    	StudentDao sd=new StudentDao();
    	/*update query
    	 * 
    	  Student s1=new Student();
    	  s1.setName("Nitin");
    	  s1.setCity("katraj");
    	  s1.setPercentage(93.21);
    	  System.out.println(sd.insertStudent(s1));
    	 */
    	
    	/* delete query
    	 * 
    	 * System.out.println(sd.deleteStudentBySid(8));
    	 */
    	/* fatch by id
    	 	Student s1=sd.findStudentById(1);
    		System.out.println(s1);
    	*/
    	/*find all date from database
    	 * List<Student> list=  sd.findAllStudent();
    	for(Student s:list)
    		System.out.println(s);
    	*/
    	/*update the data 
    	 * Student s1=sd.findStudentById(1);
    	s1.setName("Mahesh");
    	s1.setCity("pak");
    	System.out.println(s1);*/
    	/*
    	for(int i=1;i<=5000;i++)
    	{
    		Student s1=new Student();
    		StringBuilder name=new StringBuilder();
    		StringBuilder city=new StringBuilder();
    		for(int j=1;j<=15;j++)
    		{
    			name.append((char)(new Random().nextInt(26)+65));
    			city.append((char)(new Random().nextInt(26)+65));
    		}
    		s1.setName(name.toString());
    		s1.setCity(city.toString());
    		s1.setPercentage(new Random().nextDouble()*100);
    		System.out.println(sd.insertStudent(s1));
    	}
    	*/
 }
}
