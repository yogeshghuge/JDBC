package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.util.MyDatabase;

public class StudentDao {
	
	public int insertStudent(Student s)
	{
		int check=0;
		String sql="insert into student(name,city,percentage)values(?,?,?)";
		try(Connection con= MyDatabase.myConnection();
			PreparedStatement pst=con.prepareStatement(sql);){	
				pst.setString(1,s.getName());
				pst.setString(2, s.getCity());
				pst.setDouble(3, s.getPercentage());
				check=pst.executeUpdate();
				
		}catch(SQLException e) { e.printStackTrace();}
		return check;
	}
	
	public int deleteStudentBySid(int id)
	{
		int check=0;
		String sql="delete from student where id=?";
		try (Connection con=MyDatabase.myConnection();
				PreparedStatement pst=con.prepareStatement(sql);){
			pst.setInt(1, id);
			check=pst.executeUpdate();	
		}catch(SQLException e) {e.printStackTrace();}
		return check;
	}
	
	public Student findStudentById(int id)
	{
		Student s=null;
		String sql="select id,name,city,percentage from student where id=?";
		try(Connection con=MyDatabase.myConnection();
				PreparedStatement pst=con.prepareStatement(sql);
				){
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			List<Student> list=MyDatabase.studentRowMapper(rs);
			if(!list.isEmpty())
				s=list.get(0);
		}catch(SQLException e ) {
			e.printStackTrace();}
		return s;
		
	}
	
	public List<Student> findAllStudent()
	{
		List<Student> list=new ArrayList();
		String sql="select id,name,city,percentage from student";
		try(Connection con=MyDatabase.myConnection();
				PreparedStatement pst=con.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();){
			 list=MyDatabase.studentRowMapper(rs);
		}catch(SQLException e ) {
			e.printStackTrace();}
		return list;
	}
	
	public int updateStudent(Student s)
	{
		int check=0;
		String sql="update student set name=?,city=?,percentage=? where id=?";
		try(Connection con=MyDatabase.myConnection();
				PreparedStatement pst=con.prepareStatement(sql);){
			pst.setString(1, s.getName());
			pst.setString(2, s.getCity());
			pst.setDouble(3,s.getPercentage());
			pst.setInt(4,s.getId());
			check=pst.executeUpdate();	
		}catch(SQLException e ) {
			e.printStackTrace();}
		return check;
	}
	
	
	
}
