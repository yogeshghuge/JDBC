package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.Student;
import com.util.MyDatabase;

public class StudentDao {
	
	public List<Student> findStudentByPercentageGreaterThan(double percentage)
	{
		List<Student> list=new ArrayList();
		String sql="select id,name,city,percentage from student where percentage >?";
		try(Connection con=MyDatabase.myConnection();
				PreparedStatement pst=con.prepareStatement(sql);) {
					pst.setDouble(1, percentage);
					ResultSet rs=pst.executeQuery();
					list.addAll(MyDatabase.studentRowMapper(rs));
		}catch(SQLException e ){ e.printStackTrace();}
		
		return list;
	}
	
	public List<Student> findStudentByPercentageLessThan(double percetnage)
	{
		List<Student> list=new ArrayList();
		String sql="select id,name, city, percentage from student where percentage <?";
		try(Connection con=MyDatabase.myConnection();
				PreparedStatement pst=con.prepareStatement(sql);) {
				pst.setDouble(1, percetnage);
				ResultSet rs=pst.executeQuery();
				list.addAll(MyDatabase.studentRowMapper(rs));
		}catch(SQLException e ) {e.printStackTrace();}
		return list;	
	}
	
		public List<Student> findStudentByPercentageBetween(double low, double high)
		{
			List<Student> list=new ArrayList();
			String sql="select id, name,city,percentage from student where percentage between ? and ?";
			try (Connection con=MyDatabase.myConnection();
					PreparedStatement pst=con.prepareStatement(sql);){
				pst.setDouble(1, low);
				pst.setDouble(2, high);
				ResultSet rs=pst.executeQuery();
				list.addAll(MyDatabase.studentRowMapper(rs));
			}catch(SQLException e ) {e.printStackTrace();}
			
			return list;
		}
		
		public List<Student> findStudentByNameStartsWith(String name)
		{
			List<Student> list=new ArrayList();
			String sql="Select id,name,city,percentage from student where name like ?";
			try(Connection con=MyDatabase.myConnection();
					PreparedStatement pst=con.prepareStatement(sql);){
				pst.setString(1, name+"%");
				ResultSet rs=pst.executeQuery();
				list.addAll(MyDatabase.studentRowMapper(rs));
			}catch(SQLException e ) {e.printStackTrace();}
			
			
			return list;
		}
	public List<Student> findStudentByNameContains(String name)
	{
		List<Student> list=new ArrayList();
		String sql="Select id,name,city,percentage from student where name like ?";
		try(Connection con=MyDatabase.myConnection();
				PreparedStatement pst=con.prepareStatement(sql);){
			pst.setString(1, "%"+name+"%");
			ResultSet rs=pst.executeQuery();
			list.addAll(MyDatabase.studentRowMapper(rs));
		}catch(SQLException e ) {e.printStackTrace();}
		
		return list;
	}
	
	public Student findStudentByIdAndName(int id, String name)
	{
		Student s=null;
		String sql="select id,name,city,percentage from student where id=? and name=?";
		try(Connection con=MyDatabase.myConnection();
				PreparedStatement pst=con.prepareStatement(sql);){
			pst.setInt(1, id);
			pst.setString(2, name);
			ResultSet rs=pst.executeQuery();
			List<Student> list=MyDatabase.studentRowMapper(rs);
			if(!list.isEmpty())
				s=list.get(0);
		}catch(SQLException e ) {e.printStackTrace();}
		
		return s;
	}
	public List<Student>findStudentBySidOrName(int id,String name)
	{
		List<Student> list=new ArrayList();
		String sql="Select id,name,city,percentage from student where id=? or name=?";
		try(Connection con=MyDatabase.myConnection();
				PreparedStatement pst=con.prepareStatement(sql);){
			pst.setInt(1, id);
			pst.setString(2, name);
			ResultSet rs=pst.executeQuery();
			list.addAll(MyDatabase.studentRowMapper(rs));
		}catch(SQLException e ) {e.printStackTrace();}
		return list;
		
	}
	
	public List<String> findAllName()
	{
			List<String> list=new ArrayList();
			String sql="Select name from student";
			try(Connection con=MyDatabase.myConnection();
					PreparedStatement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();){
				while(rs.next())
					list.add(rs.getString("name"));
			}catch(SQLException e) {e.printStackTrace();}
			return list;
			
	}
	public Map<String,List<String>> findNameAndCity()
	{
		Map<String,List<String>> m=new HashMap();
		String sql="Select name,city from student";
		try(Connection con=MyDatabase.myConnection();
				PreparedStatement pst=con.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();){
		List<String> listOfNames = new ArrayList();
		List<String> listOfCities =new ArrayList();
		while(rs.next())
		{
			listOfNames.add(rs.getString("name"));
			listOfCities.add(rs.getString("city"));
		}
		m.put("listOfNames", listOfNames);
		m.put("listOfCities", listOfCities);
		}catch(SQLException e) {e.printStackTrace();}
		return m;
		
	}
	public int countStudentByPercentageGraterThan(double percentage)
	{
		int check=0;
		String sql="select count(*) as a from student where percentage > ?";
		try(Connection con=MyDatabase.myConnection();
				PreparedStatement pst=con.prepareStatement(sql);){
					pst.setDouble(1, percentage);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
					check=rs.getInt("a");
			rs.close();	
				}catch(SQLException e){e.printStackTrace();}
		
		return check;
	}
}
