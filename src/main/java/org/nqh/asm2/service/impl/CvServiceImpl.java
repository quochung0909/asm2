package org.nqh.asm2.service.impl;

import org.nqh.asm2.pojo.Cv;
import org.nqh.asm2.pojo.User;
import org.nqh.asm2.repository.CvRepository;
import org.nqh.asm2.service.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CvServiceImpl implements CvService{

    @Autowired
    private CvRepository cvRepository;

    @Override
    public void save(String url, User user) {
        Cv cv = new Cv();
        cv.setFileName(url);
        cv.setUserByUserId(user);
        this.cvRepository.save(cv);
    }

    @Override
    public Cv getCvByUserByUserId(User userId) {
        return this.cvRepository.findByUserByUserId(userId);
    }

    @Override
    public void delete(Cv cv) {
        this.cvRepository.delete(cv);
    }
    
}
