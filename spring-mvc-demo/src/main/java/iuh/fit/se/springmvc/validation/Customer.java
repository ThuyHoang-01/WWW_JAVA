package iuh.fit.se.springmvc.validation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
	@CourseCode(value = "TOPS", message = "must start with TOPS") // Custom annotation
	private String courseCode;

	// default of value is "MVC" and message is "must start with MVC"
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
	private String postalCode;

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;

	@NotNull(message = "is required")
	@Min(value = 0, message = "must be greater than or equal to zero")
	@Max(value = 10, message = "must be less than or equal to 10")
	private int freePasses;

	public int getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}

	private String firstName;

	public Customer() {

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

}
