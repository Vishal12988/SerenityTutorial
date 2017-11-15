package com.studentapp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentClass {

		
		private String FirstName;
		private String LastName;
		private String Programme;
		private String studentEmail;
		private List<String> cources;
		
	 
		public String getFirstName() {
			return FirstName;
		}
		public void setFirstName(String FirstName) {
			this.FirstName = FirstName;
		}
		
		public String getLastName() {
			return LastName;
		}
		public void setLastName(String LastName) {
			this.LastName = LastName;
		}
		
		public String getProgramme() {
			return Programme;
		}
		public void setProgramme(String Programme) {
			this.Programme = Programme;
		}
		public String getStudentEmail() {
			return studentEmail;
		}
		public void setStudentEmail(String studentEmail) {
			this.studentEmail = studentEmail;
		}
		
		public List<String> getCources() {
			  return Collections.unmodifiableList(cources);
			}	
		public void setCources(ArrayList<String> cources) {
			  this.cources = cources;
			}
		public void setCources(List<String> cources2) {
			// TODO Auto-generated method stub
			
		}
		
		
}
