package org.nqh.asm2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.nqh.asm2.pojo.Applypost;
import org.nqh.asm2.pojo.Company;
import org.nqh.asm2.pojo.Recruitment;
import org.nqh.asm2.pojo.User;
import org.nqh.asm2.repository.ApplypostRepository;
import org.nqh.asm2.repository.CompanyRepository;
import org.nqh.asm2.repository.RecruitmentRepository;
import org.nqh.asm2.service.ApplypostService;
import org.nqh.asm2.service.CompanyService;
import org.nqh.asm2.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ApplypostRepository applypostRepository;
    @Autowired 
    private RecruitmentRepository recruitmentRepository;

    @Override
    public Company getCompanyByUserByUserId(User userId) {
        return this.companyRepository.findByUserByUserId(userId);
    }

    @Override
    public Company update(Company company) {
        return this.companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(int id) {
        return this.companyRepository.findById(id);
    }

    @Override
    public List<Company> getCompanyTopApply() {
        List<Applypost> applyposts = this.applypostRepository.findAll();
        List<Recruitment> recruitments = this.recruitmentRepository.findAll();
        // Tìm recruitment có số lượng applypost lớn nhất
        int max = 0;
        for (Recruitment recruitment : recruitments) {
            int count = 0;
            for (Applypost applypost : applyposts) {
                if (applypost.getRecruitmentByRecruitmentId().getIdrecruitment() == recruitment.getIdrecruitment()) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
            }
        }

        // Tìm các recruitment có số lượng applypost bằng max
        List<Recruitment> recruitmentMax = new ArrayList<>();
        for (Recruitment recruitment : recruitments) {
            int count = 0;
            for (Applypost applypost : applyposts) {
                if (applypost.getRecruitmentByRecruitmentId().getIdrecruitment() == recruitment.getIdrecruitment()) {
                    count++;
                }
            }
            if (count == max) {
                recruitmentMax.add(recruitment);
            }
        }

        // Tìm các company có recruitment có số lượng applypost bằng max
        List<Company> companies = new ArrayList<>();
        for (Recruitment recruitment : recruitmentMax) {
            companies.add(recruitment.getCompanyByCompanyId());
        }


        return companies;
    }
    
}
