package org.nqh.asm2.repository;

import java.util.List;

import org.nqh.asm2.pojo.Company;
import org.nqh.asm2.pojo.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Integer>{
    List<Recruitment> findByAddressContaining(String keyword);
    List<Recruitment> findByCompanyByCompanyId(Company companyByCompanyId);
    List<Recruitment> findByTitleContaining(String keyword);
}
