<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <link type="text/css" href="${pageContext.request.contextPath}/resources/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.min"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <link type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title> Quản Lý Nước Hoa </title>
  </head>
  <body>
    <div class="container">
      <header style="height:550px">
        <div>
          <a href="../html/indexAdmin.html">
            <img class="im" src="../img/logo.png" alt="" style="width:150px;height:150px;" />
          </a>
          <div class="box">
            <form class="sbox" action="/search" method="get">
              <input class="stext" type="stext" name="q" placeholder="Tìm kiếm nước hoa...">
              <a class="sbutton" type="submit" href="javascript:void(0);">
                <i class="fa fa-search"></i>
              </a>
            </form>
            <ul class="nav navbar-nav navbar-right">
              <li>
                <a href="${pageContext.request.contextPath}/register/showRegistrationForm">
                  <div class="glyphicon glyphicon-user"></div> Sign Up
                </a>
              </li>
              <li id="gly02">
                <a href="#" data-toggle="modal" data-target="#Login">
                  <span class="glyphicon glyphicon-log-in"></span> Login </a>
              </li>
              <li id="gly03">
                <a href="#">
                  <div class="glyphicon glyphicon-shopping-cart"></div> Cart
                </a>
              </li>
              <li id="gly04" onClick="LogoutF();">
                <a href="#">
                  <div class="glyphicon glyphicon-log-out"></div> Logout
                </a>
              </li>
            </ul>
          </div>
        </div>
        <!--Menu------------------------------------------------------------------------------------------------------>
        <div>
          <ul class="snip1490">
            <li>
              <a href="#">
                <b>QUẢN LÝ SẢN PHẨM </b>
              </a>
            </li>
            <li>
              <a href="#">
                <b> QUẢN LÝ HÓA ĐƠN </b>
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/khachhang/list">
                <b> QUẢN LÝ KHÁCH HÀNG </b>
              </a>
            </li>
            <li>
              <a href="#">
                <b> THỐNG KÊ </b>
              </a>
            </li>
          </ul>
        </div>
        <!--end menu-------------------------------------------------------------------------------------------------->
        <div class="cl"></div>
      </header>
  </body>
</html>