package com.QuanLyNguoiDung.QuanLyNguoiDung.service;

import com.QuanLyNguoiDung.QuanLyNguoiDung.dto.ThongTinDangNhapNguoiDungDto;
import com.QuanLyNguoiDung.QuanLyNguoiDung.dto.ThongTinTaoNguoiDungDto;
import com.QuanLyNguoiDung.QuanLyNguoiDung.dto.ResponseDto;

public interface NguoiDungService {
    ResponseDto addThongTin(ThongTinTaoNguoiDungDto dangKyDto);
    ResponseDto dangNhapNguoiDung(ThongTinDangNhapNguoiDungDto dangNhapNguoiDungDto);
}
