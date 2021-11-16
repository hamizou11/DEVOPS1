package TestEntreprise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.List;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.EntrepriseServiceImpl;
import tn.esprit.spring.services.IEntrepriseService;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = EntrepriseServiceImpl.class)
public class EntrepriseServiceImplTest {
	@Autowired
	private IEntrepriseService entrepriseService;
	@Autowired
	private DepartementRepository deparementrepos;
	private final static Logger l = LogManager.getLogger(EntrepriseServiceImplTest.class);

	public EntrepriseServiceImplTest() {
		super();

	}

	@Test
	public void ajouterEntreprise() {
		Entreprise entreprise = new Entreprise();
		// entreprise.setId(3);
		entreprise.setName("entreprise1");
		entreprise.setRaisonSocial("raison1");
		Assertions.assertEquals("entreprise1", entreprise.getName());
		entrepriseService.ajouterEntreprise(entreprise);
		l.info("l'entreprise est ajouté");

	}

	// @Test
	public void getEntrepriseById() {
		int entrepriseId = 2;
		l.info("l'estreprise est : " + entrepriseService.getEntrepriseById(entrepriseId));

	}

	@Test
	public void affecterDepartementAEntreprise() {

		Departement departement = new Departement();
		departement.setName("dep1");
		deparementrepos.save(departement);
		Entreprise entreprise = new Entreprise();
		entreprise.setName("entreprise1");
		entreprise.setRaisonSocial("raison1");
		entrepriseService.ajouterEntreprise(entreprise);
		entrepriseService.affecterDepartementAEntreprise(departement.getId(), entreprise.getId());
		Assertions.assertNotEquals(departement.getId(), entreprise.getId());

		l.info("l'entreprise qui a l'id: " + entreprise.getId() + " est affecté au département avec l'id : "
				+ departement.getId());
	}

	@Test
	public void getEntrepriseByIdA() {
		Entreprise Entreprise = entrepriseService.getEntrepriseById(3);
		assertEquals(3, Entreprise.getId());
		l.info("l'entreprise est" + entrepriseService.getEntrepriseById(3));

	}

	@Test
	public void DeleteEntreprise() {
		entrepriseService.deleteEntrepriseById(4);
		l.info("L'entreprise est supprimé");
	}

	@Test
	public void ajouterDepartement() {
		Departement dep = new Departement();
		dep.setName("d2");
		Assertions.assertEquals("d2", dep.getName());
		deparementrepos.save(dep);
		l.info("le departement est ajouter");

	}

	@Test
	public void deleteDepartementById() {
		deparementrepos.deleteById(2);

		l.info("Le departement est supprimé");
	}

	@Test public void getAllDepartementsNamesByEntreprise() { 
	
		int entrepriseId = 2;
		l.info("les noms de departements : " + entrepriseService.getAllDepartementsNamesByEntreprise(entrepriseId));
	  
	  }

}
