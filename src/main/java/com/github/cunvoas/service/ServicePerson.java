package com.github.cunvoas.service;

import java.util.List;

import com.github.cunvoas.bo.Person;

public interface ServicePerson {
	
	public Person getPersonById(Integer id);
	public Person save(Person person);
	public List<Person> save(List<Person> person);
	public void delete(Person person);
	public List<Person> findByLastnameLike(String lastname);
	
}
