package com.example.springboot.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="patient_table")

@SequenceGenerator(name="patient",sequenceName="patient_gene",initialValue=3000)
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="patient")
	@Column(name="patient_id")
	private long patientId;
	
	@Column(name="first_name")
	@NotEmpty
	@Size(min=4,message="firstName should contain atleast 4 letters in it")
	public String firstName;
	
	@Column(name="last_name")
	@NotEmpty                                                                         
	@Size(min=4,message="lastName should contain atleast 4 letters in it")
	public String lastName;
	
	@Column(name="email_id",unique=true)
	@NotEmpty
	@Email(message="Email  is not valid!")
	public String patientEmailId;
	
	@Column(name="passWord")
	@NotEmpty
	@Size(min=8, message="Password length must be 8 and contain uppercase,lowercase,digits")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String patientPassword;
	
	@Column(name="age")
	@NotNull
	public int age;
	
	@Column(name="gender")
	@NotEmpty
	@Size(min=4,message="please enter gender as male , female , not disclosed")
	public String gender;
	
	@Column(name="contact_number")
	@NotEmpty
	@Size(min=5,message="please enter a valid contact number")
	public String contactNumber;
	
	@Column(name="address")
	@NotEmpty
	@Size(min=3 , message="address must contain atleast 3 characters")
    public String address;
	
	@Column(name="blood_group") 
	@NotEmpty
	@Size(min=2 , message="blood group must contain atleast 2 characters")
    public String bloodGroup;
	
	@Column(name="medical_background")
	@NotEmpty
	@Size(min=3,message="specialization should have atleast 3 letters")
    public String medicalBackground;
	
	@Column(name="admit_date") 
	public Date admitDate;
	


	@Column(name="doctor_id")
	public long doctorId;
	 
	@Column(name="payment_status")
	 
	private String paymentStatus;

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
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

	public String getPatientEmailId() {
		return patientEmailId;
	}

	public void setPatientEmailId(String patientEmailId) {
		this.patientEmailId = patientEmailId;
	}

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getMedicalBackground() {
		return medicalBackground;
	}

	public void setMedicalBackground(String medicalBackground) {
		this.medicalBackground = medicalBackground;
	}

	public Date getAdmitDate() {
		return admitDate;
	}

	public void setAdmitDate(Date admitDate) {
		this.admitDate = admitDate;
	}

	

	



	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", patientEmailId=" + patientEmailId + ", patientPassword=" + patientPassword + ", age=" + age
				+ ", gender=" + gender + ", contactNumber=" + contactNumber + ", address=" + address + ", bloodGroup="
				+ bloodGroup + ", medicalBackground=" + medicalBackground + ", admitDate=" + admitDate
				+  ", doctorId=" + doctorId
				+ ", paymentStatus=" + paymentStatus + "]";
	}
	
	
}