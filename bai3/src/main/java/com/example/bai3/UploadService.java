package com.example.bai3;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@Service
public class UploadService {

    // Đường dẫn thư mục lưu file (thay đổi theo cấu hình của bạn)
    private final String UPLOAD_DIR = "C:/uploads/";

    public String uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        }
        try {
            // Tạo thư mục nếu chưa tồn tại
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Lấy tên file gốc
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            // Đường dẫn file lưu
            File destination = new File(UPLOAD_DIR + fileName);

            // Lưu file
            file.transferTo(destination);

            // Trả về đường dẫn file để hiển thị ảnh
            return "/uploads/" + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}