/**
 * 
 */
package com.businessdecision.demo.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.businessdecision.demo.repository.AddressRepository;
import com.businessdecision.demo.types.Address;
import com.businessdecision.demo.types.Person;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * {@link DataFetcher} for {@link Address} type.
 * @author bernard.adanlessossi
 *
 */
@Component
public class AddressDataFetcher implements DataFetcher<List<Address>>{
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<Address> get(DataFetchingEnvironment env) throws Exception {
		// The person whom address to fetch is in the DataFetchingEnvironment source!!
		Person person = (Person)env.getSource();
		// We can now fetch his addresses with the id
		return this.addressRepository.getAddresses(person.getId());
	}

}
