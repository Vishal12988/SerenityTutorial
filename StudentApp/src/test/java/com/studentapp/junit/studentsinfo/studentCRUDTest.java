package com.studentapp.junit.studentsinfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matcher;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.ReusableSpecifications;
import com.studentapp.utils.TestUtils;

import groovyjarjarantlr.collections.List;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class studentCRUDTest extends TestBase {
	
	static String firstName = "vishal1";
	static String lastName = "bendre1";
	static String Programme = "Information Technology1";
	static String Email = TestUtils.getRandomValue()+"xyz@gmail.com";
	static int studentId;
	
    
	@Steps 
	StudentSerenitySteps steps;
	@Title("This test will create a new student")
	@Test
	
	public void test001(){
		ArrayList<String> cources = new ArrayList<String>();
		cources.add("JAVA");
		cources.add("C++");
		steps.createStudent(firstName, lastName, Email, Programme, cources)
		.statusCode(201)
		.spec(ReusableSpecifications.getGenericResponseSpec());
	
	}
	
	@Title("Following are the listed students")
	@Test
	
	public void test002(){
		
		HashMap<String,Object> value = steps.getStudentInfoByFirstName(firstName);
		
		assertThat(value,hasValue(firstName));
		studentId = (Integer) value.get("id");
	}
	
  private void assertThat(HashMap<String, Object> value, Matcher<Map<?, ? extends String>> hasValue) {
		// TODO Auto-generated method stub
		
	}
        @WithTag("student feature:NEGATIVE")
	    @Test
		public void test003(){
	
		firstName = firstName+"Updated";
		ArrayList<String> cources = new ArrayList<String>();
		steps.updateStudent(studentId, firstName, lastName, Email, Programme, cources);
		HashMap<String,Object> value = steps.getStudentInfoByFirstName(firstName);
		assertThat(value,hasValue(firstName));
	}
	    @WithTag("student feature:NEGATIVE")
        @Test
        public void test004(){
        	steps.deleteStudent(studentId);
        	steps.getStudentById(studentId)
        	.statusCode(404);
        }
	

}
