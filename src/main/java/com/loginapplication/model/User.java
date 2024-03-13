package com.loginapplication.model;

//import java.util.Arrays;

import javax.persistence.*;

//import org.hibernate.annotations.Type;


@Entity
@Table(name = "user_data")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name", columnDefinition = "TEXT")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "gender", columnDefinition = "VARCHAR(10)")
    private String gender;

    @Column(name = "email", columnDefinition = "TEXT")
    private String email;

    @Column(name = "mobile_no", columnDefinition = "TEXT")
    private String mobileNo;

    @Column(name = "password", columnDefinition = "TEXT")
    private String password;

    @Column(name = "languages", columnDefinition = "TEXT")
    private String languages;

    @Column(name = "hobby", columnDefinition = "TEXT")
    private String hobby;

    @Column(name = "country", columnDefinition = "TEXT")
    private String country;

    @Column(name = "role", columnDefinition = "VARCHAR(10) DEFAULT 'user'")
    @Transient
    private String role;

//    @Type(type="org.hibernate.type.BinaryType")
//    @Column(name = "image_file", columnDefinition = "BYTEA")
//    private byte[] image;


    // Getters and setters

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = "user";
    }


//    // Getter and Setter for image
//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }
//    public void setImage(String imageString) {
//        // Convert the string to byte array
//        this.image = imageString.getBytes();
//    }


	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", email=" + email + ", mobileNo=" + mobileNo + ", password=" + password + ", languages=" + languages
				+ ", hobby=" + hobby + ", country=" + country + ", role=" + role + ", image=" 
				+ "]";
	}

	public User(Integer userId, String firstName, String lastName, String gender, String email, String mobileNo,
			String password, String languages, String hobby, String country, String role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
		this.languages = languages;
		this.hobby = hobby;
		this.country = country;
		this.role = role;
//		this.image = image;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}