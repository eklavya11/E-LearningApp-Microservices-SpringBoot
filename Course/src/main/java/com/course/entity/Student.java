package com.course.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	@NotEmpty(message = "username is required")
	private String username;
	@Size(min = 8)
	private String password;
	@NotEmpty(message = "firstname is required")
	private String firstname;
	@NotEmpty(message = "lastname is required")
	private String lastname;
	@NotEmpty(message = "Email is required")
	@Column(unique = true)
	private String email;
	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Mobile number is invalid")
	private String phone;
	@OneToMany
	private List<CourseEntity> courses = new ArrayList<>();

	
	public Student(int id, @NotEmpty(message = "username is required") String username, @Size(min = 8) String password,
			@NotEmpty(message = "firstname is required") String firstname,
			@NotEmpty(message = "lastname is required") String lastname,
			@NotEmpty(message = "Email is required") String email,
			@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Mobile number is invalid") String phone,
			List<CourseEntity> courses) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.courses = courses;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<CourseEntity> getCourses() {
		return courses;
	}



	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
	}

}
