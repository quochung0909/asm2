package org.nqh.asm2.repository;

import java.util.List;

import org.nqh.asm2.pojo.Company;
import org.nqh.asm2.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findByUserByUserId(User user);
    Company findById(int id);
}