package com.github.cunvoas.persistance;

import java.util.List;

import com.github.cunvoas.bo.Person;

public interface DaoPerson {
	
	public Person getPersonById(Integer id);
	public Person save(Person person);
	public List<Person> save(List<Person> person);
	public void delete(Person person);
	public List<Person> findByLastnameLike(String lastname);
	
}
