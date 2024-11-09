package com.QuanLyNguoiDung.QuanLyNguoiDung.repository;

import com.QuanLyNguoiDung.QuanLyNguoiDung.entity.ThongTin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NguoiDungRepository extends JpaRepository<ThongTin, Long> {
    Optional<ThongTin> findByTaiKhoan(String taiKhoan);
    boolean existsByTaiKhoan(String taiKhoan);
}
