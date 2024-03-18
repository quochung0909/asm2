package org.nqh.asm2.repository;

import org.nqh.asm2.pojo.Cv;
import org.nqh.asm2.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvRepository extends JpaRepository<Cv, Integer>{
    Cv findByUserByUserId(User id);
}
