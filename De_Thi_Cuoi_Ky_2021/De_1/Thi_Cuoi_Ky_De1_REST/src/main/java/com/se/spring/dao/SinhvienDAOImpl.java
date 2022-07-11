package com.se.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.se.spring.entity.Lop;
import com.se.spring.entity.Sinhvien;

@Repository
@EnableTransactionManagement
public class SinhvienDAOImpl implements SinhvienDAO {
	// Cần inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Sinhvien getSinhvien(int theId) {
		// Lấy hibernate session hiện tại
		Session currentSession = sessionFactory.getCurrentSession();
		// Trả về Sinhvien từ DB với khóa chính theId
		Sinhvien sinhvien = currentSession.get(Sinhvien.class, theId);
		return sinhvien;
	}

	@Override
	public void saveSinhvien(Sinhvien sinhvien, int lopId) {
		// Lấy hibernate session hiện tại
		Session currentSession = sessionFactory.getCurrentSession();
		Lop lop = currentSession.get(Lop.class, lopId);
		lop.addSinhvien(sinhvien); // Add Sinhvien theo lop
		currentSession.saveOrUpdate(sinhvien); // Save xuống DB
	}

	@Override
	public void updateSinhvien(Sinhvien tempSinhvien, int lopId) {
		// Lấy hibernate session hiện tại
		Session currentSession = sessionFactory.getCurrentSession();
		Lop lop = currentSession.get(Lop.class, lopId);
		Sinhvien sinhvien = lop.getSinhvien(tempSinhvien.getId());
		setValueSinhvien(sinhvien, tempSinhvien); // Set giá trị mới cho Sinhvien 
		currentSession.saveOrUpdate(sinhvien); // Save xuống DB
	}

	@Override
	public void deleteSinhvien(int theId) {
		// Lấy hibernate session hiện tại
		Session currentSession = sessionFactory.getCurrentSession();
		// Xóa object từ primary key
		Sinhvien tempSinhvien = currentSession.get(Sinhvien.class, theId);
		currentSession.delete(tempSinhvien);
	}

	// ----------------------Private method------------????????????
	private void setValueSinhvien(Sinhvien sinhvien, Sinhvien tempSinhvien) {
		sinhvien.setHoTen(tempSinhvien.getHoTen());
		sinhvien.setEmail(tempSinhvien.getEmail());
	}
}
