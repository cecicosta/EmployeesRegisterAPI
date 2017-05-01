package com.register.api.entities;

import javax.persistence.OneToMany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.register.api.persistence.DataAccessHelper;
@Entity
@Table(name = "employees")
public class Employee {

	private int id;
	private String employeeId;
	private String name;
	private String encryptedPass;
		
	public Employee(){}
	public Employee(String code, String name, String encryptedPass){
		this.employeeId = code;
		this.name = name;
		this.encryptedPass = encryptedPass;
	}
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "employeeId")
	public String getEmployeeId(){
		return employeeId;
	}
	public void setEmployeeId(String id){
		this.employeeId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEncryptedPass() {
		return encryptedPass;
	}
	public void setEncryptedPass(String encryptedPass) {
		this.encryptedPass = encryptedPass;
	}
	
	transient private Set<HourRegister> registers;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	public Set<HourRegister> getRegisters(){
		return registers;
	}
	public void setRegisters(Set<HourRegister> registers){
		this.registers = registers;
	}
	
	public String toJson(){
		Gson gson = new Gson();
		String json = gson.toJson(this);
        return json;
	}
	

}
