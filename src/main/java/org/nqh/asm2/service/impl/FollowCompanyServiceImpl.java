package org.nqh.asm2.service.impl;

import java.util.List;

import org.nqh.asm2.pojo.FollowCompany;
import org.nqh.asm2.pojo.User;
import org.nqh.asm2.repository.FollowCompanyRepository;
import org.nqh.asm2.service.FollowCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowCompanyServiceImpl implements FollowCompanyService {
    
    @Autowired
    private FollowCompanyRepository followCompanyRepository;

    @Override
    public void followCompany(FollowCompany followCompany) {
        this.followCompanyRepository.save(followCompany);
    }

    @Override
    public List<FollowCompany> getListFollowCompanyByUserId(User userId) {
        return this.followCompanyRepository.findByUserByUserId(userId);
    }

    @Override
    public void deleteFollowCompany(int id) {
        this.followCompanyRepository.deleteById(id);
    }
    
}
