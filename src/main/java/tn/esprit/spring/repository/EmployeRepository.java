package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Employe;



public interface EmployeRepository extends CrudRepository<Employe, Integer>  {
	
	
	@Query("SELECT count(*) FROM Employe")
    public int countemp();
	
    @Query("SELECT nom FROM Employe")
    public List<String> employeNames();
    
   /*@Query("Select "
			+ "DISTINCT emp from Employe emp "
			+ "join emp.departements dps "
			+ "join dps.entreprise entrep "
			+ "where entrep=:entreprise")
    
    */
    
    @Modifying
    @Transactional
    @Query("UPDATE Employe e SET e.email=:email1 where e.id=:employeId")
    public void mettreAjourEmailByEmployeIdJPQL(@Param("email1")String email, @Param("employeId")int employeId);

    
    
   
    
   
    
    
   
    		
   

}
