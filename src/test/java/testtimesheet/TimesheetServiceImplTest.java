package testtimesheet;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.services.TimesheetServiceImpl;

public class TimesheetServiceImplTest {
	
	TimesheetServiceImpl timesheetServiceImpl = new TimesheetServiceImpl();
	Mission mission = new Mission();
	Departement departement = new Departement();
	Employe employe = new Employe();
	Timesheet timesheet = new Timesheet();

	@Test
	public void testAjouterMission() {
		departement.setId(100);
		departement.setName("Name_Departement");
		
		mission.setId(100);
		mission.setName("Name");
		mission.setDescription("Description");
		mission.setDepartement(departement);
		
		assertEquals(100, mission.getDepartement().getId());
		assertEquals(100, timesheetServiceImpl.ajouterMission(mission));
	}
	
	@Test
	public void testAffecterMissionADepartement() {
		mission.setId(100);
		departement.setId(100);
		assertEquals(true, timesheetServiceImpl.affecterMissionADepartement(mission.getId(), departement.getId()));
	}
	
	@Test
	public void testAjouterTimesheet() {
		employe.setId(100);
		mission.setId(100);
		Date dateDebut = new Date(1);
		Date dateFin = new Date(10);
		
		Timesheet res = timesheetServiceImpl.ajouterTimesheet(mission.getId(), employe.getId(), dateDebut, dateFin);
		
		assertEquals(100, res.getMission().getId());
		assertEquals(100, res.getEmploye().getId());
		assertEquals(dateDebut, res.getTimesheetPK().getDateDebut());
		assertEquals(dateFin, res.getTimesheetPK().getDateFin());
	}

}
