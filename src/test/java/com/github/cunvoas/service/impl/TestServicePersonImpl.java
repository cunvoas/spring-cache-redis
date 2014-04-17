package com.github.cunvoas.service.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.cunvoas.bo.Person;
import com.github.cunvoas.service.ServicePerson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
  "/spring-test.xml"
  , "/spring-cache.xml"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServicePersonImpl {
	
	@Autowired
	private ServicePerson servicePerson;
	
	private Person testPerson;
	
	@Before
	public void init() {
		testPerson = new Person();
		testPerson.setId(9999);
	}

	@Test
	public void test01_GetPersonById() {
		Person person = servicePerson.getPersonById(1);
		Assert.assertNotNull("get(1)", person);
		Assert.assertEquals("name", "UNVOAS", person.getLastname());
	}

	@Test
	public void test02_SaveListOfPerson() {
		List<Person> resList = servicePerson.findByLastnameLike("VOA");
		
		servicePerson.save(resList);
		
		resList = servicePerson.findByLastnameLike("VOA");
		Assert.assertEquals("findByLastnameLike size", 3, resList.size());
		
	}

	@Test
	public void test03_FindByLastnameLike() {
		List<Person> resList = servicePerson.findByLastnameLike("VOA");

		Assert.assertNotNull("findByLastnameLike", resList);
		Assert.assertEquals("findByLastnameLike size", 3, resList.size());
	}
	
	@Test
	public void test04_SavePerson() {
		servicePerson.save(testPerson);
		
		Person person = servicePerson.getPersonById(9999);
		Assert.assertEquals("persisted" , testPerson, person);
	}

	@Test
	public void test05_Delete() {
		servicePerson.delete(testPerson);
		Person person = servicePerson.getPersonById(9999);
		Assert.assertNull("deleted", person);
	}

}
