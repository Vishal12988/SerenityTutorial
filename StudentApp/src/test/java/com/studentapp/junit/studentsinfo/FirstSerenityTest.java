package com.studentapp.junit.studentsinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;



import cucumber.api.Pending;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Title;
@RunWith(SerenityRunner.class)

public class FirstSerenityTest {
	
	
	@BeforeClass 
	
	public static void init(){
		
		RestAssured.baseURI="http://localhost:8085/student";
	}
	
	
	@Test 
	public void getAllStudents(){
		
		//RestAssured.given()
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);
		
		
	}
	
	
	@Test 
	public void getAllStudentsFailTest(){
		
		//RestAssured.given()
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(500);
		
		
	}
	
	@Ignore
	@Test
	public void getAllStudentsPendingTest(){
		
	}
	
	@Ignore
	@Test 
	public void getAllStudentsSkippedTest(){
		
			
	}
	
	
	@Test 
	public void getAllStudentsErrorTest(){
		System.out.println("This is a Error"+ 5/0);
			
	}
	
	@Test 
	public void FileDoesNotExistt() throws FileNotFoundException{
		File file = new File("E://Test.txt");
			
		FileReader fr = new FileReader(file);
	}
	
	@Manual
	@Test 
	public void thisIsManualTest(){
		
	}
	
	@Title("This test will list name of all students")
	@Test
public void Test01(){
		
		//RestAssured.given()
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(500);
		
		
	}


}
