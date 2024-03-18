package org.nqh.asm2.controller;

import java.io.File;
import java.io.IOException;

import org.nqh.asm2.pojo.User;
import org.nqh.asm2.service.ApplypostService;
import org.nqh.asm2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ApplypostController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private ApplypostService applypostService;

    // Ứng tuyển công việc
    @PostMapping("/user/apply-job1")
    public String applyJob(@RequestParam("idRe") int idRe,
                        @RequestParam("text") String text
            ){
        this.applypostService.applyJob(idRe, text);


        return "redirect:/recruitment/post";
    }

    // Ứng tuyển công việc kèm file cv
    @PostMapping("/user/apply-job")
    public String applyJobCv(@RequestParam("idRe") int idRe,
                        @RequestParam("text") String text,
                        @RequestParam("file") MultipartFile file2
            ) throws IllegalStateException, IOException{
        // lưu file vào thư mục uploads
    
        String path = System.getProperty("user.dir") + "/src/main/resources/uploads/";
        File file = new File(path + file2.getOriginalFilename());
        file2.transferTo(file);
        
        this.applypostService.applyJob(idRe, text, file2);


        return "redirect:/recruitment/post";
    }
}
