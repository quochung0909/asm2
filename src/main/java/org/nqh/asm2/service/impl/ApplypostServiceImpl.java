package org.nqh.asm2.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.nqh.asm2.pojo.Applypost;
import org.nqh.asm2.pojo.Recruitment;
import org.nqh.asm2.pojo.User;
import org.nqh.asm2.repository.ApplypostRepository;
import org.nqh.asm2.service.ApplypostService;
import org.nqh.asm2.service.RecruitmentService;
import org.nqh.asm2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ApplypostServiceImpl implements ApplypostService {

    @Autowired
    private ApplypostRepository applypostRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RecruitmentService recruitmentService;

    @Override
    public void applyJob(int idRe, String text) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userService.getUserByEmail(authentication.getName());

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);

        Applypost applypost = new Applypost();

        Recruitment recruitment = this.recruitmentService.getRecruitmentById(idRe);

        applypost.setRecruitmentByRecruitmentId(recruitment);
        applypost.setUserByUserId(user);
        applypost.setText(text);
        applypost.setStatus(1);
        applypost.setCreatedAt(strDate);
        applypost.setNameCv(user.getCvByCvId().getFileName());

        this.applypostRepository.save(applypost);
    }

    @Override
    public void applyJob(int idRe, String text, MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userService.getUserByEmail(authentication.getName());

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);

        Applypost applypost = new Applypost();

        Recruitment recruitment = this.recruitmentService.getRecruitmentById(idRe);

        applypost.setRecruitmentByRecruitmentId(recruitment);
        applypost.setUserByUserId(user);
        applypost.setText(text);
        applypost.setStatus(1);
        applypost.setCreatedAt(strDate);
        applypost.setNameCv(file.getOriginalFilename());

        this.applypostRepository.save(applypost);
    }

    @Override
    public List<Applypost> getAllApplypost() {
        return this.applypostRepository.findAll();
    }

}
