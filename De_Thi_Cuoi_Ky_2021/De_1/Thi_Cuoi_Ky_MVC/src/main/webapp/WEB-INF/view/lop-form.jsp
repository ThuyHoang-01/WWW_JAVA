<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
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
        <h1 style="text-align: center">Thông tin Lớp</h1>
      </div>
      <div class="modal-body">
        <c:url var="saveUrl" value="/lop/saveLop" />
        
        <%-- Model Attribute được nhận từ Controller --%>
        <%-- Thực thi action saveUrl khi click Lưu --%>
        <form:form modelAttribute="lop" method="POST" action="${saveUrl}"> 
        
          <form:hidden path="id" /> <%-- Cho phép field id ẩn vì id tự động tăng --%>
        
          <div class="form-group">
            <label class="control-label col-xs-3">Tên lớp: </label>
            <form:input path="tenLop" class="form-control" placeholder="Nhập tên lớp" />
            <form:errors path="tenLop" cssClass="error" />
          </div>
          
          <div class="modal-footer">
            <input type="submit" value="Lưu" class="btn btn-success btn-block" />
            <a href="${pageContext.request.contextPath}/lop/list" style="color: white; text-decoration: underline">Trở về danh sách Lớp</a>
          </div>
        </form:form>
      </div>
    </div>
  </body>
</html>