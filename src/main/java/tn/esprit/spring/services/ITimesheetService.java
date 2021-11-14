package tn.esprit.spring.services;

import java.util.Date;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;



public interface ITimesheetService {
	
	public int ajouterMission(Mission mission);
	public boolean affecterMissionADepartement(int missionId, int depId);
	public Timesheet ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin);
	
}
