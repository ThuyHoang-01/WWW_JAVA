package com.se.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.spring.dao.LopDAO;
import com.se.spring.entity.Lop;
import com.se.spring.entity.Sinhvien;

@Service
public class LopServiceImpl implements LopService {
	// Tự động nhúng các Bean liên quan tới LopDao
	// Khi Spring nó sẽ tìm kiếm bean có tên là LopDao trong container của nó, sau
	// đó nhúng (hoặc tiêm) vào lớp LopServiceImpl.
	// Đây chính là cơ chế DI (dependency injection)
	@Autowired
	private LopDAO lopDAO;

	@Override
	@Transactional
	public List<Lop> getLops() {
		return lopDAO.getLops(); // Gọi tới hàm getLops từ lopDao để lấy dữ liệu từ DB
	}

	@Override
	@Transactional
	public List<Sinhvien> getSinhviens(int lopId) {
		return lopDAO.getSinhviens(lopId); // Gọi tới hàm getSinhviens từ lopDao để lấy dữ liệu từ DB
	}

	@Override
	@Transactional
	public Sinhvien getSinhvien(int lopId, int sinhvienId) {
		return lopDAO.getSinhvien(lopId, sinhvienId); // Gọi tới hàm getSinhvien từ lopDao để lấy dữ liệu từ DB
	}

	@Override
	@Transactional
	public void saveLop(Lop theLop) {
		lopDAO.saveLop(theLop); // Gọi tới hàm saveLop từ lopDao để lưu dữ liệu xuống DB
	}

	@Override
	@Transactional
	public Lop getLop(int theId) {
		return lopDAO.getLop(theId); // Gọi tới hàm getLop từ lopDao để lấy dữ liệu từ DB
	}

	@Transactional
	public void deleteLop(int theId) {
		lopDAO.deleteLop(theId); // Gọi tới hàm deleteLop từ lopDao để xóa dữ liệu từ DB
	}
}
