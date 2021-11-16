package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
	EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;

	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);

	public int ajouterEntreprise(Entreprise entreprise) {
		l.info("in ajouter Entreprise");

		entrepriseRepoistory.save(entreprise);
		l.info("out ajouter Entreprise");
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		l.info("in ajouter Departement");
		deptRepoistory.save(dep);
		l.info("out ajouter Department");
		return dep.getId();
	}

	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		// Le bout Master de cette relation N:1 est departement
		// donc il faut rajouter l'entreprise a departement
		// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
		// Rappel : la classe qui contient mappedBy represente le bout Slave
		// Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.

		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).orElse(null);
		Departement depManagedEntity = deptRepoistory.findById(depId).orElse(null);
		if (depManagedEntity != null) {
			l.info("in affecter department a entreprise");
			l.debug("Je vais commencer l'affectation");
			depManagedEntity.setEntreprise(entrepriseManagedEntity);
			

			deptRepoistory.save(depManagedEntity);
			l.info("out affecter department a entreprise");
		}
		l.error("Erreur:Null pointer");

	}

	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		List<String> liste = new ArrayList<>();

		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).orElse(null);
		if (entrepriseManagedEntity == null) {
			l.error("Erreur:Null pointer");
			return liste;
			
		}
		List<String> depNames = new ArrayList<>();
		for (Departement dep : entrepriseManagedEntity.getDepartements()) {
			l.info("in getAllDepartementsNamesByEntreprise");
			l.debug("Je vais commencer l'affichage de chaque chaque");
			depNames.add(dep.getName());
		}
		l.info("out getAllDepartementsNamesByEntreprise");
		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		l.info("in delete entreprise");
		entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).orElse(null));
		l.info("out delete entreprise");
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		l.info("in delete departement");
		deptRepoistory.delete(deptRepoistory.findById(depId).orElse(null));
		l.info("out delete departement");
	}

	@Override
	public Entreprise getEntrepriseById(int entrepriseId) {
		l.info("In get entreprise");
		Entreprise e = entrepriseRepoistory.findById(entrepriseId).orElse(null);
		l.info("out getEntreprise with success");
		return e;
	}

}
