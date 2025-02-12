package com.dro;

import java.util.List;

import com.dao.StudentDao;
import com.model.Student;

public class App 
{
    public static void main( String[] args )
    {
    	StudentDao sd=new StudentDao();
    	/*Student s1=new Student(); insert method 
    	s1.setName("Virat");
    	s1.setCity("Kota");
    	s1.setPercentage(81.63);
    	System.out.println(sd.insertStudent(s1));*/
    	
    	/*System.out.println(sd.deleteStudentBySid(4));
    	 * it is used to delete the data from the database and it is 
    	 * ddl so it showing 1 or 0 in output.
    	 */
    	
    	/*Student s1=sd.findStudentBySid(2);
    	 *  //it is used to find one student at a time 
    	System.out.println(s1);*/
    	
    	/*List<Student> list= sd.findAllStudent();
    	for(Student s:list)
    		System.out.println(s);
    		//it is used to find all student 
    		*/
    	
    		Student s1= sd.findStudentBySid(3);
    		s1.setName("Mahesh");
    		System.out.println(sd.updateStudent(s1));
    	
    	
    }
}
