package edu.techpheonix.jpa;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vijay
 */
public class BootstrapTest {

    public static void main(String[] args) {
        /**
         * The name 'hibernate-jpa-unit' is a persistence unit name mentioned in
         * the persistence.xml
         */
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate-jpa-unit");
        EntityManager manager = factory.createEntityManager();

        /**
         * Test sample query to check every thing is OK.
         */
        List<String> schemaList = manager.createNativeQuery("SHOW SCHEMAS").getResultList();

        for (Iterator<String> it = schemaList.iterator(); it.hasNext();) {
            String name = it.next();
            System.out.println("Schema :" + name);
        }
    }
}
