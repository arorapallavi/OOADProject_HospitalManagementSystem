package com.example.springboot.model;

 

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name="booking_appointment")
@Data
@SequenceGenerator( name="booking",sequenceName="booking_gene",initialValue=1)
public class BookingAppointment {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="booking")
	@Column(name="appointment_id")
	private long appointmentId;
	
	@Column(name="patient_id")
	private long patientId;
	
	@Column(name="appointment_date") 
	private String appointmentDate; 
	
	@Column(name="appointment_time")
	//@Size(max=2)
	private int appointmentTime;
	
	@Column(name="am_pm")
	@Size(max=2)
	private String meridiem;

	@ManyToOne( cascade=CascadeType.MERGE) 
	@JoinColumn(name="doctor_id")
	
	@OnDelete(action=OnDeleteAction.CASCADE) 
	private Doctor doctor;

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public int getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(int appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getMeridiem() {
		return meridiem;
	}

	public void setMeridiem(String meridiem) {
		this.meridiem = meridiem;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "BookingAppointment [appointmentId=" + appointmentId + ", patientId=" + patientId + ", appointmentDate="
				+ appointmentDate + ", appointmentTime=" + appointmentTime + ", meridiem=" + meridiem + ", doctor="
				+ doctor + "]";
	}
	
	
	
}
