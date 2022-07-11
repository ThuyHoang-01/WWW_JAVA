package com.se.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

public class Lop {
	private int id;

	@NotNull(message = "Ten Lop khong duoc de trong")
	private String tenLop;

	private List<Sinhvien> Sinhviens;

	public Lop() {

	}

	public Lop(int id, String tenLop) {
		this.id = id;
		this.tenLop = tenLop;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public List<Sinhvien> getSinhviens() { // Hàm trả về List các Sinhvien
		return Sinhviens;
	}

	public Sinhvien getSinhvien(int sinhVienId) { // Hàm trả về đối tượng Sinhvien từ sinhVienId
		if (Sinhviens != null) {
			for (Sinhvien theSinhvien : Sinhviens)
				if (theSinhvien.getId() == sinhVienId)
					return theSinhvien;
		}
		return null;
	}

	public void setSinhviens(List<Sinhvien> sinhviens) { // Hàm set Sinhviens
		this.Sinhviens = sinhviens;
	}

	public void addSinhvien(Sinhvien theSinhvien) { // Hàm add Sinhvien vào ArrayList
		if (Sinhviens == null) {
			Sinhviens = new ArrayList<>();
		}
		Sinhviens.add(theSinhvien);
	}
}
