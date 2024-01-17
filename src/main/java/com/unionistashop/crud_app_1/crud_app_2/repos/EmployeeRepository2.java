package com.unionistashop.crud_app_1.crud_app_2.repos;

import com.unionistashop.crud_app_1.crud_app_2.entity.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//@RepositoryRestResource(path="members")


@Repository

public interface EmployeeRepository2 extends JpaRepository<Employee2, Integer> {
    Optional<Employee2> findByEmail(String email);

}

