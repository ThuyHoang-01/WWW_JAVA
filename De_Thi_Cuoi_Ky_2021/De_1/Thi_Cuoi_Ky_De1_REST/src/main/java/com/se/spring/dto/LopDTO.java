/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.spring.dto;

import java.util.List;

import com.se.spring.entity.Lop;
import com.se.spring.entity.Sinhvien;

public class LopDTO {
	private Lop lop;
	private List<Sinhvien> sinhviens;

	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}

	public List<Sinhvien> getSinhviens() {
		return sinhviens;
	}

	public void setSinhviens(List<Sinhvien> sinhviens) {
		this.sinhviens = sinhviens;
	}
}
