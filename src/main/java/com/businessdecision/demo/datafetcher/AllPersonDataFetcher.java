/**
 * 
 */
package com.businessdecision.demo.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.businessdecision.demo.repository.PersonRepository;
import com.businessdecision.demo.types.Person;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * {@link DataFetcher} for All {@link Person} type.
 * @author bernard.adanlessossi
 *
 */
@Component
public class AllPersonDataFetcher implements DataFetcher<List<Person>> {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> get(DataFetchingEnvironment env) throws Exception {
		// Just return all
		return this.personRepository.findAll();
	}

}
