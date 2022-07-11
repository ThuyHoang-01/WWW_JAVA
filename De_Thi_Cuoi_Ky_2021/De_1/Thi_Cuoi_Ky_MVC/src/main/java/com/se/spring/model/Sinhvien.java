package com.se.spring.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class Sinhvien {
	private int id;

	@NotNull(message = "Ho Ten khong duoc de trong")
	private String hoTen;

	@NotNull(message = "Email khong duoc de trong")
	@Email(message = "Email khong dung dinh dang")
	private String email;

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
