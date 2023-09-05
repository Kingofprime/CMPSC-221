package application;

import java.time.LocalDate;

public class Person {
	
	 private String lname;
	 private String fname;
	 private String email;
	 
	 public Person()
	 {
		 
	 }
	 
	 public Person( String last_name, String first_name, String Email)
	 {
		 
		 this.lname = last_name;
		 this.fname = first_name;
		 this.email = Email;
	 }

	
	public String getLast_name() {
		return lname;
	}

	public void setLast_name(String last_name) {
		this.lname = last_name;
	}

	public String getFirst_name() {
		return fname;
	}

	public void setFirst_name(String first_name) {
		this.fname = first_name;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String Email) {
		this.email = Email;
	}
	
}
