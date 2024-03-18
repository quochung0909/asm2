package org.nqh.asm2.service;

import java.util.List;

import org.nqh.asm2.pojo.Company;
import org.nqh.asm2.pojo.User;

public interface CompanyService {
    Company getCompanyByUserByUserId(User userId);
    Company update(Company company);
    Company getCompanyById(int id);

    List<Company> getCompanyTopApply();
}
