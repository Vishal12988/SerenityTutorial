package com.studentapp.cucumber.serenity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.studentapp.model.StudentClass;
import com.studentapp.utils.ReusableSpecifications;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

public class StudentSerenitySteps {

	@WithTag("student feature:POSITIVE")
	@Step("Creating students with firstName{0}, lastName{1}, Email{2}, Programme{3}, cources{4}")
	public ValidatableResponse createStudent(String firstName,String lastName,String Email,String Programme,List<String> cources){
		
		StudentClass student = new StudentClass();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setProgramme(Programme);
		student.setStudentEmail(Email);
		student.setCources(cources);
		
		return SerenityRest.given()
		.spec(ReusableSpecifications.getGenericRequestSpec())
		.when()
		.body(student)
		.post()
		.then();
		
	}
	
	
  
   @Step("getting the student information by firstName:{0}") 
   public HashMap<String,Object> getStudentInfoByFirstName(String firstName){
	   
	    String p1 = "findAll{it.firstName=='";
		String p2 = "'}.get(0)";
		return SerenityRest.rest().given()
				.when()
				.get("/list")
				.then()
				.log()
				.all()
				.statusCode(200)
				.extract()
				.path(p1+firstName+p2);
		
   }
   @WithTag("student feature:NEGATIVE")
   @Step("Updating students information studentId{0,} firstName{1}, lastName{2}, Email{3}, Programme{4}, cources{5}")
	public ValidatableResponse updateStudent(int studentId,String firstName,String lastName,String Email,String Programme,List<String> cources){
		
		StudentClass student = new StudentClass();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setProgramme(Programme);
		student.setStudentEmail(Email);
		student.setCources(cources);
		
		return SerenityRest.given()
		.spec(ReusableSpecifications.getGenericRequestSpec())
		.when()
		.body(student)
		.put("/"+studentId)
		.then();
		
	}
		
  
   @Step("Delete Student Informatio:{0}")
   public void deleteStudent(int studentId){
	   SerenityRest
   	.rest()
   	.given()
   	.when()
   	.delete("/"+studentId);
   }
   
   @WithTag("student feature:POSITIVE")
		@Step("Getting Information of the student by Id:{0}")
		public ValidatableResponse getStudentById(int studentId){
			return SerenityRest
					.rest()
					.given()
					.when()
					.get("/"+studentId).then();
					
		}
		
	}

