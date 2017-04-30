package com.hib.entities;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "registers")
public class HourRegister {

	
	private Integer id;
	private Date time;
	private Employee employee;
	
	public HourRegister(){}
	public HourRegister(Date time, Employee employee){
		this.time = time;
		this.employee = employee;
	}
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	@Id
	@Column(name = "registerId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "employeeId")
	public Employee getEmployee(){
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
