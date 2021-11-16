package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Departement implements Serializable {

	private static final long serialVersionUID = -357738161698377833L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@JsonIgnore
	@ManyToMany
	 private List<Employe> employes;

	@OneToMany(mappedBy = "departement")
	 private List<Mission> missions;

	@ManyToOne
	private Entreprise entreprise;

	public Departement() {
		super();
	}

	public Departement(String name) {
		this.name = name;
	}

	public Departement(DepartmentRequest dep) {
		this.name = dep.getName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

}
