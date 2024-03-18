package org.nqh.asm2.service;

import java.util.List;

import org.nqh.asm2.pojo.Recruitment;

public interface RecruitmentService {
    List<Recruitment> getAllRecruitment();
    void addRecruitment(Recruitment recruitment);
    Recruitment getRecruitmentById(int id);
    void deleteRecruitment(int id);

    List<Recruitment> searchRecruitment(String keyword);
    List<Recruitment> getRecruitmentByNameCompany(String keyword);
    List<Recruitment> getRecruitmentByTitle(String keyword);
}
