/**
 * 
 */
package com.businessdecision.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Allows configuring the graphiql browser.
 * @author bernard.adanlessossi
 *
 */
@Configuration
public class GraphqlConfiguration implements WebMvcConfigurer{

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/graphiql").setViewName(
                "forward:/graphiql/index.html");
    }
}
