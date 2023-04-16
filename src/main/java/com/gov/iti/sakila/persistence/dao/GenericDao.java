package com.gov.iti.sakila.persistence.dao;

import com.gov.iti.sakila.persistence.Database;
import com.gov.iti.sakila.persistence.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;


import java.util.List;
import java.util.Optional;

@Transactional
public class GenericDao<T> {

    private final Class<T> entityClass;

    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    public Optional<T> getById(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = JPAUtil.getEntityManager();
            T entity = entityManager.find(entityClass, id);
            return Optional.ofNullable(entity);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public List<T> getAll() {
        EntityManager entityManager = null;
        try {
            entityManager = JPAUtil.getEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> rootEntry = cq.from(entityClass);
            CriteriaQuery<T> all = cq.select(rootEntry);
            return entityManager.createQuery(all).getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void save(T entity) {
        Database.doInTransactionWithoutResult(entityManager -> {
            entityManager.persist(entity);
        });
    }

    public void update(T entity) {
        Database.doInTransactionWithoutResult(entityManager -> {
            entityManager.merge(entity);
        });
    }

    public void delete(T entity) {
        Database.doInTransactionWithoutResult(entityManager -> {
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        });
    }
}
