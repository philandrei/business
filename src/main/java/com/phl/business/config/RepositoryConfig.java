package com.phl.business.config;

import com.phl.business.base.AbstractRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.phl.business",repositoryBaseClass = AbstractRepositoryImpl.class)
public class RepositoryConfig {
}
