package com.QuanLyNguoiDung.QuanLyNguoiDung.service;

import com.QuanLyNguoiDung.QuanLyNguoiDung.dto.ThongTinDangNhapNguoiDungDto;
import com.QuanLyNguoiDung.QuanLyNguoiDung.dto.ThongTinTaoNguoiDungDto;
import com.QuanLyNguoiDung.QuanLyNguoiDung.dto.ResponseDto;
import com.QuanLyNguoiDung.QuanLyNguoiDung.entity.ThongTin;
import com.QuanLyNguoiDung.QuanLyNguoiDung.repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {
    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Override
    public ResponseDto addThongTin(ThongTinTaoNguoiDungDto thongTinTaoNguoiDungDto) {
        ResponseDto responseDto = new ResponseDto();
        try {
            // Kiểm tra tài khoản có bị bỏ trống không
            if (thongTinTaoNguoiDungDto.getTaiKhoan().isEmpty()) {
                responseDto.setStatusCode(400);
                responseDto.setMessage("Tên tài khoản không được để trống");
                responseDto.setContent("");
                responseDto.setDateTime(LocalDateTime.now().toString());
                responseDto.setMessageConstants(null);
                return responseDto;
            }

            // Kiểm tra tài khoản đã tồn tại
            if (nguoiDungRepository.existsByTaiKhoan(thongTinTaoNguoiDungDto.getTaiKhoan())) {
                responseDto.setStatusCode(409);
                responseDto.setMessage("Tên tài khoản đã tồn tại");
                responseDto.setContent("");
                responseDto.setDateTime(LocalDateTime.now().toString());
                responseDto.setMessageConstants(null);
                return responseDto;
            }

            // Thêm tài khoản mới
            ThongTin thongTin = new ThongTin();
            thongTin.setTaiKhoan(thongTinTaoNguoiDungDto.getTaiKhoan());
            thongTin.setMatKhau(thongTinTaoNguoiDungDto.getMatKhau());
            thongTin.setEmail(thongTinTaoNguoiDungDto.getEmail());
            thongTin.setSoDt(thongTinTaoNguoiDungDto.getSoDt());
            thongTin.setMaNhom(thongTinTaoNguoiDungDto.getMaNhom());
            thongTin.setHoTen(thongTinTaoNguoiDungDto.getHoTen());

            thongTin = nguoiDungRepository.save(thongTin);

            responseDto.setStatusCode(201);
            responseDto.setMessage("Tạo tài khoản thành công");
            responseDto.setContent(thongTin);
            responseDto.setDateTime(LocalDateTime.now().toString());
            responseDto.setMessageConstants(null);
        } catch (Exception e) {
            responseDto.setStatusCode(500);
            responseDto.setMessage("Dữ liệu không hợp lệ");
            responseDto.setContent("");
            responseDto.setDateTime(LocalDateTime.now().toString());
            responseDto.setMessageConstants(null);
        }

        return responseDto;
    }

    @Override
    public ResponseDto dangNhapNguoiDung(ThongTinDangNhapNguoiDungDto dangNhapNguoiDungDto) {
        ResponseDto responseDto = new ResponseDto();
        try {
            // Tìm kiếm người dùng theo tài khoản
            Optional<ThongTin> thongTinOptional = nguoiDungRepository.findByTaiKhoan(dangNhapNguoiDungDto.getTaiKhoan());

            if (thongTinOptional.isPresent()) {
                ThongTin thongTin = thongTinOptional.get();
                // Kiểm tra mật khẩu
                if (thongTin.getMatKhau().equals(dangNhapNguoiDungDto.getMatKhau())) {
                    responseDto.setStatusCode(200);
                    responseDto.setMessage("Đăng nhập thành công");
                    responseDto.setContent(thongTin); // Có thể chọn chỉ trả về các thông tin cần thiết
                } else {
                    responseDto.setStatusCode(404);
                    responseDto.setMessage("Tài khoản hoặc mật khẩu không chính xác");
                    responseDto.setContent("");
                }
            } else {
                responseDto.setStatusCode(404);
                responseDto.setMessage("Tài khoản hoặc mật khẩu không chính xác");
                responseDto.setContent("");
            }
        } catch (Exception e) {
            responseDto.setStatusCode(500);
            responseDto.setMessage("Đã xảy ra lỗi trong quá trình đăng nhập");
            responseDto.setContent("");
        }
        responseDto.setDateTime(LocalDateTime.now().toString());
        responseDto.setMessageConstants(null);
        return responseDto;
    }

}
