package com.TalentStreamApp.Entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class GraduationDetails {
	private String gcollegeName;  
	 private String gboard;        
	 private String gprogram;      
	 private String gpercentage;   
	 private String gyearOfPassing;
	 private String gcity;        
	 private String gstate;
	public String getGcollegeName() {
		return gcollegeName;
	}
	public void setGcollegeName(String gcollegeName) {
		this.gcollegeName = gcollegeName;
	}
	public String getGboard() {
		return gboard;
	}
	public void setGboard(String gboard) {
		this.gboard = gboard;
	}
	public String getGprogram() {
		return gprogram;
	}
	public void setGprogram(String gprogram) {
		this.gprogram = gprogram;
	}
	public String getGpercentage() {
		return gpercentage;
	}
	public void setGpercentage(String gpercentage) {
		this.gpercentage = gpercentage;
	}
	public String getGyearOfPassing() {
		return gyearOfPassing;
	}
	public void setGyearOfPassing(String gyearOfPassing) {
		this.gyearOfPassing = gyearOfPassing;
	}
	public String getGcity() {
		return gcity;
	}
	public void setGcity(String gcity) {
		this.gcity = gcity;
	}
	public String getGstate() {
		return gstate;
	}
	public void setGstate(String gstate) {
		this.gstate = gstate;
	}
	
	 
}
