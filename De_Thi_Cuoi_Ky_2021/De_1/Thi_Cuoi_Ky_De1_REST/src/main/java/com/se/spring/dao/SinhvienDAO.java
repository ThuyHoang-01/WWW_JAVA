package com.se.spring.dao;

import com.se.spring.entity.Sinhvien;

public interface SinhvienDAO { // Tạo interface với các phương thức xử lý với Database cho Sinhvien
	public Sinhvien getSinhvien(int theId); // Hàm trả về đối tượng Sinhvien từ sinhvienId

	public void saveSinhvien(Sinhvien theSinhvien, int lopId); // Hàm save Sinhvien với data từ đối tượng Sinhvien và theo lopId

	public void updateSinhvien(Sinhvien theSinhvien, int lopId); // Hàm update Sinhvien với data từ đối tượng Sinhvien và theo lopId

	public void deleteSinhvien(int theId); // Hàm xóa Sinhvien từ sinhvienId
}
