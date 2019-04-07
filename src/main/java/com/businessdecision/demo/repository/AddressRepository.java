/**
 * 
 */
package com.businessdecision.demo.repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.businessdecision.demo.types.Address;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Repository for the {@link Address} type.
 * @author bernard.adanlessossi
 *
 */
@Component
public class AddressRepository {

	// Use Spring resource to get the files
	@Value("classpath:person-addresses.csv")
	private Resource personAddress;

	@Value("classpath:addresses.cvs")
	private Resource addressResource;

	/**
	 * Gets the Addresses for a given {@link Person}'s ID.
	 * @param personId the {@link Person}'s ID
	 * @return a list of {@link Person}'s {@link Address}'s
	 */
	public List<Address> getAddresses(final String personId) {
		List<String> addressIds = Lists.newArrayList();
		List<Address> addresses = Lists.newArrayList();
		try {
			addressIds = getAddressIds(personId);
			addresses = getAddresses(addressIds);
		} catch (IOException ioex) {
			ioex.getMessage();
		}
		return addresses;
	}

	/**
	 * Gets addresses for a given addresses ids.
	 * @param addressIds the given ids
	 * @return a list of addresses.
	 */
	private List<Address> getAddresses(List<String> addressIds) throws IOException {
		List<Address> addresses = Lists.newArrayList();
		Map<String, Address> addressMap = getAddresses();
		
		for (String addressId : addressIds) {
			addresses.add(addressMap.get(addressId));
		}
		return addresses;
	}

	/**
	 * Gets all addresses.
	 * @return a {@link Map} of all addresses.
	 */
	private Map<String, Address> getAddresses() throws IOException {
		// get the address resource
		File addressFile = addressResource.getFile();
		Map<String, Address> addresses = Maps.newHashMap();
		Scanner scanner = null;
		try {
			// scan the file with scanner
			scanner = new Scanner(addressFile);			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] columns = line.split(",");
				// Create a new address
				Address address = new Address(columns[0], columns[1], columns[2], columns[3]);
				addresses.put(columns[0], address);
			}
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return addresses;
	}

	/**
	 * Gets the address ids for a given person id.
	 * @param personId the person id
	 * @return a list of address ids
	 */
	private List<String> getAddressIds(String personId) {
		List<String> addressIds = Lists.newArrayList();
		File addressSchema = null;
		Scanner scanner = null;
		try {
			addressSchema = this.personAddress.getFile();
			scanner = new Scanner(addressSchema);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] columns = line.split(",");
				if (columns[0].equals(personId)) {
					addressIds.add(columns[1]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (scanner != null) {
				scanner.close();
			}
		}

		return addressIds;
	}
}
