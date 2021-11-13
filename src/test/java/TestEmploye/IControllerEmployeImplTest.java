package TestEmploye;
import org.junit.Assert;
import org.junit.Test;

import tn.esprit.spring.controller.IControllerEmployeImpl;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.EmployeServiceImpl;
public class IControllerEmployeImplTest {
	private static final Object EmployeById = null;
	IControllerEmployeImpl IControllerEmployeImpl = new IControllerEmployeImpl();
	Employe e = new Employe();
	EmployeServiceImpl EmployeServiceImpl = new EmployeServiceImpl();
	
	
@Test
public void testAjouterEmploye () {

	e.setPrenom("xxx");
	e.setNom("dihek");
	e.setEmail("dihek.missaoui@gmail.com");
	e.setActif(true);
	Assert.assertNotNull("Name mustn't be null", e.getNom());
	
	EmployeServiceImpl.ajouterEmploye( e);
	
	//IControllerEmployeImpl.ajouterEmploye(e);


}
@Test

public void testMettreAjourEmailByEmployeId () {
	
	e.setNom("ali");
	e.setPrenom("mohamed");
	e.setEmail("dihek.missaoui@gmail.com");
	e.setActif(true);
	Assert.assertNotNull("email mustn't be null", e.getEmail());
	EmployeServiceImpl.mettreAjourEmailByEmployeId(null,1);
}
@Test
			

public void testDeleteEmployeById() {
	int EmployeById = 0 ;
	int c = e.getId();
	Assert.assertEquals(EmployeById,c);
	EmployeServiceImpl.deleteEmployeById(EmployeById);

	
}

 

 @Test


	public void testGetEmployePrenomById()
	{
		int id = 0;
		int employeId = e.getId();
		Assert.assertEquals(employeId, id);
		EmployeServiceImpl.getEmployePrenomById(employeId);
		
	}

 














































}


