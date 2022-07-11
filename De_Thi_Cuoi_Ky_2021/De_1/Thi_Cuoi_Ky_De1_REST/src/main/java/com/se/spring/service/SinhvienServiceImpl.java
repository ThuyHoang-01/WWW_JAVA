package com.se.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.spring.dao.SinhvienDAO;
import com.se.spring.entity.Sinhvien;

@Service
public class SinhvienServiceImpl implements SinhvienService {
	// Tự động nhúng các Bean liên quan tới SinhvienDao
	// Khi Spring nó sẽ tìm kiếm bean có tên là SinhvienDao trong container của nó, sau đó nhúng (hoặc tiêm) vào lớp SinhvienServiceImpl.
	// Đây chính là cơ chế DI (dependency injection)
	@Autowired
	private SinhvienDAO sinhvienDAO;

	@Override
	@Transactional
	public Sinhvien getSinhvien(int theId) {
		return sinhvienDAO.getSinhvien(theId); // Gọi tới hàm getSinhvien từ sinhvienDAO để lấy dữ liệu từ DB
	}

	@Override
	@Transactional
	public void saveSinhvien(Sinhvien theSinhvien, int lopId) {
		sinhvienDAO.saveSinhvien(theSinhvien, lopId); // Gọi tới hàm saveSinhvien từ sinhvienDAO để lưu dữ liệu xuống DB
	}

	@Override
	@Transactional
	public void updateSinhvien(Sinhvien theSinhvien, int lopId) {
		sinhvienDAO.updateSinhvien(theSinhvien, lopId); // Gọi tới hàm updateSinhvien từ sinhvienDAO để cập nhật dữ liệu xuống DB
	}

	@Override
	@Transactional
	public void deleteSinhvien(int theId) {
		sinhvienDAO.deleteSinhvien(theId); // Gọi tới hàm deleteSinhvien từ sinhvienDAO để xóa dữ liệu từ DB
	}
}
