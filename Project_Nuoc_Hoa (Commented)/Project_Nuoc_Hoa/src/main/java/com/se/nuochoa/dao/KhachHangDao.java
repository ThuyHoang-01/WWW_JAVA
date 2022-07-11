package com.se.nuochoa.dao;

import java.util.List;

import com.se.nuochoa.entity.KhachHang;

// Tạo interface với các phương thức xử lý với Database
public interface KhachHangDao {
    public KhachHang getKhachHangByName(String name);
    public List<KhachHang> getKhachHangs();
    public KhachHang getKhachHang(String theId);
    public void saveKhachHang(KhachHang khachHang);
    public void deleteKhachHang(String theId);
}
