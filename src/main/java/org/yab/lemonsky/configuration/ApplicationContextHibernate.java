package org.yab.lemonsky.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * User: Danila Vereshchakov
 * Date: 22.05.2017
 */
@Configuration
@ComponentScan(basePackages = "org.yab.lemonsky")
@ImportResource({
                "classpath:applicationContext-base.xml",
                "classpath:applicationContext-hibernate.xml"
})
public class ApplicationContextHibernate {
    /*
    <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource" destroy-method="close">
    <property name="driverClassName" value="${db.driver}"/>
    <property name="url" value="${db.url}"/>
    <property name="username" value="${db.username}"/>
    <property name="password" value="${db.password}"/>
    <property name="validationQuery" value="select 1"/>
    <property name="testOnBorrow" value="true"/>
    </bean>
    */

    @Value("${db.driver}")
    String driver;
    @Value("${db.url}")
    String url;
    @Value("${db.username}")
    String username;
    @Value("${db.password}")
    String password;

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setValidationQuery("select 1");
        ds.setTestOnBorrow(true);
        return ds;
    }
}
