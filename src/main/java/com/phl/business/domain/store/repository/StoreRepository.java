package com.phl.business.domain.store.repository;

import com.phl.business.base.AbstractRepository;
import com.phl.business.domain.store.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends AbstractRepository<Store,String> {
}
