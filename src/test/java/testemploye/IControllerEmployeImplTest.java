package testemploye;
import org.junit.Test;
import tn.esprit.spring.services.*;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.controller.*;

public class IControllerEmployeImplTest {
	IControllerEmployeImpl iControllerEmployeImpl = new IControllerEmployeImpl();
	Employe e = new Employe();
	EmployeServiceImpl employeServiceImpl = new EmployeServiceImpl();

@Test
public void testAjouterEmploye () {

	e.setPrenom("xxx");
	e.setNom("dihek");
	e.setEmail("hamza.marwani@esprit.tn");
	e.setActif(true);
	Assert.assertNotNull("Name mustn't be null", e.getNom());
	employeServiceImpl.ajouterEmploye(e);
	
}

@Test
public void testMettreAjourEmailByEmployeId () {
	
	e.setNom("ali");
	e.setPrenom("mohamed");
	e.setEmail("hamza.marwani@esprit.tn");
	e.setActif(true);
	Assert.assertNotNull("email mustn't be null", e.getEmail());
	employeServiceImpl.mettreAjourEmailByEmployeId(null,1);
}
			
@Test
public void testDeleteEmployeById() {
	int employeById = 0 ;
	int c = e.getId();
	Assert.assertEquals(employeById,c);
	employeServiceImpl.deleteEmployeById(employeById);

	
}
@Test

 public void testGetNombreEmployeJPQL() {
	 
	int k = employeServiceImpl.getNombreEmployeJPQL();
 Assert.assertNotEquals(k, 0);

 }

 


	public void testGetEmployePrenomById()
	{
		int id = 0;
		int employeId = e.getId();
		Assert.assertEquals(employeId, id);
		employeServiceImpl.getEmployePrenomById(employeId);
		
	}

 public List<Employe>  testGetAllEmployes() {
	 
	return Collections.emptyList();

 }















































}


