package com.TalentStreamApp.Entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class XClassDetails {
	 private String xschoolName;
	    private String xboard;
	    private String xpercentage;
	    private String xyearOfPassing;
	    private String xcity;
	    private String xstate;
	    private String xpincode;
		public String getXschoolName() {
			return xschoolName;
		}
		public void setXschoolName(String xschoolName) {
			this.xschoolName = xschoolName;
		}
		public String getXboard() {
			return xboard;
		}
		public void setXboard(String xboard) {
			this.xboard = xboard;
		}
		public String getXpercentage() {
			return xpercentage;
		}
		public void setXpercentage(String xpercentage) {
			this.xpercentage = xpercentage;
		}
		public String getXyearOfPassing() {
			return xyearOfPassing;
		}
		public void setXyearOfPassing(String xyearOfPassing) {
			this.xyearOfPassing = xyearOfPassing;
		}
		public String getXcity() {
			return xcity;
		}
		public void setXcity(String xcity) {
			this.xcity = xcity;
		}
		public String getXstate() {
			return xstate;
		}
		public void setXstate(String xstate) {
			this.xstate = xstate;
		}
		public String getXpincode() {
			return xpincode;
		}
		public void setXpincode(String xpincode) {
			this.xpincode = xpincode;
		}
		
}
