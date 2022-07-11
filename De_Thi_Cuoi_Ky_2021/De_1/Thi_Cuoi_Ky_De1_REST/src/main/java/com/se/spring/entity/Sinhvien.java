package com.se.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sinhvien")
public class Sinhvien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Id tự động tăng
	@Column(name = "id")
	private int id;

	@Column(name = "hoten")
	private String hoTen;

	@Column(name = "email")
	private String email;

	@Column(name = "malop")
	private String maLop;

	public Sinhvien() {

	}

	public Sinhvien(int id, String hoTen, String email, String maLop) {
		this.id = id;
		this.hoTen = hoTen;
		this.email = email;
		this.maLop = maLop;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
}
