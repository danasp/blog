package org.yab.lemonsky.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * User: Danila Vereshchakov
 * Date: 22.05.2017
 */
@Configuration
@ImportResource({"classpath:applicationContext-hibernate.xml"})
@Import(ApplicationContextBase.class)
public class ApplicationContextHibernate {

    @Bean
    public BasicDataSource dataSource(
            @Value("${db.driver}") String driver,
            @Value("${db.url}") String url,
            @Value("${db.username}") String username,
            @Value("${db.password}") String password) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setValidationQuery("select 1");
        ds.setTestOnBorrow(true);
        return ds;
    }


    @Bean
    public SpringLiquibase liquibase(BasicDataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db_migrations/changelog-master.xml");
        return liquibase;
    }
}
