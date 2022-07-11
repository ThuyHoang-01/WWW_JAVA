<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
  <head>
    <title> WELCOME TO CUSTOMER MANAGER </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/responsive.css">
    <style>
      #ertk,
      #ermk {
        color: #ff0000;
      }

      input[type=text] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        box-sizing: border-box;
      }

      input[type=submit] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
      }

      input[type=submit]:hover {
        background-color: #45a049;
      }

      .error {
        color: red
      }
    </style>
  </head>
  <body style="background-image: url(${pageContext.request.contextPath}/resources/images/customer_background.jpg)">
    <table style="border: 1px solid; width: 100%; text-align:center">
      <header>
        <div class="top">
          <div class="container">
            <div class="row">
              <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                <p> Chào mừng đến với WEBISTE bán nước hoa </p>
              </div>
              <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                <div class="main-menu-header">
                  <div id="nav-menu">
                    <ul>
                      <li>
                        <a href="#">Cửa hàng</a>
                      </li>
                      <li>
                        <a href="#" data-toggle="modal" data-target="#btnmodal">Đăng nhập</a>
                      </li>
                      <li>
                        <a href="#">Tài Khoản</a>
                        <ul>
                          <li>
                            <a href="<%=request.getContextPath()%>/dangky">Đăng ký </a>
                          </li>
                          <li>
                            <a href="<%=request.getContextPath()%>/giohang.jsp">Giỏ Hàng </a>
                          </li>
                          <li>
                            <a href="<%=request.getContextPath()%>/doimatkhau.jsp">Đổi mật khẩu </a>
                          </li>
                        </ul>
                      </li>
                      <li>
                        <a href="<%=request.getContextPath()%>/lienhe.jsp">Liên hệ </a>
                      </li>
                    </ul>
                    <div class="clear"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h1 class="card-title">Điền thông tin khách hàng. (*) không được bỏ trống.</h1>
                <div class="table-responsive">
                  <c:url var="saveUrl" value="/khachhang/saveKhachHang" />
                  <form:form modelAttribute="khachhang" method="POST" action="${saveUrl}">
                    <table>
                      <tr>
                        <td>
                          <form:label path="makh">-Mã KH(*): </form:label>
                        </td>
                        <td style="width: 92%">
                          <form:input path="makh" cssClass="form-control" />
                          <form:errors path="makh" cssClass="error" />
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <form:label path="tenKhachHang">-Họ tên(*): </form:label>
                        </td>
                        <td>
                          <form:input path="tenKhachHang" cssClass="form-control" />
                          <form:errors path="tenKhachHang" cssClass="error" />
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <form:label path="soDienThoaikh">-Số điện thoại(*): </form:label>
                        </td>
                        <td>
                          <form:input path="soDienThoaikh" cssClass="form-control" />
                          <form:errors path="soDienThoaikh" cssClass="error" />
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <form:label path="email">-Email(*): </form:label>
                        </td>
                        <td>
                          <form:input path="email" cssClass="form-control" />
                          <form:errors path="email" cssClass="error" />
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <form:label path="diaChi">-Địa chỉ(*): </form:label>
                        </td>
                        <td>
                          <form:input path="diaChi" cssClass="form-control" />
                          <form:errors path="diaChi" cssClass="error" />
                        </td>
                      </tr>
                    </table>
                    <input type="submit" value="Save" />
                  </form:form>
    </table>
    </div>
    </div>
    </div>
    </div>
    </div>
    <div class="overlay toggle-menu"></div>
  </body>
</html>