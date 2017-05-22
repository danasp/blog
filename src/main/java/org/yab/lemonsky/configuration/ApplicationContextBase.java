package org.yab.lemonsky.configuration;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;

/**
 * User: Danila Vereshchakov
 * Date: 22.05.2017
 */
@Configuration
@ComponentScan(basePackages = "org.yab.lemonsky")
@PropertySource(value = {"classpath:hibernate.properties"})
//@Import(ApplicationContextHibernate.class)
public class ApplicationContextBase {

    @Bean
    public PropertyPlaceholderConfigurer propertyConfigurer() {
        PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();
        ClassPathResource resource = new ClassPathResource("hibernate.properties");
        placeholderConfigurer.setLocations(resource);
        return placeholderConfigurer;
    }
}
