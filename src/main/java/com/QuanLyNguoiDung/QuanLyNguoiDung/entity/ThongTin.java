package com.QuanLyNguoiDung.QuanLyNguoiDung.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ThongTin")
public class ThongTin {
    @Id
    @Column(name = "id_name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idName;

    @Column(name = "tai_Khoan")
    private String taiKhoan;

    @Column(name = "mat_Khau")
    private String matKhau;

    private String email;

    @Column(name = "so_Dt")
    private String soDt;

    @Column(name = "ma_Nhom")
    private String maNhom;

    @Column(name = "ho_Ten")
    private String hoTen;

    public long getIdName() {
        return idName;
    }

    public void setIdName(long idName) {
        this.idName = idName;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDt() {
        return soDt;
    }

    public void setSoDt(String soDt) {
        this.soDt = soDt;
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
}
