package org.nqh.asm2.service;

import org.nqh.asm2.pojo.Cv;
import org.nqh.asm2.pojo.User;

public interface CvService {
    void save(String url, User user);
    Cv getCvByUserByUserId(User userId);
    void delete(Cv cv);
}
