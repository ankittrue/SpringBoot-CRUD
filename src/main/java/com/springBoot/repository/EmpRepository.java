package com.springBoot.repository;

import com.springBoot.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {

}