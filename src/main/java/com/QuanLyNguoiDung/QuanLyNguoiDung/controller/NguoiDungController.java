package com.QuanLyNguoiDung.QuanLyNguoiDung.controller;

import com.QuanLyNguoiDung.QuanLyNguoiDung.dto.ResponseDto;
import com.QuanLyNguoiDung.QuanLyNguoiDung.dto.ThongTinDangNhapNguoiDungDto;
import com.QuanLyNguoiDung.QuanLyNguoiDung.dto.ThongTinTaoNguoiDungDto;
import com.QuanLyNguoiDung.QuanLyNguoiDung.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/QuanLyNguoiDung")
public class NguoiDungController {
    @Autowired
    private NguoiDungService nguoiDungService;

    @PostMapping("/DangKy")
    public ResponseDto DangKy(@RequestBody ThongTinTaoNguoiDungDto thongTinTaoNguoiDungDto){
        return nguoiDungService.addThongTin(thongTinTaoNguoiDungDto);
    }

    @PostMapping("/DangNhap")
    public ResponseDto DangNhap(@ModelAttribute ThongTinDangNhapNguoiDungDto thongTinDangNhapNguoiDungDto){
        return nguoiDungService.dangNhapNguoiDung(thongTinDangNhapNguoiDungDto);
    }
}
