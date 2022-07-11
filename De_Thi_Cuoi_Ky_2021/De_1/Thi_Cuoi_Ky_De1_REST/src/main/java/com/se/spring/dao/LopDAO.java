package com.se.spring.dao;

import java.util.List;

import com.se.spring.entity.Lop;
import com.se.spring.entity.Sinhvien;

public interface LopDAO { // Tạo interface với các phương thức xử lý với Database cho Lop
	public List<Lop> getLops(); // Hàm trả về list các Lop

	public void saveLop(Lop theLop); // Hàm save Lop

	public Lop getLop(int theId); // Hàm trả về đối tượng Lop từ lopId

	public void deleteLop(int theId); // Hàm xóa Lop từ lopId
	
	
	
	public List<Sinhvien> getSinhviens(int lopId); // Hàm trả về list các Sinhvien từ 1 lớp với lopId

	public Sinhvien getSinhvien(int lopId, int sinhvienId); // Hàm trả về đối tượng Sinhvien từ 1 lớp với lopId và từ sinhvienId
}
