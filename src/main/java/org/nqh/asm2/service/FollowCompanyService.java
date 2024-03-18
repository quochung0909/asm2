package org.nqh.asm2.service;

import java.util.List;

import org.nqh.asm2.pojo.FollowCompany;
import org.nqh.asm2.pojo.User;

public interface FollowCompanyService {

    void followCompany(FollowCompany followCompany);
    List<FollowCompany> getListFollowCompanyByUserId(User userId);
    void deleteFollowCompany(int id);
}
