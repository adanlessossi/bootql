/**
 * 
 */
package com.businessdecision.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.businessdecision.demo.types.Person;

/**
 * The JPA Repository for {@link Person} type.
 * @author bernard.adanlessossi
 *
 */
@Component
public interface PersonRepository extends JpaRepository<Person, String>{
	// Nothing to do here
}
