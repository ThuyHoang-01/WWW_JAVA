package com.se.nuochoa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity // Mọi entity đề phải gắn @Entity. Hibernate sẽ dựa vào thôn tin này để mapping xuống một bảng trong database
@Table(name = "khachHang")
public class KhachHang {
	@Column(name = "maKhachHang")
	@Id // mỗi Entity đề phải có một id, id dùng để định danh, phân biệt giữa các bản ghi với nhau
	// Đã là id thì nó phải unique. Id là được dùng để làm khóa chính của bảng
	@NotNull(message = "Mã Khách hàng không được để trống")
	@Pattern(regexp = "^KH(\\d{3,4})$", message = "Mã khách hàng không đúng định dạng")
	private String makh;
	
	@Column(name = "tenKhachHang")
	@NotNull(message = "Tên Khách hàng không được để trống")
	private String tenKhachHang;
	
	// -----------------------------------Ktra ràng buộc data Phone Number---------------------------------------
	@Column(name = "soDienThoai")
	@NotNull(message = "Không được để trống")
	@Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "Số điện thoại không đúng định dạng của Vietnam")
	private String soDienThoaikh;

	// -----------------------------------Ktra ràng buộc data Email---------------------------------------
	@Column(name = "email")
	@NotNull(message = "Email không được để trống")
	@Email(message = "Email không đúng định dạng")
	private String email;
	
	// -----------------------------------Ktra ràng buộc data Dia chi---------------------------------------
	@Column(name = "diaChi")
	@NotNull(message = "Địa chỉ không được để trống")
	private String diaChi;

	public KhachHang() {
	}

	public KhachHang(String makh, String tenKhachHang, String soDienThoaikh, String email, String diaChi) {
		this.makh = makh;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoaikh = soDienThoaikh;
		this.email = email;
		this.diaChi = diaChi;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSoDienThoaikh() {
		return soDienThoaikh;
	}

	public void setSoDienThoaikh(String soDienThoaikh) {
		this.soDienThoaikh = soDienThoaikh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
}
