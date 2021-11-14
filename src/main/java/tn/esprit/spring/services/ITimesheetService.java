package tn.esprit.spring.services;

import java.util.Date;

import tn.esprit.spring.entities.Mission;



public interface ITimesheetService {
	
	public int ajouterMission(Mission mission);
	public void affecterMissionADepartement(int missionId, int depId);
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin);
	
}
