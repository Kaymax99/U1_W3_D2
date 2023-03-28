package com.epicode.main;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;

import com.epicode.connector.DBConnection;
import com.epicode.model.Gender;
import com.epicode.model.Student;

public class DBHandler {

	public static void main(String[] args) {
		
		

		try {
			DBConnection db = new DBConnection();
			
			Student s = new Student("Doge", "Goodboy", Gender.M, LocalDate.of(1999, 2, 3), 8.5, 7, 10);
			Student s1 = new Student("Shibe", "Goodboy", Gender.M, LocalDate.of(1999, 2, 3), 9, 8, 10);
			Student s2 = new Student("Akite", "Goodboy", Gender.M, LocalDate.of(1999, 2, 3), 8, 7, 9);
			
//			db.insertStudent(s);
//			db.insertStudent(s1);
//			db.insertStudent(s2);
			HashMap<String, Object> map = new HashMap<String, Object>() {{
				put("name", "Doggers");
				put("lastname", "Badboy");
				put("gender", Gender.M);
				put("birthdate", LocalDate.of(2001, 1, 11));
				put("avg", 7.5);
				put("min_vote", 6);
				put("max_vote", 8);
			}};
//			db.updateStudent(1, map);
//			System.out.println(db.getBest());
			System.out.println(db.getVoteRange(7, 10));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
