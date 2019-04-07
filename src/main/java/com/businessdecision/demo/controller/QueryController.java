/**
 * 
 */
package com.businessdecision.demo.controller;

import static graphql.GraphQL.newGraphQL;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.businessdecision.demo.datafetcher.AddressDataFetcher;
import com.businessdecision.demo.datafetcher.AllPersonDataFetcher;
import com.businessdecision.demo.datafetcher.PersonDataFetcher;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

/**
 * REST Endpoint of the application
 * @author bernard.adanlessossi
 *
 */
@RestController
public class QueryController {

	private static Logger LOGGER = Logger.getLogger(QueryController.class.getName());

	@Value("classpath:schema.graphqls")
	private Resource schemaResource;

	private GraphQL graphql;

	@Autowired
	private AllPersonDataFetcher allPersonDataFetcher;

	@Autowired
	private PersonDataFetcher personDataFetcher;

	@Autowired
	private AddressDataFetcher addressDataFetcher;

	/**
	 * Loads the GraphQL Schema.
	 * @throws IOException if file not present
	 */
	@PostConstruct
	public void loadSchema() throws IOException {
		File schemaFile = this.schemaResource.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		this.graphql = newGraphQL(schema).build();
	}

	/**
	 * Builds the runtime wiring.
	 * @return the wiring
	 */
	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring -> typeWiring
						.dataFetcher("allPersons", this.allPersonDataFetcher)
						.dataFetcher("person", this.personDataFetcher))
				.type("Person", typeWiring -> typeWiring
						.dataFetcher("addresses", addressDataFetcher))
				.build();
	}
	
	/**
	 * Allows execution of GraphQL operations.
	 * @return the {@link GraphQL} object
	 */
	@Bean
	public GraphQL graphQL() {
		return this.graphql;
	}

	/**
	 * The {@link GraphQL} endpoint.
	 * @param query the query parameter
	 * @return the response
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public ResponseEntity query(@RequestBody String query) {
		ExecutionResult result = this.graphql.execute(query);
		LOGGER.log(Level.SEVERE, result.getErrors().toString());
		return ResponseEntity.ok(result.getData());
	}
}
