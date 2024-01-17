package com.unionistashop.crud_app_1.DAOs;

import com.unionistashop.crud_app_1.entities.custom_security.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Member, String> {
}
