package com.github.cunvoas.service.impl;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
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
public class TestRedisServicePersonConcurrent2Impl {
	
	@Autowired
	private ServicePerson servicePerson;

	
	@Test
	public void test01_GetPersonById() {
		
		long startC = System.nanoTime();
		Person person = servicePerson.getPersonById(3);
		long stopC = System.nanoTime();
		
		double aaC = (stopC-startC)/1E6;
		int durationMsC = Double.valueOf(aaC).intValue();
		MatcherAssert.assertThat(" second ", durationMsC, Matchers.lessThan(50));
	}


}
