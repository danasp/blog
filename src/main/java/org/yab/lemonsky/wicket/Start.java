package org.yab.lemonsky.wicket;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.yab.lemonsky.models.entities.Account;

import javax.persistence.EntityManager;

/**
 * User: Danila Vereshchakov
 * Date: 28.08.2016
 */
public class Start {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("/src/main/resources/applicationContext-hibernate.xml");
        LocalContainerEntityManagerFactoryBean emf = (LocalContainerEntityManagerFactoryBean) ctx.getBean("entityManagerFactory");
        EntityManager entityManager = emf.getNativeEntityManagerFactory().createEntityManager();

        Account acc = (Account) ctx.getBean("account");
        acc.setLogin("test");
        entityManager.merge(acc);
    }
}
