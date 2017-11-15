package com.studentapp.junit.studentsinfo;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
@UseTestDataFrom("Users/bendrev/workspace/StudentApp/src/test/resources/testdata/studentinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentsDataDrivenTest extends TestBase {
	
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getProgramme() {
		return programme;
	}
	public void setProgramme(String programme) {
		this.programme = programme;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCource() {
		return cource;
	}
	public void setCource(String cource) {
		this.cource = cource;
	}
	public StudentSerenitySteps getSteps() {
		return steps;
	}
	public void setSteps(StudentSerenitySteps steps) {
		this.steps = steps;
	}
	private String lastName;
	private String programme;
	private String Email;
	private String cource;
	
	@Steps
	StudentSerenitySteps steps;
	@Title("Data Driven Test for Adding Multiple students to the students app")
	@Test
	public void createMultipleStudents(){
		ArrayList<String> cources = new ArrayList<String>();
		cources.add(cource);
		steps.createStudent(firstName, lastName, Email, programme, cources)
		.statusCode(201);
	}

}
