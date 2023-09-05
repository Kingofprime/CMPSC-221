package application;

// Class that defines a Contact object with fields for first name, last name, email and age
public class Contact {
	
    // Fields for contact details
	private String firstName;
	private String lastName;
	private String Email;
	private int Age;
	
    // Default constructor to initialize a new Contact with default values
	public Contact()
	{
		this.firstName = "";
		this.lastName = "";
		this.Email = "";
		this.Age = 0 ;
	}

    // Parameterized constructor to initialize a new Contact with given values
	public Contact(String firstName,String lastName,String Email,int Age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.Email = Email;
		this.Age = Age;
	}

    // Getter for first name
	public String getFirstName() {
		return firstName;
	}

    // Setter for first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    // Getter for last name
	public String getLastName() {
		return lastName;
	}

    // Setter for last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    // Getter for email
	public String getEmail() {
		return Email;
	}

    // Setter for email
	public void setEmail(String email) {
		Email = email;
	}

    // Getter for age
	public int getAge() {
		return Age;
	}

    // Setter for age
	public void setAge(int age) {
		Age = age;
	}	
}
