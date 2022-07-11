<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
      body {
        background-image: url(${pattern});
      }

      tr th {
        text-align: center;
      }

      tbody {
        text-align: center;
        background: #FF9900;
      }

      caption h1 {
        color: #FF0000;
        background: linear-gradient(to right, #9DD7E1, white, #9DD7E1);
        margin-bottom: 5px;
        margin-top: 0px;
        text-shadow: 3px 4px 5px orange;
      }

      span {
        color: yellow;
        float: right;
        padding-right: 10px;
        margin-top: 15px;
      }

      span a {
        color: yellow;
        float: right;
        padding-right: 10px;
      }

      span a:hover {
        color: white;
      }

      li {
        color: yellow;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="row col-sm-12 col-md-12 col-xl-12">
        <nav class="navbar navbar-inverse ">
          <div class="container-fluid">
            <ul class="nav navbar-nav">
              <c:url var="addUrl" value="/sinhvien/showFormForAdd?lopId=${lop.id}" />
              <c:url var="addSinhvienUrl" value="/sinhvien/showFormForAdd?lopId=${lop.id}" />
              <c:url var="lopUrl" value="/lop/list" />
              <li>
                <a href="${pageContext.request.contextPath}/home">Trang chủ</a>
              </li>
              <li>
                <a href="${lopUrl}">Danh sách Lớp</a>
              </li>
              <li>
                <a href="${addUrl}">Thêm sinh viên</a>
              </li>
            </ul>
            
             <%-- Hiển thị thông tin khi đã đăng nhập --%>
            <security:authorize access="hasAnyRole('MANAGER', 'ADMIN', 'EMPLOYEE')">
              <span> User:
                <security:authentication property="principal.username" />, Role(s):
                <security:authentication property="principal.authorities" />
              </span>
            </security:authorize>
            
            
          </div>
        </nav>
        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
          <input type="submit" value="Logout" />
        </form:form>
        <section class="table-responsive">
          <c:url var="editImgUrl" value="/resources/img/edit.png" />
          <c:url var="deleteImgUrl" value="/resources/img/delete.png" />
          <table class="table table-striped">
            <caption>
              <h1>Danh sách sinh viên của ${lop.tenLop}</h1>
            </caption>
            <thead style="background:#FF9900">
              <tr>
                <th>Mã</th>
                <th>Loại thẻ</th>
                <th>Số thẻ</th>
                <th>Sửa</th>
                
                <%-- Chỉ cho phép Role có quyền Admin dc phép xóa --%>
                <security:authorize access="hasAnyRole('ADMIN')">
                  <th>Xóa</th>
                </security:authorize>
                
                
              </tr>
            </thead>
            <tbody>
            
             <%-- Kiểm tra danh sách Sinhvien tồn tại --%>
              <c:if test="${!empty lop.sinhviens}">
                <c:forEach items="${lop.sinhviens}" var="sinhvien">
                  <tr>
                    <td>
                      <c:out value="${sinhvien.id}" />
                    </td>
                    <td>
                      <c:out value="${sinhvien.hoTen}" />
                    </td>
                    <td>
                      <c:out value="${sinhvien.email}" />
                    </td>
                    <c:url var="editSinhvienUrl" value="/sinhvien/showFormForUpdate?lopId=${lop.id}&sinhvienId=${sinhvien.id}" />
                    <c:url var="deleteSinhvienUrl" value="/sinhvien/delete?sinhvienId=${sinhvien.id}&lopId=${lop.id}" />
                    <td>
                      <a href="${editSinhvienUrl}">
                        <img src="${editImgUrl}" />
                      </a>
                    </td>
                    
                    <%-- Chỉ cho phép Role có quyền Admin dc phép xóa --%>
                    <security:authorize access="hasAnyRole('ADMIN')">
                      <td>
                        <a href="${deleteSinhvienUrl}">
                          <img src="${deleteImgUrl}" />
                        </a>
                      </td>
                    </security:authorize>
                    
                    
                  </tr>
                </c:forEach>
              </c:if>
            </tbody>
          </table>
        </section>
      </div>
    </div>
  </body>
</html>