package tn.esprit.spring.services;


import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;


import tn.esprit.spring.repository.EmployeRepository;


@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;
	

	private static final Logger logger = Logger.getLogger(EmployeServiceImpl.class);
	
	
	public int ajouterEmploye(Employe employe) {
		try {
			logger.info("ajouter employer ");
			logger.debug("je vais ajouter un employé");
			employeRepository.save(employe);

			logger.debug("je vien ajouter un employé");
			logger.info("employe ajouter sont erreur");
			
			
		}
		 catch (Exception e) {logger.error("Erreur : " + e);}
	
		return employe.getId();
	}

	
	
	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		Employe x = new Employe ();
		try {
		logger.info("employe existe");	
		logger.debug("mis a jour mail");
		Optional<Employe> y = employeRepository.findById(employeId) ;
		if (y.isPresent())
		{
			x = y.get();
		}
		
	    
		x.setEmail(email);
		logger.info("mis a jour mail avec Succès");
	
		employeRepository.save(x);
		logger.info("mis a jour sans erreur");
		}catch (Exception e) {
			logger.error("Erreur avec la  mis a jour   email " +e);
		}
	}

	

	


	
		public String getEmployePrenomById(int employeId) {
			
				Employe x = new Employe();
				try{
					logger.info("affichage d'une employe par id : ");
					logger.debug("entrain d'afficher employe : ");
					
					
					Optional<Employe> y = employeRepository.findById(employeId) ;
					if (y.isPresent())
					{
						x = y.get();
					}
										
					logger.debug("je viens d'afficher employe: ");
					logger.info("affichage sans erreurs " );
				}
				catch(Exception e){
					logger.error("Erreur dans l'affichage de employe: "+e);
				}finally{
					logger.info("Methode affichage");
			
				
				
			
				}
			return x.getPrenom();
		}
		
		
		
		
	public void deleteEmployeById(int employeId)
	
	{ 
		Employe employe = new Employe ();
		try {
		logger.info("suppression d'un employe ");
		logger.debug("selection du emoloye a supprimé");
		
		Optional<Employe> y = employeRepository.findById(employeId) ;
		if (y.isPresent())
		{
		
			
			for(Departement dep : employe.getDepartements()){
				dep.getEmployes().remove(employe);
			}
		}
		
		

		//Desaffecter l'employe de tous les departements
		//c'est le bout master qui permet de mettre a jour
		//la table d'association
		
		logger.debug("suppression de employe ");
		employeRepository.delete(employe);
		logger.debug("je viens de supprimer un employe");
		logger.info("suppression without errors");
	}
		
	catch(Exception e){
		logger.error("Erreur dans l'affectation du employe : "+e);
	}
	}



	public int getNombreEmployeJPQL() {
		int i =0 ;
		try {
			
		logger.info("il existe des employe ? ");
		logger.debug("afficher nombre des employe");
		 i = employeRepository.countemp();
				}catch (Exception e) {
			logger.error("il n'existe aucun employer pour le moment ");
				}
			return i ;
	
		
	}



	
	

	

	






	






}
