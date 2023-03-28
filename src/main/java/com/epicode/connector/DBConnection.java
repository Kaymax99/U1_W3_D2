package com.epicode.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import com.epicode.model.Gender;
import com.epicode.model.Student;

public class DBConnection {

    private String url = "jdbc:postgresql://localhost:5432/";
    private String dbName =  "JDBC_java";
    private String username = "postgres";
    private String password = "root";
    Statement stat;
    
    public DBConnection() throws SQLException {
    	Connection conn = DriverManager.getConnection(url+dbName, username, password);
    	stat = conn.createStatement();
    	createTabUser();
    }
    
    public void createTabUser() throws SQLException {
    	String sql = "CREATE TABLE IF NOT EXISTS school_students ("
    			+ "id SERIAL PRIMARY KEY,"
    			+ "name VARCHAR NOT NULL,"
    			+ "lastname VARCHAR NOT NULL,"
    			+ "gender CHAR NOT NULL,"
    			+ "birthdate date NOT NULL,"
    			+ "avg double precision NOT NULL,"
    			+ "min_vote integer,"
    			+ "max_vote integer)";
    	this.stat.executeUpdate(sql);
    }
    
    public void insertStudent(Student s) throws SQLException {
    	String sql = "INSERT INTO school_students (name, lastname, gender, birthdate, avg, min_vote, max_vote)" 
    			+ "VALUES ('"+s.getName()+"', '"+s.getLastName()+"', '"+s.getGender()+"', '"+s.getBirthDate()+"',"
    					+ " '"+s.getAvg()+"', '"+s.getMin_vote()+"', '"+s.getMax_vote()+"')";
    	this.stat.executeUpdate(sql);
    	System.out.println("Student added to DB");    	
    }
    
    public void updateStudent(int id, HashMap<String, Object> s) throws SQLException {
    	String sql = "UPDATE school_students SET name ='"+s.get("name").toString()+"', lastname='"+s.get("lastname").toString()+"',"
    			+ "gender ='"+s.get("gender").toString()+"', birthdate ='"+s.get("birthdate")+"', avg ='"+(Double)s.get("avg")+"',"
    			+ "min_vote ='"+(Integer)s.get("min_vote")+"', max_vote ='"+(Integer)s.get("max_vote")+"' WHERE id =" + id;
    	this.stat.executeUpdate(sql);
    	System.out.println("Student info successfully updated");
    }
    
    public void deleteStudent(int id) {
    	String sql = "DELETE FROM school_students WHERE id = " + id;
    }
    
    public Student getBest() throws SQLException {
    	Student bestStudent = null;
    	String sql = "SELECT * FROM school_students WHERE avg = (SELECT MAX(avg) FROM school_students)";
    	ResultSet rs = this.stat.executeQuery(sql);
    	if (rs.next()) {
    		bestStudent = new Student (
    				rs.getString("name"),
    				rs.getString("lastname"),
    				Gender.valueOf(rs.getString("gender")),
    				LocalDate.parse(rs.getObject("birthdate").toString()),
    				rs.getDouble("avg"),
    				rs.getInt("min_vote"),
    				rs.getInt("max_vote")
    				);
    	}
		return bestStudent;
    }
    
    public ArrayList<Student> getVoteRange(int min, int max) throws SQLException {
    	ArrayList<Student> students = new ArrayList<Student>();
    	String sql = "SELECT * from school_students WHERE min_vote >=" + min + " AND max_vote <=" + max;
    	ResultSet rs = this.stat.executeQuery(sql);
    	while (rs.next()) {
    		students.add(
    		new Student (
    				rs.getString("name"),
    				rs.getString("lastname"),
    				Gender.valueOf(rs.getString("gender")),
    				LocalDate.parse(rs.getObject("birthdate").toString()),
    				rs.getDouble("avg"),
    				rs.getInt("min_vote"),
    				rs.getInt("max_vote")
    				)
    		);
    	}
    	return students;
    }
}
