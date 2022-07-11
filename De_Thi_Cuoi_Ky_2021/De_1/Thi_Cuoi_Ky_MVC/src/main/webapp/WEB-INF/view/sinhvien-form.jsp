<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 

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

      .error {
        color: red
      }
    </style>
  </head>
  <body>
    <div class="modal-dialog">
      <div class="modal-header">
        <h1 style="text-align: center">Thông tin Sinh viên</h1>
      </div>
      <div class="modal-body">
      
      	<%-- Xử lý sự kiện khi Save mới hoặc Update Sinhvien --%>
        <c:url var="saveUrl" value="/sinhvien/saveSinhvien?lopId=${lopId}" />
        <c:if test="${isUpdate}">
          <c:url var="saveUrl" value="/sinhvien/updateSinhvien?lopId=${lopId}" />
        </c:if>
        
        <form:form modelAttribute="sinhvien" method="POST" action="${saveUrl}">
          <form:hidden path="id" />  <%-- Cho phép field id ẩn vì id tự động tăng --%>
          
          <div class="form-group">
            <label class="control-label col-xs-3">Họ Tên: </label>
            <form:input path="hoTen" class="form-control" placeholder="Nhập Họ Tên sinh viên" />
            <form:errors path="hoTen" cssClass="error" />
          </div>
          <div class="form-group">
            <label class="control-label col-xs-3">Email: </label>
            <form:input path="email" class="form-control" placeholder="Nhập Email sinh viên" />
            <form:errors path="email" cssClass="error" />
          </div>
          <div class="modal-footer">
            <input type="submit" value="Lưu" class="btn btn-success btn-block" />
            <a href="${pageContext.request.contextPath}/sinhvien/list?lopId=${lopId}" style="color: white; text-decoration: underline">Trở về danh sách Sinh Viên</a>
          </div>
        </form:form>
      </div>
    </div>
  </body>
</html>