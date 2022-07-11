package com.se.nuochoa.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.nuochoa.user.CrmUser;

@Controller
@RequestMapping("/register") // Trang được bắt đầu bằng /register
public class RegistrationController {
	
	// Tự động nhúng các Bean liên quan tới userDetailsManager
	@Autowired
	private UserDetailsManager userDetailsManager;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Thực thi encode password

	private Logger logger = Logger.getLogger(getClass().getName());

	// Cấu hình ràng buộc các tham số yêu cầu với một đối tượng mô hình
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	// Cấu hình trang register
	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model theModel) {
		theModel.addAttribute("crmUser", new CrmUser());
		return "registration-form";
	}

	// Cấu hình đăng kí account
	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CrmUser theCrmUser,
			BindingResult theBindingResult, Model theModel) {

		String userName = theCrmUser.getUserName();
		logger.info("Processing registration form for: " + userName);

		// Thực thi validate nhập form
		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("crmUser", new CrmUser());
			theModel.addAttribute("registrationError", "User name/password can not be empty.");
			logger.warning("User name/password can not be empty.");
			return "registration-form";
		}

		// Ktra database đã tồn tại user hay chưa
		boolean userExists = doesUserExist(userName);
		if (userExists) {
			theModel.addAttribute("crmUser", new CrmUser());
			theModel.addAttribute("registrationError", "User name already exists.");
			logger.warning("User name already exists.");
			return "registration-form";
		}

		//
		// Sau khi đã pass các bước validate
		// Đi xuống tới xử lý business
		//

		// Mã hóa password
		String encodedPassword = passwordEncoder.encode(theCrmUser.getPassword());

		// Thêm trước password đã mã hóa bằng chuỗi thuật toán mã hóa
		encodedPassword = "{bcrypt}" + encodedPassword;

		// Gán role mặc định cho user mới là "EMPLOYEE"
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");

		// Tạo user object (từ Spring Security framework)
		User tempUser = new User(userName, encodedPassword, authorities);

		// Save user vào trong database
		userDetailsManager.createUser(tempUser);

		logger.info("Successfully created user: " + userName);

		return "registration-confirmation";
	}

	// Hàm ktra User đã tồn tại chưa
	private boolean doesUserExist(String userName) {
		logger.info("Checking if user exists: " + userName);
		// Check database user đã tồn tại chưa
		boolean exists = userDetailsManager.userExists(userName);
		logger.info("User: " + userName + ", exists: " + exists);
		return exists;
	}

}
