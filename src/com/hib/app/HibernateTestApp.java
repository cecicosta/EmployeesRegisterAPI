package com.hib.app;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.Session;

import com.hib.entities.Employee;
import com.hib.entities.HourRegister;
import com.hib.init.HibernateUtil;

public class HibernateTestApp
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Employee employee = new Employee();

        employee.setName("Cesar");
        employee.setEncryptedPass("123456");
        
        HourRegister reg = new HourRegister();
        reg.setEmployeeId(1);
        reg.setTime(Date.valueOf(LocalDate.now().toString()));

        session.save(reg);
        session.save(employee);
        session.getTransaction().commit();
    }
}