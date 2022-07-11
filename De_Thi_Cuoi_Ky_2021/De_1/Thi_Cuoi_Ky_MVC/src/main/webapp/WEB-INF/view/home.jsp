<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap2.min.css" rel="stylesheet" type="text/css">
    <script src="
					<c:url value='/resources/jquery/jquery-3.3.1.min.js' />">
    </script>
    <script src="
					<c:url value='/resources/bootstrap/bootstrap2.min.js' />">
    </script>
    <c:url var="pattern" value="/resources/img/bg.jpg" />
    <style>
      * {
        margin: 0px auto;
        padding: 0px;
      }

      body {
        background-image: url(${pattern});
      }

      span a {
        padding-right: 10px;
        color: white;
        padding-top: 14px;
      }

      section {
        background: linear-gradient(to right, pink, white, blue);
        width: 100%;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="row col-sm-12 col-md-12 col-xl-12">
        <nav class="navbar navbar-inverse">
          <div class="container-fluid">
            <ul class="nav navbar-nav">
              <li>
                <a href="${pageContext.request.contextPath}/home">Trang chủ</a>
              </li>
              <li>
                <a href="${pageContext.request.contextPath}/lop/list">Danh sách Lớp</a>
              </li>
            </ul>
            <span>
            
              <security:authorize access="hasAnyRole('EMPLOYEE','MANAGER', 'ADMIN')">
                <style>
                  span a {
                    display: none;   <%-- Neu da Login roi thi hien thi khong hien thi nut Dang nhap --%>
                  }
                </style>
              </security:authorize>
              
              <%-- Neu chua Login thi hien thi Nut Dang nhap --%>
              <a style="float: right" href="${pageContext.request.contextPath}/showMyLoginPage">Đăng nhập</a> 
              
            </span>
          </div>
        </nav>
        <section class="table-responsive">
          <caption>
            <h2> Thi cuối kỳ Home Page</h2>
          </caption>
        </section>
      </div>
    </div>
  </body>
</html>