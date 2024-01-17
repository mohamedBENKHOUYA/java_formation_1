package com.unionistashop.crud_app_1.DAOs;

import com.unionistashop.crud_app_1.entities.security_tables.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authority, String> {
}
