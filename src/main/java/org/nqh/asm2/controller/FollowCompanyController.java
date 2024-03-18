package org.nqh.asm2.controller;

import org.nqh.asm2.pojo.Company;
import org.nqh.asm2.pojo.FollowCompany;
import org.nqh.asm2.pojo.User;
import org.nqh.asm2.service.CompanyService;
import org.nqh.asm2.service.FollowCompanyService;
import org.nqh.asm2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FollowCompanyController {

    @Autowired
    private FollowCompanyService followCompanyService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private UserService userService;

    // Theo dõi công ty
    @PostMapping("/user/follow-company")
    public String followCompany(@RequestParam("idcompany") int companyId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userService.getUserByEmail(authentication.getName());

        Company company = this.companyService.getCompanyById(companyId);

        FollowCompany followCompany = new FollowCompany();
        followCompany.setCompanyByCompanyId(company);
        followCompany.setUserByUserId(user);

        this.followCompanyService.followCompany(followCompany);

        return "redirect:/company/detail/" + companyId;
    }

    // Hiển thị danh sách công ty theo dõi
    @GetMapping("/user/get-list-company")
    public String getListCompany(Model model) {
        model.addAttribute("saveCompanyList", this.followCompanyService.getListFollowCompanyByUserId(this.userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName())));
        return "public/list-follow-company";
    }

    // Hủy theo dõi công ty
    @GetMapping("/user/delete-follow/{id}")
    public String deleteFollowCompany(@RequestParam("id") int id) {
        this.followCompanyService.deleteFollowCompany(id);
        return "redirect:/user/get-list-company";
    }
}
