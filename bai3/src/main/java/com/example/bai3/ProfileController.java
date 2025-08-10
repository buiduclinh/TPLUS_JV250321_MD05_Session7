package com.example.bai3;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@ControllerAdvice(basePackages = "com.example.bai3")
public class ProfileController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/uploadAvatar")
    public String uploadAvatar(@ModelAttribute UserProfile userProfile, Model model) {
        // Gọi service để lưu file
        String filePath = uploadService.uploadFile(userProfile.getAvatar());

        // Thêm dữ liệu vào model để gửi qua view
        model.addAttribute("username", userProfile.getUsername());
        model.addAttribute("avatarPath", filePath);

        return "profileResult"; // JSP hiển thị kết quả
    }
}
