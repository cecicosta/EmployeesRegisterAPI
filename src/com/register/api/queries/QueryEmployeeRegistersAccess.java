package com.register.api.queries;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.register.api.entities.Employee;
import com.register.api.entities.HourRegister;
import com.register.api.persistence.PersistenceUtil;

public class QueryEmployeeRegistersAccess {
	
	public static Employee getEmployeeByCode(String id) throws Exception{
		Session session = PersistenceUtil.getCommandSessionFactory().openSession();
		Employee e = (Employee) session.createCriteria(Employee.class).
				add(Restrictions.eq("employeeId", id)).uniqueResult();		
		session.close();
		if(e == null)
			throw new Exception("Id not found.");
		return e;
	}
	@SuppressWarnings("unchecked")
	public static List<Employee> getEmployees(){
		Session session = PersistenceUtil.getCommandSessionFactory().openSession();
		List<Employee> e = (session.createCriteria(Employee.class).list());
		session.close();
		return e;
	}
	@SuppressWarnings("unchecked")
	public static List<Employee> getEmployeesByName(String name){
		Session session = PersistenceUtil.getCommandSessionFactory().openSession();
		List<Employee> list = session.createCriteria(Employee.class)
				.add(Restrictions.eq("name", name)).list();	
		session.close();
		return list;
	}
	public static String getEmployeeDecryptedPass(String id) throws Exception{
		return new String(Base64.decodeBase64(getEmployeeEncryptedPass(id)));
	}
	public static String getEmployeeEncryptedPass(String id) throws Exception{
		return getEmployeeByCode(id).getEncryptedPass();
	}
	
	public static List<HourRegister> getEmployeeRegisters(String id) throws Exception{
		Session session = PersistenceUtil.getCommandSessionFactory().openSession();
		Employee emp = (Employee) session.createCriteria(Employee.class).
				add(Restrictions.eq("employeeId", id)).uniqueResult();	
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
		Session session = PersistenceUtil.getCommandSessionFactory().openSession();
		HourRegister r = (HourRegister) session.get(HourRegister.class, id);		
		session.close();
		return r;		
	}

}
