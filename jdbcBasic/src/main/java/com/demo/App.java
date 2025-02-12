package com.demo;

import java.util.List;
import java.util.Map;

import com.dao.StudentDao;

public class App 
{
    public static void main( String[] args )
    {
    	StudentDao sd=new StudentDao();
    	/* find student by percentage greater than*/
    		/*
    		List<Student> list=sd.findStudentByPercentageGreaterThan(95);
    		for(Student s:list)
    		System.out.println(s);
    		*/
    	//find student by percentage less than
    	/* List<Student> list=sd.findStudentByPercentageLessThan(2);
    	 for(Student s:list)
    		 System.out.println(s);
    	*/
    	
    	//find student by percentage between
    	/*List<Student> list=sd.findStudentByPercentageBetween(33, 34);
    	for(Student s:list)
    		System.out.println(s);
    	*/
    	
    	// find student by name starting with
    	/*List<Student> list=sd.findStudentByNameStartsWith("VIR");
    	for(Student s:list)
    		System.out.println(s);*/
    	
    	//find student by name contains
    	/*List<Student> list=sd.findStudentByNameContains("RCB");
    	for(Student s:list)
    		System.out.println(s);*/
    	
    	//and operation
    	/*Student s=sd.findStudentByIdAndName(27, "OJXVWREVJWMPIKF"); 
    	System.out.println(s);*/
    	
    	//or operation
    	/*List<Student> list=sd.findStudentBySidOrName(100, "Virat");
    	for(Student s:list)
    	System.out.println(s);*/
    	
    	//display all names
    	/*List<String> list=sd.findAllName();
    	for(String s:list)
    		System.out.println(s);*/
    	
    	//find name and city of all students
    	Map<String, List<String>> m=sd.findNameAndCity();
    	/*for(int i=0;i<m.get("listOfNames").size();i++)
    	{
    		System.out.println(m.get("listOfNames").get(i)+"\t\t"+m.get("listOfCities").get(i));
    	}*/
    	/*System.out.println("list of Names");
    	System.out.println("------------------");
    	for(String s:m.get("listOfNames"))
    		System.out.println(s);
    	System.out.println("list of cities");
    	System.out.println("------------------------------------");
    	for(String s:m.get("listOfCities"))
    		System.out.println(s);*/
    	
    	//To count student greater than 
    	int check=sd.countStudentByPercentageGraterThan(90);
    	System.out.println(check);
    	
    }
}
