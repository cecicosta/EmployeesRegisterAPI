package com.hib.app;

import java.util.List;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import com.hib.entities.Employee;
import com.hib.entities.HourRegister;
import com.hib.init.HibernateUtil;

public class HibernateTestApp
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee emp =  (Employee) session.get(Employee.class, "00001");
        HourRegister reg = (HourRegister) emp.getRegisters().toArray()[0];
        System.out.println(reg.getTime().toString());
        /*
        session.beginTransaction();
        Employee employee = new Employee("00001", "Ceci", "123456");
        	
        
        //Criteria crit = session.createCriteria(HourRegister.class);
        //crit.add( Restrictions.eq("employeeId", 1));
        //List<HourRegister> list = crit.list();;
        
        HourRegister reg = new HourRegister(Date.valueOf(LocalDate.now().toString()), employee);


        session.save(reg);
        session.save(employee);
        session.getTransaction().commit();
        */
    }
}