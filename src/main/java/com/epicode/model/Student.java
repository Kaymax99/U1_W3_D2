package com.epicode.model;

import java.time.LocalDate;

public class Student {
	
	int id;
	String name;
	String lastName;
	Gender gender;
	LocalDate birthDate;
	double avg;
	int min_vote;
	int max_vote;
	
	public Student(int id, String name, String lastName, Gender gender, LocalDate birthDate, double avg, int min_vote,
			int max_vote) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.avg = avg;
		this.min_vote = min_vote;
		this.max_vote = max_vote;
	}
	
	

	public Student(String name, String lastName, Gender gender, LocalDate birthDate, double avg, int min_vote,
			int max_vote) {
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.avg = avg;
		this.min_vote = min_vote;
		this.max_vote = max_vote;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getMin_vote() {
		return min_vote;
	}

	public void setMin_vote(int min_vote) {
		this.min_vote = min_vote;
	}

	public int getMax_vote() {
		return max_vote;
	}

	public void setMax_vote(int max_vote) {
		this.max_vote = max_vote;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		String str = "";
		str += "\nStudent: \n";
		str += "\nName: "+ this.getName();
		str += "\nSurname: "+ this.getLastName();
		str += "\nGender: "+ this.getGender();
		str += "\nDOB: "+ this.getBirthDate();
		str += "\nAvg: "+ this.getAvg();
		str += "\nMin Vote: "+ this.getMin_vote();
		str += "\nMax Vote: "+ this.getMax_vote();
		return str;
		
	}
	
}
