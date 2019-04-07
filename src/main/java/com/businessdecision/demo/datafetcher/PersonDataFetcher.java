/**
 * 
 */
package com.businessdecision.demo.datafetcher;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.businessdecision.demo.repository.PersonRepository;
import com.businessdecision.demo.types.Person;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * {@link DataFetcher} for a single {@link Person} type.
 * @author bernard.adanlessossi
 *
 */
@Component
public class PersonDataFetcher implements DataFetcher<Person>{
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person get(DataFetchingEnvironment env) throws Exception {
		// The DataFetchingEnvironment contains the request arguments
		Map<String, Object> args = env.getArguments();
		return this.personRepository.getOne((String)args.get("id"));
	}

}
