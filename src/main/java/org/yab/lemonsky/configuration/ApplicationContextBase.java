package org.yab.lemonsky.configuration;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * User: Danila Vereshchakov
 * Date: 22.05.2017
 */
@Configuration
@ComponentScan(basePackages = "org.yab.lemonsky")
@Import(SecurityConfig.class)
public class ApplicationContextBase {

    @Bean
    public PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        ClassPathResource resource = new ClassPathResource("hibernate.properties");
        placeholderConfigurer.setLocations(resource);
        return placeholderConfigurer;
    }
}
