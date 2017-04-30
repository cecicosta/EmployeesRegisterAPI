package com.hib.init;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.hib.entities.Employee;
import com.hib.entities.HourRegister;

public class DataAccessHelper {
	
	public static Employee getEmployee(String id) throws Exception{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee e = (Employee) session.get(Employee.class, id);		
		session.close();
		if(e == null)
			throw new Exception("Id not found.");
		return e;
	}
	@SuppressWarnings("unchecked")
	public static List<Employee> getEmployees(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Employee> e = (session.createCriteria(Employee.class).list());
		session.close();
		return e;
	}
	@SuppressWarnings("unchecked")
	public static List<Employee> getEmployeesByName(String name){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Employee> list = session.createCriteria(Employee.class)
				.add(Restrictions.eq("name", name)).list();	
		session.close();
		return list;
	}
	public static String getEmployeeDecryptedPass(String id) throws Exception{
		return new String(Base64.decodeBase64(getEmployeeEncryptedPass(id)));
	}
	public static String getEmployeeEncryptedPass(String id) throws Exception{
		return getEmployee(id).getEncryptedPass();
	}
	
	public static void registerNewEmployee(Employee employee)throws Exception {
		Session session = null;
	    Transaction trans = null;
		try{
		    session = HibernateUtil.getSessionFactory().openSession();
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
	
	public static List<HourRegister> getEmployeeRegisters(String id) throws Exception{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee emp =  (Employee) session.get(Employee.class, id);
		if(emp == null)
			throw new Exception("Id not found");
		Iterator<HourRegister> iterator = emp.getRegisters().iterator();
		ArrayList<HourRegister> list = new ArrayList<HourRegister>();
		while(iterator.hasNext())
			list.add(iterator.next());
		session.close();
		return list;
	}
	public static HourRegister getRegister(Integer id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		HourRegister r = (HourRegister) session.get(HourRegister.class, id);		
		session.close();
		return r;		
	}
	public static void submitNewRegister(HourRegister register) throws HibernateException {
		Session session = null;
	    Transaction trans = null;
		try{
		    session = HibernateUtil.getSessionFactory().openSession();
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
				throw new HibernateException("Failed to save entity on database.");
			}
			session.flush();
			session.close();
		}
	}
}
