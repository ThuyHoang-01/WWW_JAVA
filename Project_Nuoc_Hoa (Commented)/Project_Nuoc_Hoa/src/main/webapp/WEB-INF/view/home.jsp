<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 

<html>
  <head>
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="
				<c:url value='/resources/jquery/jquery-1.12.2.min.js' />">
    </script>
    <script src="
				<c:url value='/resources/bootstrap/bootstrap.min.js' />">
    </script>
    <script src="${ context }/resources/js/jquery.min.js"></script>
    <script src="${ context }/resources/js/jquery-1.10.2.min"></script>
    <script src="${ context }/resources/js/bootstrap.min.js"></script>
    <link href="${ context }/resources/css/css.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title> Quản Lý Nước Hoa </title>
  </head>
  <body>
    <!-- display user name and role --><%--    
					<p>
                User: 
						<security:authentication property="principal.username" />

        Role(s): 
						<security:authentication property="principal.authorities" />
					</p>--%>
    <!--Menu------------------------------------------------------------------------------------------------------>
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" id="navbarDropdown">
            <b>DANH MỤC</b>
            <span class="caret"></span>
          </a>
          <ul class="dropdown-menu">
            <li>
              <a href="#" class="nav-item">Versace</a>
            </li>
            <li>
              <a href="#" class="nav-item">Chanel</a>
            </li>
            <li>
              <a href="#" class="nav-item">Hermes</a>
            </li>
            <li>
              <a href="#" class="nav-item">Gucci</a>
            </li>
            <li>
              <a href="#" class="nav-item">Chloe</a>
            </li>
            <li>
              <a href="#" class="nav-item">Calvin Klein</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="#">
            <b>QUẢN LÝ SẢN PHẨM</b>
          </a>
        </li>
        <li>
          <a href="#">
            <b>QUẢN LÝ HÓA ĐƠN </b>
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
      <form class="navbar-form navbar-left" action="#">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search" name="search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <c:if test="${ principal.username == null }">
          <li>
            <a href="${pageContext.request.contextPath}/register/showRegistrationForm">
              <div class="glyphicon glyphicon-user"></div>Sign Up
            </a>
          </li>
          <li id="gly02">
            <a href="${pageContext.request.contextPath}/showMyLoginPage" data-toggle="modal" data-target="#Login">
              <span class="glyphicon glyphicon-log-in"></span>Login </a>
          </li>
        </c:if>
        <li id="gly03">
          <a href="#">
            <div class="glyphicon glyphicon-shopping-cart"></div> Cart
          </a>
        </li>
        <security:authorize access="hasAnyRole('CUSTOMER', 'EMPLOYEE', 'MANAGER', 'ADMIN')">
          <span> User:
            <security:authentication property="principal.username" />, Role(s):
            <security:authentication property="principal.authorities" /> &nbsp;
          </span>
          <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <input type="submit" value="Logout" />
          </form:form>
        </security:authorize>
      </ul>
    </div>
    <!--end menu-------------------------------------------------------------------------------------------------->
    <div class="modal fade" id="Login" role="dialog">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h2 class="text-danger">ĐĂNG NHẬP</h2>
          </div>
          <div class="modal-body">
            <form id="FormLogin" method="post">
              <table>
                <tr>
                  <td>
                    <label for="txtUser">UserName: </label>
                  </td>
                  <td>
                    <input type="text" id="txtUser" placeholder="Tên đăng nhập" size="30" maxlegth="30" />
                    <span id="user_error"></span>
                  </td>
                </tr>
                <tr>
                  <td>
                    <label for="txtPass">Password: </label>
                  </td>
                  <td>
                    <input type="text" id="txtPass" placeholder="Mật khẩu" size="30" maxlegth="30" />
                    <span id="pass_error"></span>
                  </td>
                </tr>
              </table>
              <br />
            </form>
          </div>
          <div class="modal-footer">
            <center>
              <button type="submit" onClick="LoginF();">Login</button>
            </center>
          </div>
        </div>
      </div>
    </div>
    <div class="carousel_img">
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -------------------------------------------------------------------------------->
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- Wrapper for slides ------------------------------------------------------------------------>
        <div class="carousel-inner">
          <div class="item active">
            <img src="./resources/img/VERSACE-PERFUME.PNG" alt="" style="width:3000px;height:350px;" />
          </div>
          <div class="item">
            <img src="./resources/img/chloe.png" alt="" style="width:3000px;;height:350px;" />
          </div>
          <div class="item">
            <img src="./resources/img/nuochoa.jpg" alt="" style="width:3000px;;height:350px;" />
          </div>
        </div>
      </div>
    </div>
    </header>
    <div class="container-fluid">
      <div class="row">
        <div style="background-color: #ff1493; margin-top: 10px; margin-bottom: 10px; padding-bottom: 10px; padding-top: 10px; overflow: hidden; display: block; border-bottom: 1px solid #f3f3f3; border: 1px solid #ff0000; border-right: 1px solid #ff0000 !important;">
          <h3 style="text-align: center; color: #fff; display: block; width: 100%; margin-top: 0; float: left; margin-bottom: 0; font-weight: 600; font-family: inherit; line-height: 1.2;"> KHUYẾN MÃI HOT</h3>
        </div>
        <div class="row padding">
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/1.jpg" alt="">
              <div class="card-body">
                <a href="#">Nước Hoa Nam Versace Eros Man EDT 5ml </a>
                <br> 250,000₫ <strike style="font-size: 14px; color: #9e9e9e;">375,000₫</strike>
                <span discount="" class="product-item-percent-off">
                  <span discount="">33%</span>
                  <br>
                  <span discount="">OFF</span>
                </span>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/ver2.png" alt="">
              <div class="card-body">
                <a href="">Nước Hoa Nữ Versace 100ml</a> 1,520,000₫ <strike style="font-size: 14px; color: #9e9e9e;">2,700,000₫</strike>
                <span discount="" class="product-item-percent-off">
                  <span discount="">44%</span>
                  <br>
                  <span discount="">OFF</span>
                </span>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/ver1.png" alt="">
              <div class="card-body">
                <a href="#">Nước Hoa Nữ Versace Bright Crystal EDT 5ml </a> 1,220,000₫ <strike style="font-size: 14px; color: #9e9e9e;">2,680,000₫</strike>
                <span discount="" class="product-item-percent-off">
                  <span discount="">44%</span>
                  <br>
                  <span discount="">OFF</span>
                </span>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/ver3.png" alt="">
              <div class="card-body">
                <a href="">Nước Hoa Nữ Versace Bright Crystal EDT 5ml</a> 1,520,000₫ <strike style="font-size: 14px; color: #9e9e9e;">2,860,000₫</strike>
                <span discount="" class="product-item-percent-off">
                  <span discount="">44%</span>
                  <br>
                  <span discount="">OFF</span>
                </span>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/2.jpg" alt="">
              <div class="card-body">
                <a href="">Nước Hoa Nam Versace Eros Man EDT 100ml</a> 1,520,000₫ <strike style="font-size: 14px; color: #9e9e9e;">2,700,000₫</strike>
                <span discount="" class="product-item-percent-off">
                  <span discount="">44%</span>
                  <br>
                  <span discount="">OFF</span>
                </span>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/ver5.png" alt="">
              <div class="card-body">
                <a href="">Nước Hoa Versace Pour Homme Dylan Blue 100ml</a> 1,890,000₫ <strike style="font-size: 14px; color: #9e9e9e;">2,980,000₫</strike>
                <span discount="" class="product-item-percent-off">
                  <span discount="">44%</span>
                  <br>
                  <span discount="">OFF</span>
                </span>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div style="background-color: #ff1493; margin-top: 15px; padding-bottom: 10px; padding-top: 10px; overflow: hidden; display: block; border-bottom: 1px solid #f3f3f3; border: 1px solid #ff0000; border-right: 1px solid #ff0000 !important;">
          <h3 style="text-align: center; color: #fff; display: block; width: 100%; margin-top: 0; float: left; margin-bottom: 0; font-weight: 600; font-family: inherit; line-height: 1.2;"> THƯƠNG HIỆU NỔI BẬT</h3>
        </div>
      </div>
      <div class="row">
        <div style=" margin-top: 15px; margin-left: 10px; padding-bottom: 10px; padding-top: 10px; overflow: hidden; display: block; border-bottom: 1px solid #f3f3f3; border: 1px solid #f3f3f3; border-right: 1px solid #f3f3f3 !important;">
          <h6 style="color: black; display: block; width: 100%; margin-top: 0; float: left; margin-bottom: 0;font-size: 15px; font-weight: 600; font-family: inherit; line-height: 1.2;">VERSACE NỔI BẬT NHẤT</h6>
        </div>
        <div class="row padding">
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/ver1.png" alt="">
              <div class="card-body">
                <a href="">Versace Bright Crystal EDT 5ml</a>
                <a style="color: #ff0000;">1,220,000₫</a>
                <a id="a2">2,680,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/ver2.png" alt="">
              <div class="card-body">
                <a href=""> Versace Yellow Diamond 30ml </a>
                <a style="color: #ff0000;">2,440,000₫</a>
                <a id="a2">3,200,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/ver3.png" alt="">
              <div class="card-body">
                <a href="">Giftset Versace Eros Pour 50ml</a>
                <a style="color: #ff0000;">1,520,000₫</a>
                <a id="a2">2,700,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/ver4.png" alt="">
              <div class="card-body">
                <a href="">Versace Pour Homme Hair 250ml</a>
                <a style="color: #ff0000;">1,520,000₫</a>
                <a id="a2">2,000,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/ver5.png" alt="">
              <div class="card-body">
                <a href=""> Versace Pour Homme Dylan Blue 100ml</a>
                <a style="color: #ff0000;">2,480,000₫</a>
                <a id="a2">2,980,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/1.jpg" alt="">
              <div class="card-body">
                <a href="">Versace Eros Man EDT 100ml</a>
                <a style="color: #ff0000;">1,999,000₫</a>
                <a id="a2">2,700,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/ver6.png" alt="">
              <div class="card-body">
                <a href="">Versace Dylan Blue Pour Femme Eau de Parfum 10ml</a>
                <a style="color: #ff0000;">1,020,000₫</a>
                <a id="a2">1,200,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/ver7.png" alt="">
              <div class="card-body">
                <a href="">Versace Man Eau Fraiche 30ml</a>
                <a style="color: #ff0000;">1,999,000₫</a>
                <a id="a2">2,700,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/ver8.png" alt="">
              <div class="card-body">
                <a href="">Nước Hoa Versace Pour Homme Oud Noir 30ml</a>
                <a style="color: #ff0000;">1,990,000₫</a>
                <a id="a2">4,540,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/ver9.png" alt="">
              <div class="card-body">
                <a href="">Nước Hoa Nữ Versace Crystal Noir 5ml</a>
                <a style="color: #ff0000;">1,850,000₫</a>
                <a id="a2">2,442,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/ver10.png" alt="">
              <div class="card-body">
                <a href="">Nước Hoa Nam Versace Eros Flame 70ml</a>
                <a style="color: #ff0000;">1,870,000₫</a>
                <a id="a2">2,720,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/versace/ver11.png" alt="">
              <div class="card-body">
                <a href="">Versace Eros Pour Femme Eau de Parfum 100ml</a>
                <a style="color: #ff0000;">1,550,000₫</a>
                <a id="a2">1,980,000₫</a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div style=" margin-top: 15px;margin-left: 10px; padding-bottom: 10px; padding-top: 10px; overflow: hidden; display: block; border-bottom: 1px solid #f3f3f3; border: 1px solid #f3f3f3; border-right: 1px solid #f3f3f3 !important;">
          <h6 style="color: black; display: block; width: 100%; margin-top: 0; float: left; margin-bottom: 0;font-size: 15px; font-weight: 600; font-family: inherit; line-height: 1.2;">CHANEL NỔI BẬT NHẤT</h6>
        </div>
        <div class="row padding">
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/chanel/cha1.png" alt="">
              <div class="card-body">
                <a href="">Chanel Coco Eau de Parfum 100ml</a>
                <a style="color: #ff0000;">3,550,000₫</a>
                <a id="a2">3,850,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/chanel/cha2.png" alt="">
              <div class="card-body">
                <a href="">Nước Hoa Nữ Chanel Chance Eau Vive 100ml</a>
                <a style="color: #ff0000;">hết hàng</a>
                <a id="a2">2,750,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/chanel/cha3.png" alt="">
              <div class="card-body">
                <a href="">Nước Hoa Nữ Chanel Coco Noir 100ml</a>
                <a style="color: #ff0000;">3,650,000₫</a>
                <a id="a2">4,200,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/chanel/cha4.png" alt="">
              <div class="card-body">
                <a href="">Nước Hoa Chanel Gabrielle 100ml</a>
                <a style="color: #ff0000;">2,450,000₫</a>
                <a id="a2">3,700,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/chanel/cha5.png" alt="">
              <div class="card-body">
                <a href="">Chanel Chance Eau Fraiche Eau 100ml</a>
                <a style="color: #ff0000;">3,250,000₫</a>
                <a id="a2">3,650,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/chanel/cha6.png" alt="">
              <div class="card-body">
                <a href="">Nước Hoa Nữ Chanel Coco Eau de Parfum 100ml</a>
                <a style="color: #ff0000;">3,350,000₫</a>
                <a id="a2">3,950,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/chanel/cha7.png" alt="">
              <div class="card-body">
                <a href="">Unisex Chanel Le Lion de Chanel 70ml</a>
                <a style="color: #ff0000;">3,250,000₫</a>
                <a id="a2">3,600,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/chanel/cha8.png" alt="">
              <div class="card-body">
                <a href="">Unisex Chanel Coco Eau de Toilette 70ml</a>
                <a style="color: #ff0000;">1,950,000₫</a>
                <a id="a2">2,050,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/chanel/cha9.png" alt="">
              <div class="card-body">
                <a href="">Nước Hoa Chanel Chance Eau Tendre Eau 100ml</a>
                <a style="color: #ff0000;">3,520,000₫</a>
                <a id="a2">3,800,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/chanel/cha10.png" alt="">
              <div class="card-body">
                <a href="">Nước Hoa Nữ Chanel No 5 L'Eau 50ml</a>
                <a style="color: #ff0000;">2,550,000₫</a>
                <a id="a2">3,200,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/chanel/cha11.1.png" alt="">
              <div class="card-body">
                <a href=""> Chanel Allure Homme Sport Eau 100ml</a>
                <a style="color: #ff0000;">980,000₫</a>
                <a id="a2">1,080,000₫</a>
              </div>
            </div>
          </div>
          <div class="col-6 col-sm-4 col-lg-2 ">
            <div class="card">
              <img class="card-img-top" src="./resources/img/chanel/cha12.png" alt="">
              <div class="card-body">
                <a href="#">Nước Hoa Nam Chanel Bleu De Chanel Parfum 100ml</a>
                <a style="color: #ff0000;">1,520,000₫</a>
                <a id="a2">2,700,000₫</a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <br>
      <hr>
      <!--footer---------------------------------------------------------------------------------------->
      <div class="footer">
        <div class="row">
          <div class="col-12 col-sm-6 col-lg-3">
            <h1 class="ftitle"> GIỚI THIỆU </h1>
            <ul id="f1">
              <li>
                <a href=""></a>
              </li>
              <li>
                <a href="">Chịu trách nhiệm nội dung:</a>
              </li>
              <li>
                <a href="">Võ Thành Nhớ </a>
              </li>
              <li>
                <a href="">Hoàng Thị Tố Thùy</a>
              </li>
              <li>
                <a href="">Hoàng Tiến Mạnh Đức</a>
              </li>
              <li>
                <a href="">Phan Nguyễn Tấn Trọng</a>
              </li>
              <li>
                <a href="">Đào Cao Thắng</a>
              </li>
            </ul>
          </div>
          <div class="col-12 col-sm-6 col-lg-3">
            <h1 class="ftitle"> MENU </h1>
            <ul id="f1">
              <li>
                <a href="#">
                  <a>KHUYẾN MÃI
              </li>
              <li>
                <a href="#">
                  <a>SẢN PHẨM MỚI
              </li>
              <li>
                <a href="#">SẢN PHẨM BÁN CHẠY</a>
              </li>
              <li>
                <a href="#">THANH LÝ</a>
              </li>
            </ul>
          </div>
          <h1>Ý KIẾN</h1>
          <input type="email" placeholder="Email của bạn" size="25" style="margin: 10px 0;" />
          <button type="button" class="btn btn-default btn-sm" style="margin:-3px 0 0 -5px; height:30px; display:inline-block;">
            <span class="glyphicon glyphicon-envelope"></span>
          </button>
          <h1>MẠNG XÃ HỘI</h1>
          <div class="social_all">
            <div class="social">
              <a href="#" alt="facebook">
                <img src="./resources/img/fb.png" />
              </a>
            </div>
            <div class="social">
              <a href="#" alt="instagram">
                <img src="./resources/img/ins.png" />
              </a>
            </div>
            <div class="social">
              <a href="#" alt="twitter">
                <img src="./resources/img/tw.png" />
              </a>
            </div>
            <div class="social">
              <a href="#" alt="youtube">
                <img src="./resources/img/yt.png" />
              </a>
            </div>
          </div>
        </div>
        <div class="finfo">
          <p> © 2022 - Công ty TNHH & XNK TC. GPKD số 0158081880 do Sở KH & ĐT TP HỒ CHÍ MINH cấp ngày 19/01/2013 </p>
        </div>
      </div>
    </div>
  </body>
</html>