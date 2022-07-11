package com.se.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.se.spring.entity.Lop;
import com.se.spring.entity.Sinhvien;

@Repository
@EnableTransactionManagement
public class LopDAOImpl implements LopDAO {
	// Cần phải inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Lop getLop(int theId) {
		// Lấy hibernate session hiện tại
		Session currentSession = sessionFactory.getCurrentSession();
		// Trả về Lop từ DB với khóa chính theId
		Lop lop = currentSession.get(Lop.class, theId);
		return lop;
	}

	@Transactional
	@Override
	public List<Lop> getLops() {
		// Lấy hibernate session hiện tại
		Session currentSession = sessionFactory.getCurrentSession();
		// Tạo query
		Query<Lop> theQuery = currentSession.createQuery("from Lop order by id", Lop.class);
		// Thực thi query và lấy result list
		List<Lop> lops = theQuery.getResultList();
		// Trả về kết quả list Lop
		return lops;
	}

	@Override
	public void saveLop(Lop lop) {
		// Lấy hibernate session hiện tại
		Session currentSession = sessionFactory.getCurrentSession();
		// Save/Update Lop
		currentSession.saveOrUpdate(lop);
	}

	@Override
	public List<Sinhvien> getSinhviens(int lopId) {
		Lop lop = getLop(lopId);
		List<Sinhvien> sinhviens = lop.getSinhviens();
		return sinhviens;
	}

	@Override
	public Sinhvien getSinhvien(int lopId, int sinhvienId) {
		Lop lop = getLop(lopId);
		if (lop != null) {
			return lop.getSinhvien(sinhvienId);
		} else {
			return null;
		}
	}

	@Override
	public void deleteLop(int theId) {
		// Lấy hibernate session hiện tại
		Session currentSession = sessionFactory.getCurrentSession();
		Lop tempLop = currentSession.get(Lop.class, theId);
		currentSession.delete(tempLop);
	}
}
