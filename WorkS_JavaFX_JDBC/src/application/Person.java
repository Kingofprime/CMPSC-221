package application;

public class Person {
	
	 private int id;
	 private String last_name;
	 private String first_name;
	 private String email;
	 private String department;
	 private double salary;
	 
	 public Person()
	 {
		 this.id = 0;
		 this.last_name = "";
		 this.first_name = "";
		 this.email = "";
		 this.department = "";
		 this.salary = 0.0;
	 }
	 
	 public Person(int id, String last_name, String first_name,
			       String email, String department, double salary)
	 {
		 this.id = id;
		 this.last_name = last_name;
		 this.first_name = first_name;
		 this.email = email;
		 this.department = department;
		 this.salary = salary;
	 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	 
}
