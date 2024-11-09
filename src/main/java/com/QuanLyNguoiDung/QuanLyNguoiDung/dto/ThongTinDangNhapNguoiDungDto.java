package com.QuanLyNguoiDung.QuanLyNguoiDung.dto;

import lombok.Data;

@Data
public class ThongTinDangNhapNguoiDungDto {
    private String taiKhoan;
    private String matKhau;

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
