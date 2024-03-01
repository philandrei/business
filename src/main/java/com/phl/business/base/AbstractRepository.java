package com.phl.business.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface AbstractRepository<T,ID extends Serializable> extends JpaRepository<T,ID>  {

    public Optional<T> getOneByUUID(String uuid);

}
