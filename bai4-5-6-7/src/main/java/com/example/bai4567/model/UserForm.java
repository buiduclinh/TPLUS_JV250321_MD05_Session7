package com.example.bai4567.model;

import com.example.bai4567.validation.ValidEmail;
import com.example.bai4567.validation.ValidPhone;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserForm {
    @NotNull(message = "Tên không được null")
    @NotBlank(message = "Tên không được để trống")
    private String username;

    @NotNull(message = "Email không được null")
    @NotBlank(message = "Email không được để trống")
    @ValidEmail // Sử dụng validator tùy chỉnh cho email
    private String email;

    @NotNull(message = "Mật khẩu không được null")
    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 8, message = "Mật khẩu phải ít nhất 8 ký tự")
    private String password;

    @NotNull(message = "Số điện thoại không được null")
    @NotBlank(message = "Số điện thoại không được để trống")
    @ValidPhone // Validator tùy chỉnh cho số điện thoại
    private String phone;
}
