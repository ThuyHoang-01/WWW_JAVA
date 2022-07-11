package com.se.spring.service;

import java.util.List;

import com.se.spring.model.Lop;
import com.se.spring.model.Sinhvien;

public interface LopService { // Tạo interface với các phương thức xử lý với business
	public List<Lop> getLops(); // Hàm trả về list các Lop

	public List<Sinhvien> getSinhviens(int lopId); // Hàm trả về list các Sinhvien từ 1 lớp với lopId

	public Sinhvien getSinhvien(int lopId, int sinhvienId); // Hàm trả về đối tượng Sinhvien từ 1 lớp với lopId và từ
															// sinhvienId

	public void saveLop(Lop theLop); // Hàm save Lop

	public Lop getLop(int theId); // Hàm trả về đối tượng Lop từ lopId

	public void deleteLop(int theId); // Hàm xóa Lop từ lopId
}
