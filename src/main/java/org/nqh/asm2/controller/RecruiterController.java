package org.nqh.asm2.controller;

import org.nqh.asm2.service.ApplypostService;
import org.nqh.asm2.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
    * @project asm2
    * @Author nqh
    * @create 29-12-2023
    *
    * Các chức năng của nhà tuyển dụng
 */
@Controller
public class RecruiterController {

    @Autowired
    private RecruitmentService recruitmentService;
    @Autowired
    private ApplypostService applypostService;

    // Hiển thị các nội dung của nhà tuyển dụng
    @GetMapping("/recruitment/post")
    public String recruiterPage(Model model) {
        model.addAttribute("list", this.recruitmentService.getAllRecruitment());
        return "public/recruitment";
    }

    // Hiển thị danh sách ứng viên
    @GetMapping("/list-user")
    public String listUser(Model model) {
        model.addAttribute("list", this.applypostService.getAllApplypost());
        return "public/list-user";
    }   

    
}
