package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Student;
import com.util.MyDatabase;

public class StudentDao {
	
	public int insertStudent(Student s)
	{
		int check=0;
		Connection con= MyDatabase.myConnection();
		String sql="insert into student(name,city,percentage)values(?,?,?)";
		PreparedStatement pst=null;
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setString(2, s.getCity());
			pst.setDouble(3, s.getPercentage());
			check=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyDatabase.closeConnection(pst, con);
		}
		
		return check;
	}
	public int DeleteStudentBySid(int id)
	{
		int check=0;
		Connection con=MyDatabase.myConnection();
		String sql="delete from student where id=?";
		PreparedStatement pst=null;
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyDatabase.closeConnection(pst,con);
		}
		
		
		
		return check;
	}
	public Student finalStudentBySid(int id)
	{
		Student s=null;
		Connection con=MyDatabase.myConnection();
		PreparedStatement pst=null;
		String sql="select id,name,city,percentage from student where id=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}
}
