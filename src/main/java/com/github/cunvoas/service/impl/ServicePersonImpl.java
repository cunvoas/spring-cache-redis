/**
 * 
 */
package com.github.cunvoas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.cunvoas.bo.Person;
import com.github.cunvoas.persistance.DaoPerson;
import com.github.cunvoas.service.ServicePerson;

/**
 * @author CUNVOAS
 */
@Service
public class ServicePersonImpl implements ServicePerson {
	
	@Autowired
	private DaoPerson daoPerson;

	@Override
	@Cacheable(value="persons", key="#id")
	public Person getPersonById(Integer id) {
		return daoPerson.getPersonById(id);
	}

	@Override
	@CachePut(value = "persons", key="#person.id")
	public Person save(Person person) {
		return daoPerson.save(person);
	}

	@Override
	//@CacheEvict(value = "persons", allEntries=true, beforeInvocation=true)
	public List<Person> save(List<Person> persons) {
		return daoPerson.save(persons);
	}


	@Override
	@CacheEvict(value = "persons", key="#person.id")
	public void delete(Person person) {
		daoPerson.delete(person);
	}

	@Override
	public List<Person> findByLastnameLike(String lastname) {
		return daoPerson.findByLastnameLike(lastname);
	}

}
