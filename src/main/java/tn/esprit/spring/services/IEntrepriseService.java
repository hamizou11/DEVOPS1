package tn.esprit.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;

@Service
public interface IEntrepriseService {

	public int ajouterEntreprise(Entreprise entreprise);

	public int ajouterDepartement(Departement dep);

	void affecterDepartementAEntreprise(int depId, int entrepriseId);

	List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);

	public void deleteEntrepriseById(int entrepriseId);

	public void deleteDepartementById(int depId);

	public Entreprise getEntrepriseById(int entrepriseId);
}
