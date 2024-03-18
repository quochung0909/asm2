package org.nqh.asm2.controller;

import org.nqh.asm2.pojo.Recruitment;
import org.nqh.asm2.pojo.SaveJob;
import org.nqh.asm2.pojo.User;
import org.nqh.asm2.service.RecruitmentService;
import org.nqh.asm2.service.SaveJobService;
import org.nqh.asm2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaveJobController {

    @Autowired
    private UserService userService;
    @Autowired 
    private SaveJobService saveJobService;
    @Autowired
    private RecruitmentService recruitmentService;

    // Lưu công việc
    @PostMapping("/save-job/save")
    public String save(@RequestParam("idRe") String idRe) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userService.getUserByEmail(authentication.getName());

        Recruitment recruitment = this.recruitmentService.getRecruitmentById(Integer.parseInt(idRe));

        SaveJob saveJob = new SaveJob();
        saveJob.setRecruitmentByRecruitmentId(recruitment);
        saveJob.setUserByUserId(user);

        this.saveJobService.saveJob(saveJob);


        return "redirect:/recruitment/post";
    }

    // Hiển thị danh sách công việc đã lưu
    @GetMapping("/save-job/get-list")
    public String getListSaveJob(Model model) {
        model.addAttribute("saveJobList", this.saveJobService.getListSaveJobByUser(this.userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName())));

        return "public/list-save-job";
    }

    // Xóa công việc đã lưu
    @GetMapping("/save-job/delete/{id}")
    public String deleteSaveJob(@PathVariable("id") String id) {
        this.saveJobService.deleteSaveJob(Integer.parseInt(id));
        return "redirect:/save-job/get-list";
    }
}
