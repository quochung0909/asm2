package org.nqh.asm2.controller;

import org.nqh.asm2.pojo.Recruitment;
import org.nqh.asm2.pojo.User;
import org.nqh.asm2.service.CategoryService;
import org.nqh.asm2.service.RecruitmentService;
import org.nqh.asm2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

    @Autowired
    private UserService userService;

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired  
    private CategoryService categoryService;
    
    // Hiển thị danh sách bài đăng
    @GetMapping("/list-post")
    public String listPost(Model model) {
        
        model.addAttribute("list", this.recruitmentService.getAllRecruitment());
        return "public/post-list";
    }

    // Hiển thị chi tiết bài đăng
    @GetMapping("/user/post-job")
    public String postJob(Model model) {
        model.addAttribute("categories", this.categoryService.getAllCategory());
        return "public/post-job";
    }

    // Thêm bài đăng
    @PostMapping("/recruitment/add")
    public String addRecruitment(@ModelAttribute Recruitment recruitment, Model model) {
        this.recruitmentService.addRecruitment(recruitment);
        return "redirect:/user/list-post";
    }

    // Hiển thị chi tiết bài đăng
    @GetMapping("/recruitment/detail/{id}")
    public String detailRecruitment(Model model, @PathVariable("id") int id) {
        Recruitment recruitment = this.recruitmentService.getRecruitmentById(id);
        model.addAttribute("recruitment", recruitment);
        return "public/detail-post";
    }

    // Chỉnh sửa bài đăng
    @GetMapping("/recruitment/editpost/{id}")
    public String editRecruitment(Model model, @PathVariable("id") int id) {
        Recruitment recruitment = this.recruitmentService.getRecruitmentById(id);
        model.addAttribute("recruitment", recruitment);
        model.addAttribute("categories", this.categoryService.getAllCategory());
        return "public/edit-job";
    }

    // Chỉnh sửa bài đăng
    @PostMapping("/recruitment/edit")
    public String editRecruitment(@ModelAttribute Recruitment recruitment, Model model) {
        this.recruitmentService.addRecruitment(recruitment);
        return "redirect:/user/list-post";
    }

    // Xóa bài đăng
    @PostMapping("/recruitment/delete")
    public String deleteRecruitment(@RequestParam("idrecruitment") int id) {
        this.recruitmentService.deleteRecruitment(id);
        return "redirect:/user/list-post";
    }

    // Hiển thị danh sách bài đăng
    @GetMapping("/list-job")
    public String listJob(Model model) {
        model.addAttribute("list", this.recruitmentService.getAllRecruitment());
        return "public/listJob";
    }

}
