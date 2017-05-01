package com.register.api.events;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.register.api.entities.Employee;
import com.register.api.persistence.PersistenceUtil;

public class SignUpEmployeeHandler implements EventHandler{
	
	private Employee employee;
	public SignUpEmployeeHandler(Employee employee) {
		this.setEmployee(employee);
	}
	
	public void execute() throws Exception{
		Session session = null;
	    Transaction trans = null;
		try{
		    session = PersistenceUtil.getCommandSessionFactory().openSession();
	        trans = session.beginTransaction();
		    session.save(employee);
	        trans.commit();
		}catch(Exception ex){
			throw ex;
		}finally{
			if(!trans.wasCommitted()){
				trans.rollback();
				session.flush();
				session.close();
				throw new Exception("Failed to save entity on database.");
			}
			session.flush();
			session.close();
		}
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
