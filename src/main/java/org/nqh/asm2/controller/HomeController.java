package org.nqh.asm2.controller;

import java.util.List;

import org.nqh.asm2.pojo.Company;
import org.nqh.asm2.pojo.Recruitment;
import org.nqh.asm2.service.CategoryService;
import org.nqh.asm2.service.CompanyService;
import org.nqh.asm2.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
    * @project asm2
    * @Author nqh
    * @create 29-12-2023
    *
    * Các chức năng chính của trên trang chủ
 */
@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RecruitmentService recruitmentService;
    
    @Autowired 
    private CompanyService companyService;

    // Hiển thị các nôi dung trên trang chủ
    @GetMapping({"/", "/home"})
    public String homePage(Model model) {
        
        model.addAttribute("categories", this.categoryService.getAllCategory());
        model.addAttribute("recruitments", this.recruitmentService.getAllRecruitment());
        model.addAttribute("companies", this.companyService.getCompanyTopApply());
        

        return "public/home";
    }

    // Chức năng search theo địa chỉ công ty
    @PostMapping("/recruitment/searchaddress")
    public String searchAddress(@RequestParam("keySearch") String kw, Model model) {
        List<Recruitment> recruitments = this.recruitmentService.searchRecruitment(kw);
        System.out.println(recruitments.size());


        model.addAttribute("recruitments", recruitments);
        return "/public/result-search-address";
    }

    // Chức năng search theo tên công ty
    @PostMapping("/recruitment/searchnamecompany")
    public String searchNameCompany(@RequestParam("keySearch") String kw, Model model) {
        List<Recruitment> recruitments = this.recruitmentService.getRecruitmentByNameCompany(kw);
        model.addAttribute("recruitments", recruitments);

        return "/public/result-search-user";
    }

    // Chức năng search theo tên công việc
    @PostMapping("/recruitment/search")
    public String search(@RequestParam("keySearch") String kw, Model model) {
        List<Recruitment> recruitments = this.recruitmentService.getRecruitmentByTitle(kw);
        model.addAttribute("recruitments", recruitments);

        return "/public/result-search";
    }
}
