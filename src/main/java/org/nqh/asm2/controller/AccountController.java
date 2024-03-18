package org.nqh.asm2.controller;

import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Map;
import java.util.UUID;

import org.nqh.asm2.config.CloudinaryService;
import org.nqh.asm2.pojo.Company;
import org.nqh.asm2.pojo.Cv;
import org.nqh.asm2.pojo.User;
import org.nqh.asm2.service.CompanyService;
import org.nqh.asm2.service.CvService;
import org.nqh.asm2.service.EmailService;
import org.nqh.asm2.service.RoleService;
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
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.Cookie;

/*
    * @project asm2
    * @Author nqh
    * @create 29-12-2023
    *
    * Các chức năng liên quan đến tài khoản
 */
@Controller
public class AccountController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CvService cvService;
    
    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private EmailService emailService;

    UUID uuid = UUID.randomUUID();


    // Hiển thị trang đăng nhập
    @GetMapping("auth/login")
    public String loginPage(Model model) {
        model.addAttribute("msg_register_success", false);
        model.addAttribute("roles", this.roleService.getAllRole());
        return "public/login";
    }

    // Chức năng đăng ký tài khoản
    @PostMapping("auth/register")
    public String register(@ModelAttribute User user,
                           @RequestParam("role_id") int role,
                           Model model) {
        user.setRoleByRoleId(this.roleService.getRoleById(role));
        System.out.println(user.getEmail());
        this.userService.save(user);
        model.addAttribute("msg_register_success", true);
        model.addAttribute("roles", this.roleService.getAllRole());
        return "public/login";
    }

    // Hiển thị trang thông tin cá nhân
    @GetMapping("user/profile")
    public String profilePage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userService.getUserByEmail(authentication.getName());

        model.addAttribute("userInformation", user);
        
        Company company = this.companyService.getCompanyByUserByUserId(user);
        model.addAttribute("companyInformation", company);

        model.addAttribute("Cv", this.cvService.getCvByUserByUserId(user));

        return "public/profile";
    }

    // Chức năng cập nhật thông tin cá nhân
    @PostMapping("user/update-profile")
    public String updateProfile(@ModelAttribute User user) {
        this.userService.update(user);
        
        return "redirect:/user/profile";
    }

    // Chức năng cập nhật ảnh đại diện
    @PostMapping("user/update-avatar")
    public String uploadAvatar(@RequestParam("file") MultipartFile multipartFile, Model model) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userService.getUserByEmail(authentication.getName());

        if (user.getImage() != null) {
            // Xóa file cũ trên cloudinary
            String publicId = user.getImage().substring(user.getImage().lastIndexOf("/") + 1, user.getImage().lastIndexOf("."));
            this.cloudinaryService.delete(publicId);
        }
        // Lưu và trả về đường dẫn của file trên cloudinary 
        Map result = this.cloudinaryService.upload(multipartFile);
        
        // Lấy đường dẫn của file trên cloudinary
        String url = (String) result.get("url");
        user.setImage(url);
        this.userService.update(user);

        return "redirect:/user/profile";
    }

    // Chức năng cập nhật thông tin công ty
    @PostMapping("user/update-company")
    public String updateCompany(@ModelAttribute Company company) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userService.getUserByEmail(authentication.getName());
        company.setUserByUserId(user);

        company.setIdcompany(0);

        Company cpn = this.companyService.update(company);

        user.setCompaniesByIduser(cpn);
        this.userService.update(user);

        return "redirect:/user/profile";
    }


    // Chức năng cập nhật ảnh công ty
    @PostMapping("user/update-avatar-company")
    public String upload(@RequestParam("file") MultipartFile multipartFile, Model model) throws IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userService.getUserByEmail(authentication.getName());
        Company company = this.companyService.getCompanyByUserByUserId(user);

        if (company.getLogo() != null) {
            // Xóa file cũ trên cloudinary
            String publicId = company.getLogo().substring(company.getLogo().lastIndexOf("/") + 1, company.getLogo().lastIndexOf("."));
            this.cloudinaryService.delete(publicId);
        }
        // Lưu và trả về đường dẫn của file trên cloudinary 
        Map result = this.cloudinaryService.upload(multipartFile);
        
        // Lấy đường dẫn của file trên cloudinary
        String url = (String) result.get("url");
        company.setLogo(url);
        this.companyService.update(company);
        model.addAttribute("companyInformation", company);
        return "redirect:/user/profile";
    }




    // Chức năng upload cv
    @PostMapping("user/upload-cv")
    public String uploadCv(@RequestParam("file") MultipartFile multipartFile, Model model) throws IOException {

        // Lưu file vào resources/uploads
        String path = System.getProperty("user.dir") + "/src/main/resources/uploads/";
        File file = new File(path + multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);


        this.cvService.save(file.getName(), this.userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));

        return "redirect:/user/profile";
    }

    // Chức năng xóa cv
    @PostMapping("/user/deleteCv")
    public String deleteCv() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userService.getUserByEmail(authentication.getName());
        Cv cv = this.cvService.getCvByUserByUserId(user);
        this.cvService.delete(cv);
        return "redirect:/user/profile";
    }


    // Chức năng gửi mail xác nhận tài khoản
    @PostMapping("/user/confirm-account")
    public String confirmAccount(@RequestParam("email") String email) {
        try {


            // Gửi mail
            this.emailService.sendSimpleMessage(email, "Xác nhận tài khoản", "Đường dẫn xác thực: http://127.0.0.1:8080/user/confirm-account/" + uuid);
        } catch (Exception e) {
            System.out.println("Lỗi gửi mail" + e.getMessage());
        }
        return "redirect:/user/profile";
    }

    // Chức năng xác nhận tài khoản
    @GetMapping("/user/confirm-account/{id}")
    public String confirmAccountPath(@PathVariable("id") UUID id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userService.getUserByEmail(authentication.getName());

        if(id.equals(uuid)) {
            user.setStatus(1);
            this.userService.update(user);
        }

        return "redirect:/user/profile";
    }

}
