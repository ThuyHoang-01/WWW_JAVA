package iuh.fit.src;

public class Student {
	private String firstName;
	private String lastName;
	private boolean sex;
	public Student(String firstName, String lastName, boolean sex) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
}
