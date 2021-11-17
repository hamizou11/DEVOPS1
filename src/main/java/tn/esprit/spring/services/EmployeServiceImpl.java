package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@Service

public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;

	// TODO Logger à ajouter  
	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);
	

	@Override
	public List<Employe> retrieveAllEmployes() { 
		List<Employe> employes = null; 
		try {
	
			// TODO Log à ajouter en début de la méthode 
			l.info("In Method retriveAllEmployes");
			employes = (List<Employe>) employeRepository.findAll(); 
			l.info("Employes");
			l.debug("Connsxion Bd");


			for (Employe employe : employes) {
				l.info("Employe"+employe.getNom());
			} 
			l.info("out with succes");

		}catch (Exception e) {
l.error("out of method with erro"+e);		}

		return employes;
	}


	@Override
	public Employe addEmploye(Employe e) {
		l.info("In Method addEmploye");
		Employe e_saved = employeRepository.save(e); 
		l.info("out with succes of  method addEmploye");
		return e_saved; 
	}

	@Override 
	public Employe updateEmploye(Employe  e) { 
		l.info("In Method updateEmploye");	
		Employe e_saved = employeRepository.save(e); 
		l.info("out with succes of  updateEmploye");	
		return e_saved; 
	}

	@Override
	public void deleteEmploye(String id) {
		l.info("In Method deleteEmploye");
		l.info(id);
		employeRepository.deleteById(Integer.parseInt(id));
		l.info("out with succes deleteEmploye ");	

	}

	@Override
	public Employe retrieveEmploye(String id) {
		l.info("In Method retrieveEmploye");	
		Employe e =  employeRepository.findById(Integer.parseInt(id)).get(); 
		l.info("Out Method retrieveEmploye");	
		return e; 
	}

}

