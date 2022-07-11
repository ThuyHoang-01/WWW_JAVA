package com.se.nuochoa.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.se.nuochoa.entity.KhachHang;

@Repository // Được sử dụng để nói bean này dùng để truy cập và thao tác xuống cơ sở dữ liệu. 
@EnableTransactionManagement // Kích hoạt tính năng quản lý transaction trong Spring
public class KhachHangDaoImpl implements KhachHangDao {
	// Tự động nhúng các Bean liên quan tới sessionFactory
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<KhachHang> getKhachHangs() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<KhachHang> theQuery = currentSession.createQuery("from KhachHang", KhachHang.class);
		// Thực thi query và trả về list kết quả
		List<KhachHang> khachHang = theQuery.getResultList();
		return khachHang;
	}

	@Override
	public KhachHang getKhachHang(String id) {
		Session currentSession = sessionFactory.getCurrentSession();
		KhachHang khachHang = currentSession.get(KhachHang.class, id);
		return khachHang;
	}

	@Override
	public void saveKhachHang(KhachHang khachHang) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(khachHang);
	}

	@Override
	public void deleteKhachHang(String theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		KhachHang khachhang = currentSession.get(KhachHang.class, theId);
		currentSession.delete(khachhang);
	}

	@Override
	public KhachHang getKhachHangByName(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<KhachHang> query = currentSession.createQuery("from KhachHang where tenKhachHang=:namekh");
		query.setParameter("namekh", name);
		KhachHang khachHang = (KhachHang) query.uniqueResult();
		return khachHang;
	}

}
