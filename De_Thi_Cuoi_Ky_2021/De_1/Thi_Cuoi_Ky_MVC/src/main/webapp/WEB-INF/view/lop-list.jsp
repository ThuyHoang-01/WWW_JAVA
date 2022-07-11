<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%> 

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

      caption h1 {
        color: #FF0000;
        background: linear-gradient(to right, #9DD7E1, white, #9DD7E1);
        margin-bottom: 5px;
        margin-top: 5px;
        text-shadow: 3px 4px 5px orange;
      }

      tbody {
        background: #00FFCC;
      }

      nav {
        width: 100%;
        height: 50px;
        background-color: black;
        line-height: 50px;
        text-align: center;
        border-radius: 5px;
      }

      li a {
        text-decoration: none;
        font-weight: bold;
        font-family: Tahoma;
        color: yellow;
      }

      .menu li {
        width: 140px;
        height: 50px;
        float: left;
        list-style: none;
        text-indent: 4px;
        position: relative;
      }

      .menu li:hover {
        background-color: #808080;
      }

      .menu li:hover a {
        color: white;
      }

      span {
        color: yellow;
        float: right;
        padding-right: 10px;
      }

      span a {
        color: yellow;
        float: right;
        padding-right: 10px;
      }

      span a:hover {
        color: white;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <c:url var="editImgUrl" value="/resources/img/edit.png" />
      <c:url var="deleteImgUrl" value="/resources/img/delete.png" />
      <c:url var="viewImgUrl" value="/resources/img/eye.png" />
      <c:url var="addUrl" value="/lop/showFormForAdd" />
      <div class="col-md-12">
        <nav class="nav">
          <ul class="nav navbar-nav">
            <li>
              <a href="${pageContext.request.contextPath}/home">Trang chủ</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/lop/list">Danh sách Lớp</a>
            </li>
            <li>
              <a href="${addUrl}">Thêm Lớp mới</a>
            </li>
          </ul>
          
          <%-- Hiển thị thông tin khi đã đăng nhập --%>
          <security:authorize access="hasAnyRole('EMPLOYEE','MANAGER', 'ADMIN')">
            <span> User:
              <security:authentication property="principal.username" />, Role(s):
              <security:authentication property="principal.authorities" />
            </span>
          </security:authorize>
          
          
        </nav>
        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
          <input type="submit" value="Logout" />
        </form:form>
      </div>
      <div class="col-md-12">
        <section class="table-responsive">
          <table class="table table-striped">
            <caption>
              <h1>Danh sách Lớp</h1>
            </caption>
            <thead style="background: #CC99FF">
              <tr>
                <th style="width: 100px;">Mã lớp</th>
                <th style="width: 200px;">Tên lớp</th>
                <th style="border-radius: 50px; width: 130px; text-align: center;">Sửa</th>
                <th style="border-radius: 50px; width: 130px; text-align: center;">Xóa</th>
                <th style="border-radius: 50px; width: 130px; text-align: center;">Xem danh sách sinh viên</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${lops}" var="lop"> <%-- Duyệt danh sách tất cả các Lớp --%>
                <c:url var="editUrl" value="/lop/showFormForUpdate">
                  <c:param name="lopId" value="${lop.id}" />
                </c:url>
                <c:url var="deleteUrl" value="/lop/delete">
                  <c:param name="lopId" value="${lop.id}" />
                </c:url>
                <c:url var="viewUrl" value="/sinhvien/list">
                  <c:param name="lopId" value="${lop.id}" />
                </c:url>
                <tr>
                  <td>
                    <c:out value="${lop.id}" />
                  </td>
                  <td>
                    <c:out value="${lop.tenLop}" />
                  </td>
                  <td style="border-radius: 50px; text-align: center;">
                    <a href="${editUrl}">
                      <img src="${editImgUrl}" />
                    </a>
                  </td>
                  <td style="border-radius: 50px; text-align: center;">
                    <a href="${deleteUrl}">
                      <img src="${deleteImgUrl}" />
                    </a>
                  </td>
                  <td style="border-radius: 50px; text-align: center;">
                    <a href="${viewUrl}">
                      <img src="${viewImgUrl}" />
                    </a>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </section>
      </div>
    </div>
    <c:if test="${empty lops}"> No records found.</c:if>
  </body>
</html>