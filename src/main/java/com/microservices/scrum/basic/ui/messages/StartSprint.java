package com.microservices.scrum.basic.ui.messages;

public class StartSprint {

	private int projectId;
	
	private int noDays;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getNoDays() {
		return noDays;
	}

	public void setNoDays(int noDays) {
		this.noDays = noDays;
	}
	
	
	
}
