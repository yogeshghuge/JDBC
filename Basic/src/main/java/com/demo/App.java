package com.demo;


import com.Dao.StudentDao;
import com.model.Student;

public class App {
    public static void main(String[] args) {
    	//insert Student
        StudentDao sd=new StudentDao();
        Student s=new Student();
        s.setId(1);
        s.setName("Diksha");
        s.setDepartment("computer");
        s.setEmail("dvcnb@gmail.com");
        System.out.println(sd.insertStudent(s));
       /* //delete Student
        System.out.println(new StudentDao().deleteStudentById(2));*/
        //findStudentById
       /* Student s=new StudentDao().findStudentById(1);
        System.out.println(s);*/
        //updateStudent
       /* Student s =new StudentDao().findStudentById(1);
        System.out.println(s);
        s.setDepartment("trgdbwjhd");
        System.out.println(s);*/
        //displayStudent
       /* for(Student s:new StudentDao().findAllStudentById(2))
        {
        	System.out.println(s);
        }*/
        
        
    }
}