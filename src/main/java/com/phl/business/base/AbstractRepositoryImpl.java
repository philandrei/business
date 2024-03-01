package com.phl.business.base;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class AbstractRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements AbstractRepository<T, ID> {
    private EntityManager entityManager;

    public AbstractRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    //enhance this
    public Optional<T> getOneByUUID(String uuid) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cQuery = builder.createQuery(getDomainClass());
        Root<T> root = cQuery.from(getDomainClass());
        cQuery
                .select(root)
                .where(builder.equal(root.<String>get("uuid"), uuid), builder.equal(root.get("deleted"), false));
//                .where(builder.equal(root.get("deleted"),false));
        TypedQuery<T> query = entityManager.createQuery(cQuery);
        if(query.getSingleResult() == null){
            return null;
        }
        return Optional.of(query.getSingleResult());
    }
}
