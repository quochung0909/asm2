package org.nqh.asm2.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.nqh.asm2.pojo.Company;
import org.nqh.asm2.pojo.Recruitment;
import org.nqh.asm2.pojo.User;
import org.nqh.asm2.repository.CompanyRepository;
import org.nqh.asm2.repository.RecruitmentRepository;
import org.nqh.asm2.repository.UserRepository;
import org.nqh.asm2.service.CompanyService;
import org.nqh.asm2.service.RecruitmentService;
import org.nqh.asm2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class RecruitmentServiceImpl implements RecruitmentService{

    @Autowired
    private RecruitmentRepository recruitmentRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Recruitment> getAllRecruitment() {
        return this.recruitmentRepository.findAll();
    }

    @Override
    public void addRecruitment(Recruitment recruitment) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepository.findByEmail(authentication.getName());
        Company company = this.companyRepository.findByUserByUserId(user);

        // Lấy ngày hiện tại
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);

        recruitment.setCreatedAt(strDate);

        recruitment.setStatus(1);
        recruitment.setCompanyByCompanyId(company);


        this.recruitmentRepository.save(recruitment);
    }

    @Override
    public Recruitment getRecruitmentById(int id) {
        return this.recruitmentRepository.findById(id).get();
    }

    @Override
    public void deleteRecruitment(int id) {
        this.recruitmentRepository.deleteById(id);
    }

    @Override
    public List<Recruitment> searchRecruitment(String keyword) {
        return this.recruitmentRepository.findByAddressContaining(keyword);
    }

    @Override
    public List<Recruitment> getRecruitmentByNameCompany(String keyword) {
        List<Recruitment> recruitments = this.recruitmentRepository.findAll();
        List<Recruitment> result = new ArrayList<>();

        // In ra tên tất cả các công ty
        for (int i = 0; i < recruitments.size(); i++) {
            System.out.println(recruitments.get(i).getCompanyByCompanyId().getNameCompany());
        }

        System.out.println("Keyword: " + keyword);

        // Tìm xem nếu tên công ty trùng với keyword thì lưu lại
        for (int i = 0; i < recruitments.size(); i++) {
            if (recruitments.get(i).getCompanyByCompanyId().getNameCompany().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(recruitments.get(i));
            }
        }


        return result;
    }

    @Override
    public List<Recruitment> getRecruitmentByTitle(String keyword) {
        return this.recruitmentRepository.findByTitleContaining(keyword);
    }
    
}
