package com.TalentStreamApp.Entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class IntermediateDetails {
	 private String icollegeName;
	    private String iboard;
	    private String iprogram;
	    private String ipercentage;
	    private String iyearOfPassing;
	    private String icity;
	    private String istate;
		public String getIcollegeName() {
			return icollegeName;
		}
		public void setIcollegeName(String icollegeName) {
			this.icollegeName = icollegeName;
		}
		public String getIboard() {
			return iboard;
		}
		public void setIboard(String iboard) {
			this.iboard = iboard;
		}
		public String getIprogram() {
			return iprogram;
		}
		public void setIprogram(String iprogram) {
			this.iprogram = iprogram;
		}
		public String getIpercentage() {
			return ipercentage;
		}
		public void setIpercentage(String ipercentage) {
			this.ipercentage = ipercentage;
		}
		public String getIyearOfPassing() {
			return iyearOfPassing;
		}
		public void setIyearOfPassing(String iyearOfPassing) {
			this.iyearOfPassing = iyearOfPassing;
		}
		public String getIcity() {
			return icity;
		}
		public void setIcity(String icity) {
			this.icity = icity;
		}
		public String getIstate() {
			return istate;
		}
		public void setIstate(String istate) {
			this.istate = istate;
		}
		
	
}
