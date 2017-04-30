package com.register.api.entities;

import javax.persistence.OneToMany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;
@Entity
@Table(name = "employees")
public class Employee {

	private String id;
	private String name;
	private String encryptedPass;
		
	public Employee(){}
	public Employee(String id, String name, String encryptedPass){
		this.id = id;
		this.name = name;
		this.encryptedPass = encryptedPass;
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
	@Id
	@Column(name = "employeeId")
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}

	private Set<HourRegister> registers;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	public Set<HourRegister> getRegisters(){
		return registers;
	}
	public void setRegisters(Set<HourRegister> registers){
		this.registers = registers;
	}
	
	public JSONObject toJson() throws JSONException{
		JSONObject json = new JSONObject();
		json.put("id", getId()); 
        json.put("name", getName());
        return json;
	}
}
