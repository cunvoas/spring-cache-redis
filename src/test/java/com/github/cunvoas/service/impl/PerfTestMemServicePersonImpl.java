package com.github.cunvoas.service.impl;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.databene.contiperf.junit.ParallelRunner;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.cunvoas.bo.Person;
import com.github.cunvoas.service.ServicePerson;


/**
 * @author CUNVOAS
 * @see http://databene.org/contiperf
 * @see http://www.blog.project13.pl/index.php/coding/1077/runwith-junit4-with-both-springjunit4classrunner-and-parameterized/
 */
//@RunWith(ParallelRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
  "/spring-test.xml"
  , "/spring-cache-simple.xml"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PerfTestMemServicePersonImpl {
	
	//private TestContextManager testContextManager;
	
	@Autowired
	private ServicePerson servicePerson;
	
	@Rule
	public ContiPerfRule contiPerfRule = new ContiPerfRule();
	
//    @Before
//    public void setUpContext() throws Exception {
//        //this is where the magic happens, we actually do "by hand" what the spring runner would do for us,
//        // read the JavaDoc for the class bellow to know exactly what it does, the method names are quite accurate though
//        this.testContextManager = new TestContextManager(getClass());
//        this.testContextManager.prepareTestInstance(this);
//    }
    
	@Test
	@PerfTest(threads = 100, duration = 1000)
	@Required(max=800, average=500, median=400)
	public void test01_getPersonById_chkThread() {
		Person person = servicePerson.getPersonById(1);
		Assert.assertNotNull("getPersonById", person);
		cpt++;
	}
    
	@Test
	@PerfTest(threads = 200, duration = 2000)
	@Required(max=300, average=50, median=20)
	public void test02_getPersonById_flood() {
		Person person = servicePerson.getPersonById(1);
		Assert.assertNotNull("getPersonById", person);
	}
	
	private static volatile int cpt=0;
	@AfterClass
	public static void checkExec()  {
    	MatcherAssert.assertThat(" check calls", cpt, Matchers.greaterThan(100));
	}
}
