package com.se.nuochoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.nuochoa.dao.KhachHangDao;
import com.se.nuochoa.entity.KhachHang;

@Service
public class KhachHangServiceImpl implements KhachHangService {
	// Tự động nhúng các Bean liên quan tới KhachHangDao
	// Khi Spring nó sẽ tìm kiếm bean có tên là KhachHangDao trong container của nó ,sau đó nhúng (hoặc tiêm) vào lớp KhachHangServiceImpl. 
	// Đây chính là cơ chế DI (dependency injection)
	@Autowired
	private KhachHangDao khachHangDao;

	@Override
	@Transactional
	public List<KhachHang> getKhachHangs() {
		return khachHangDao.getKhachHangs();
	}

	@Override
	@Transactional
	public KhachHang getKhachHang(String theId) {
		return khachHangDao.getKhachHang(theId);
	}

	@Override
	@Transactional
	public void saveKhachHang(KhachHang khachHang) {
		khachHangDao.saveKhachHang(khachHang);
	}

	@Override
	@Transactional
	public void deleteKhachHang(String theId) {
		khachHangDao.deleteKhachHang(theId);
	}
	
	@Override
	@Transactional
	public KhachHang getKhachHangByName(String string) {
		return khachHangDao.getKhachHangByName(string);
	}

}
