package com.phl.business.config;

import com.phl.business.domain.authentication.AuthUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class WebAuditConfig {

    @Bean
    public AuditorAware<String> createAuditorProvider() {
        return new SecurityAuditor();
    }

    @Bean
    public AuditingEntityListener createAuditingListener() {
        return new AuditingEntityListener();
    }


    public static class SecurityAuditor implements AuditorAware<String> {

        @Override
        public Optional<String> getCurrentAuditor() {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            // set Auditor here
            if (auth != null) {
                if (auth.getPrincipal() instanceof String) {
                    return Optional.of((String) auth.getPrincipal());
                } else if (auth.getPrincipal() instanceof AuthUserDetails) {
                    return Optional.of(((AuthUserDetails) auth.getPrincipal()).getUsername());
                }
            }
            // Standard of spring for anonymous user
            return Optional.of("anonymousUser");
        }

    }
}