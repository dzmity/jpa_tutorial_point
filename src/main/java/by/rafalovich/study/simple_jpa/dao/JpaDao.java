package by.rafalovich.study.simple_jpa.dao;

import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class JpaDao
{
    private static final EntityManagerFactory managerFactory = new HibernatePersistenceProvider().
            createEntityManagerFactory("oracle", null);

    public static void closeEMF()
    {
        managerFactory.close();
    }

    protected EntityManager getEntityManager()
    {
        return managerFactory.createEntityManager();
    }
}
