package com.se.spring.service;

import com.se.spring.model.Sinhvien;

public interface SinhvienService { // Tạo interface với các phương thức xử lý với business
	public Sinhvien getSinhvien(int theId); // Hàm trả về đối tượng Sinhvien từ sinhvienId

	public void saveSinhvien(Sinhvien theSinhvien, int lopId); // Hàm save Sinhvien với data từ đối tượng Sinhvien và
																// theo lopId

	public void updateSinhvien(Sinhvien theSinhvien, int lopId); // Hàm update Sinhvien với data từ đối tượng Sinhvien
																	// và theo lopId

	public void deleteSinhvien(int theId); // Hàm xóa Sinhvien từ sinhvienId
}
