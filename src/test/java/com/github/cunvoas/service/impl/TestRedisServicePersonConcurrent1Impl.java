package com.github.cunvoas.service.impl;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
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
  , "/spring-cache-redis.xml"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRedisServicePersonConcurrent1Impl {
	
	@Autowired
	private ServicePerson servicePerson;

	private Person testPerson;
	
	@Before
	public void init() {
		testPerson = new Person();
		testPerson.setId(3);
	}
	
	public void test00_Clear() {
		servicePerson.delete(testPerson);
		
	}
	
	@Test
	public void test01_GetPersonById() {
		long start = System.nanoTime();
		Person person = servicePerson.getPersonById(3);
		long stop = System.nanoTime();
		Assert.assertNotNull("get(1)", person);
		Assert.assertEquals("name", "UNVOAS", person.getLastname());
		
		double aa = (stop-start)/1E6;
		int durationMs = Double.valueOf(aa).intValue();
		MatcherAssert.assertThat(" first call", durationMs, Matchers.greaterThan(400));
		
		long startC = System.nanoTime();
		person = servicePerson.getPersonById(3);
		long stopC = System.nanoTime();
		
		double aaC = (stopC-startC)/1E6;
		int durationMsC = Double.valueOf(aaC).intValue();
		MatcherAssert.assertThat(" second ", durationMsC, Matchers.lessThan(50));
	}


}
