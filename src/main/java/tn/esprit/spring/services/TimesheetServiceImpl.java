package tn.esprit.spring.services;

import java.util.Date;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class TimesheetServiceImpl implements ITimesheetService {
	

	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	EmployeRepository employeRepository;
	
	public static final Logger logger = Logger.getLogger(TimesheetServiceImpl.class);
	
	public int ajouterMission(Mission mission) {
		logger.info("Adding a new mission : ");
		missionRepository.save(mission);
		logger.debug("Mission "+mission.getId()+" added!");
		return mission.getId();
	}
    
	public void affecterMissionADepartement(int missionId, int depId) {
		logger.info("Begin affect mission to department : ");
		Optional<Mission> mission = missionRepository.findById(missionId);
		Optional<Departement> dep = deptRepoistory.findById(depId);
		logger.info("Checking if mission and department exist ...");
		if(mission.isPresent() && dep.isPresent()) {
			logger.info("Mission and department exist.");
			Mission missionVal = mission.get();
			Departement depVal = dep.get();
			missionVal.setDepartement(depVal);
			missionRepository.save(missionVal);
			logger.info("Mission affected to department successfully.");
		} else {
			logger.error("Mission or department not found !");
		}
		
	}

	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		logger.info("Begin adding timesheet : ");
		TimesheetPK timesheetPK = new TimesheetPK();
		timesheetPK.setDateDebut(dateDebut);
		timesheetPK.setDateFin(dateFin);
		timesheetPK.setIdEmploye(employeId);
		timesheetPK.setIdMission(missionId);
		
		Timesheet timesheet = new Timesheet();
		timesheet.setTimesheetPK(timesheetPK);
		timesheet.setValide(false); //par defaut non valide
		timesheetRepository.save(timesheet);
		
	}

}
