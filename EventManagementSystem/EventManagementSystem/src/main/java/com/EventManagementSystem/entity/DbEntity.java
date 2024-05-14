package com.EventManagementSystem.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "regtb")
public class DbEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	int usertype;
	@NotBlank(message = "Full Name is mandatory.")
	String name;
	@NotBlank(message = "Mobile no. is mandatory.")
	@Size(min = 10, max = 10, message = "Mobile no. is invalid.")
	String mobile;
	@NotBlank(message = "Alt Mobile no. is mandatory.")
	@Size(min = 10, max = 10, message = "Alt Mobile no. is invalid.")
	String altmobile;
	@NotBlank(message = "DOB is mandatory.")
	String dob;
	@NotBlank(message = "Email is mandatory.")
	@Email(message = "Email is invalid.")
	String email;
	@NotBlank(message = "Gender is mandatory.")
	String gender;
	@NotBlank(message = "Address is mandatory.")
	String address;
	@NotBlank(message = "Aadhar no. is mandatory.")
	String aadharno;
	String preparedby;
	String approvedby;
	String updateby;

	Timestamp prepareddt;
	Timestamp updatedt;
	Timestamp approveddt;

	public DbEntity(int id, int usertype, @NotBlank(message = "Full Name is mandatory.") String name,
			@NotBlank(message = "Mobile no. is mandatory.") @Size(min = 10, max = 10, message = "Mobile no. is invalid.") String mobile,
			@NotBlank(message = "Alt Mobile no. is mandatory.") @Size(min = 10, max = 10, message = "Alt Mobile no. is invalid.") String altmobile,
			@NotBlank(message = "DOB is mandatory.") String dob,
			@NotBlank(message = "Email is mandatory.") @Email(message = "Email is invalid.") String email,
			@NotBlank(message = "Gender is mandatory.") String gender,
			@NotBlank(message = "Address is mandatory.") String address, String aadharno, String preparedby,
			String approvedby, String updateby, Timestamp prepareddt, Timestamp updatedt, Timestamp approveddt) {
		super();
		this.id = id;
		this.usertype = usertype;
		this.name = name;
		this.mobile = mobile;
		this.altmobile = altmobile;
		this.dob = dob;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.aadharno = aadharno;
		this.preparedby = preparedby;
		this.approvedby = approvedby;
		this.updateby = updateby;
		this.prepareddt = prepareddt;
		this.updatedt = updatedt;
		this.approveddt = approveddt;
	}

	public DbEntity() {
		super();
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public String getAadharno() {
		return aadharno;
	}

	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAltmobile() {
		return altmobile;
	}

	public void setAltmobile(String altmobile) {
		this.altmobile = altmobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPreparedby() {
		return preparedby;
	}

	public void setPreparedby(String preparedby) {
		this.preparedby = preparedby;
	}

	public String getApprovedby() {
		return approvedby;
	}

	public void setApprovedby(String approvedby) {
		this.approvedby = approvedby;
	}

	public String getUpdateby() {
		return updateby;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	public Timestamp getPrepareddt() {
		return prepareddt;
	}

	public void setPrepareddt(Timestamp prepareddt) {
		this.prepareddt = prepareddt;
	}

	public Timestamp getUpdatedt() {
		return updatedt;
	}

	public void setUpdatedt(Timestamp updatedt) {
		this.updatedt = updatedt;
	}

	public Timestamp getApproveddt() {
		return approveddt;
	}

	public void setApproveddt(Timestamp approveddt) {
		this.approveddt = approveddt;
	}

}
