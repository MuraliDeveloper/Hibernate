package com.dao.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.dao.Employee;
import com.dao.HibernateUtil;

/**
Get 1st 20 results  employees
solution:
use 
setMaxResults() --> how many rows to fetch
setFirstResult() --> from which row number

Case#1 : fetch 1st 20 rows 
       setFirstResult(0);
	   setMaxResults(20);

Case#2 : fetch 20 rows by skipping 10 rows
      setFirstResult(10);
	   setMaxResults(20); 

Case#3 : fetch 30 rows by skipping 15 rows
      setFirstResult(15);
	   setMaxResults(30);	   
	   
*/


public class TestCriteria2 {

	public static void main(String[] args) {
		  //get session obj
				Session  s = HibernateUtil.getSessionFactory().openSession();
		    
		    //get criteria obj
		    Criteria c1 = s.createCriteria(Employee.class);
				
			
		    c1.setFirstResult(10); // from which row number , skip 10 rows
		    c1.setMaxResults(20);// how many rows
		    
		  //call list method
		  	List<Employee> list = c1.list();
		  	System.out.println(list.size());
			  for(Employee e: list){
					System.out.println(e);
				}
		    
		    //close session
			s.close();	

		}
}

/*
	
//input from customer
String name = "";
int minSal =0;
int maxSal =0;
String nameLike = "user";


if(name!=null && !name.equals("")){
	c1.add(Restrictions.eq("userName", name));// where userName = name
}

if(nameLike!=null && !nameLike.equals("")){
	c1.add(Restrictions.like("userName", "%"+name+"%"));
	// 	where userName like '%user%';
}
if(minSal!=0 && maxSal!=0){
	c1.add(Restrictions.between("usersalary", minSal, maxSal));
	//userSalary >= minSal and userSalary<= maxSal
}


*/
