package com.unionistashop.crud_app_1.DAOs;

import com.unionistashop.crud_app_1.entities.security_tables.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository  extends JpaRepository<User, String> {

}
