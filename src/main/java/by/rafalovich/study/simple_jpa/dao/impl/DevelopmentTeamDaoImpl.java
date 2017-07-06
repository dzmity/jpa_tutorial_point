package by.rafalovich.study.simple_jpa.dao.impl;

import by.rafalovich.study.simple_jpa.dao.DevelopmentTeamDao;
import by.rafalovich.study.simple_jpa.entity.DevelopmentTeam;

import javax.persistence.EntityManager;

public class DevelopmentTeamDaoImpl extends DevelopmentTeamDao
{
    @Override
    public void create(DevelopmentTeam developmentTeam)
    {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(developmentTeam);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public DevelopmentTeam find(Long id)
    {
        EntityManager entityManager = getEntityManager();

        DevelopmentTeam developmentTeam = entityManager.find(DevelopmentTeam.class, id);
        entityManager.close();
        return developmentTeam;
    }

    @Override
    public void delete(DevelopmentTeam developmentTeam)
    {

    }

    @Override
    public void update(DevelopmentTeam developmentTeam)
    {

    }
}
