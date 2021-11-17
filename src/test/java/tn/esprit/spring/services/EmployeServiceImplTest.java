package tn.esprit.spring.services;

import java.text.ParseException;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EmployeServiceImplTest
{
	@Autowired 
IEmployeService es;
private static final Logger l = LogManager.getLogger(EmployeServiceImplTest.class);
@Test
@Order(2)

	 public void testRetrieveAllUser()
	{
		List<Employe> listEmployes = es.retrieveAllEmployes();
     //  Assertions.assertEquals(4, listEmployes.size());
	}
@Test
@Order(1)
	public void testAddEmploye() throws ParseException
	{

	Employe e = new Employe("ok","Hawel","aya.hawel@esprit.tn","Esprit2021",true,Role.INGENIEUR);
	Employe userAdded = es.addEmploye(e);
   // Assertions.assertEquals(33, userAdded.getId());
	
	

	}
	
@Test
@Order(3)
	public void testUpdateEmploye() throws ParseException{
	
	Employe e = new Employe(9,"ok","Hawel","aya.hawel@esprit.tn","Esprit021",true,Role.INGENIEUR);
	Employe employeupdated = es.updateEmploye(e);
    //Assertions.assertEquals(9, employeupdated.getId());
    


	 
	}
@Test
@Order(4)
	public void testDeleteEmploye() throws ParseException
	{
     //es.deleteEmploye("11");
    //Assertions.assertNotEquals(11,es.retrieveEmploye("11"));
    
    


	 
	
	
	}
}