package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javassist.NotFoundException;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	public int ajouterEntreprise(Entreprise entreprise) {
		entrepriseRepoistory.save(entreprise);
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		deptRepoistory.save(dep);
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
		Optional<Entreprise> entrepriseManagedEntityOpt = entrepriseRepoistory.findById(entrepriseId);
		Optional<Departement> depManagedEntityOpt = deptRepoistory.findById(depId);
		if(entrepriseManagedEntityOpt.isPresent() && depManagedEntityOpt.isPresent()) {
			Entreprise entrepriseManagedEntity = entrepriseManagedEntityOpt.get();
			Departement depManagedEntity = depManagedEntityOpt.get();
			
			depManagedEntity.setEntreprise(entrepriseManagedEntity);
			deptRepoistory.save(depManagedEntity);
		}
		
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Optional<Entreprise> entrepriseManagedEntityOpt = entrepriseRepoistory.findById(entrepriseId);
		List<String> depNames = new ArrayList<>();
		if(entrepriseManagedEntityOpt.isPresent()) {
			Entreprise entrepriseManagedEntity = entrepriseManagedEntityOpt.get();
			
			for(Departement dep : entrepriseManagedEntity.getDepartements()){
				depNames.add(dep.getName());
			}
			
		}
		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		Optional<Entreprise> entOpt = entrepriseRepoistory.findById(entrepriseId);
		if(entOpt.isPresent()) {
			entrepriseRepoistory.delete(entOpt.get());	
		}
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		Optional<Departement> depOpt = deptRepoistory.findById(depId);
		if(depOpt.isPresent()) {
			deptRepoistory.delete(depOpt.get());
		}	
	}


	public Entreprise getEntrepriseById(int entrepriseId) throws NotFoundException {
		Optional<Entreprise> entOpt = entrepriseRepoistory.findById(entrepriseId);
		if(entOpt.isPresent()){
			return entOpt.get();
		}
		else {
			throw new NotFoundException("Object not found");
		}	
	}

}
