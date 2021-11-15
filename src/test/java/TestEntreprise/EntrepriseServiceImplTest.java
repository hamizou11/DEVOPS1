package TestEntreprise;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.EntrepriseServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {
	@Autowired
    private EntrepriseServiceImpl entrepriseService;
    @Autowired
    private DepartementRepository deparementrepos;
    private final static Logger l = LogManager.getLogger(EntrepriseServiceImplTest.class);

    public EntrepriseServiceImplTest() {
        super();

    }
    @Test
    public  void ajouterEntreprise() {
        Entreprise entreprise = new Entreprise();
        entreprise.setId(3);
        entreprise.setName("entreprise1");
        entreprise.setRaisonSocial("raison1");
        Assertions.assertEquals(3, entreprise.getId());
        entrepriseService.ajouterEntreprise(entreprise);
        l.info("l'entreprise est ajouter");

    }
    //  @Test
    public    void getEntrepriseById() {
        int entrepriseId = 2;
        l.info("l'estreprise est : " + entrepriseService.getEntrepriseById(entrepriseId));

    }


    @Test
    public void affecterDepartementAEntreprise() {

        Departement departement=new Departement();
        departement.setName("dep1");
        deparementrepos.save(departement) ;
        Entreprise entreprise = new Entreprise();
        entreprise.setName("entreprise1");
        entreprise.setRaisonSocial("raison1");
        entrepriseService.ajouterEntreprise(entreprise) ;
//
        entrepriseService.affecterDepartementAEntreprise(departement.getId(),entreprise.getId());
        Assertions.assertNotEquals(departement.getId(), entreprise.getId());

        l.info("l'entreprise qui a l'id: " + entreprise.getId() + " est affecté au département avec l'id : " + departement.getId());
    }

    // @Test
    public void getEntrepriseByIdA() {
        Entreprise Entreprise= entrepriseService.getEntrepriseById(3);
        assertThat(Entreprise.getId()).isEqualTo(3);
        l.info("l'entreprise est" +entrepriseService.getEntrepriseById(3));

    }

    //	@Test
    public void DeleteEntreprise() {
        entrepriseService.deleteEntrepriseById(4);
        l.info("L'entreprise est supprimé");
    }

}
