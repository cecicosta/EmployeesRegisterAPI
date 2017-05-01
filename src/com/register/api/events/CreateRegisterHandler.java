package com.register.api.events;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.register.api.entities.HourRegister;
import com.register.api.persistence.PersistenceUtil;

public class CreateRegisterHandler implements EventHandler{

	private HourRegister register;
	public CreateRegisterHandler(HourRegister hourRegister) {
		this.setRegister(hourRegister);
	}

	public void execute() throws Exception{
		Session session = null;
	    Transaction trans = null;
		try{
		    session = PersistenceUtil.getCommandSessionFactory().openSession();
	        trans = session.beginTransaction();
		    session.save(register);
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

	public HourRegister getRegister() {
		return register;
	}

	public void setRegister(HourRegister register) {
		this.register = register;
	}
}
