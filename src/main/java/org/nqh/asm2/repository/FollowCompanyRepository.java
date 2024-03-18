package org.nqh.asm2.repository;

import org.nqh.asm2.pojo.FollowCompany;
import org.nqh.asm2.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface FollowCompanyRepository extends JpaRepository<FollowCompany, Integer>{
    List<FollowCompany> findByUserByUserId(User userByUserId);
}
