package org.nqh.asm2.repository;

import java.util.List;

import org.nqh.asm2.pojo.SaveJob;
import org.nqh.asm2.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveJobRepository extends JpaRepository<SaveJob, Integer>{
    
    List<SaveJob> findByUserByUserId(User userByUserId);
}
