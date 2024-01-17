package com.unionistashop.crud_app_1.DAOs;

import com.unionistashop.crud_app_1.entities.custom_security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, String> {
}
