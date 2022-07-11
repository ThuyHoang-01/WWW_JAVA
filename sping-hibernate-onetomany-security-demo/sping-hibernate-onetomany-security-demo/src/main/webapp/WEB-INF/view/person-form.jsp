<%-- 
    Document   : person-form
    Created on : Mar 13, 2021, 9:42:35 PM
    Author     : Trần Thái Minh Tân
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
    <head>
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap2.min.css"  rel="stylesheet" type="text/css">
        <script src="<c:url value='/resources/jquery/jquery-3.3.1.min.js' />" ></script>
        <script src="<c:url value='/resources/bootstrap/bootstrap2.min.js' />" ></script>
        <c:url var="pattern" value="/resources/img/bg.jpg" />
        <style>
            body{ background-image: url(${pattern}); }
        </style>
    </head>
    <body>
        <div class="modal-dialog">

            <div class="modal-header">
                <h1 style="text-align: center">Tạo hồ sơ mới</h1>
            </div>
            <div class="modal-body">
                <c:url var="saveUrl" value="/person/savePerson" />


                <form:form modelAttribute="person" method="POST" action="${saveUrl}">
                    <form:hidden path="id" />
                    <div class="form-group">
                        <label class="control-label col-xs-3">Họ</label>
                        <form:input path="firstName" class="form-control" placeholder="Nhập họ"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3">Tên</label>
                        <form:input path="lastName" class="form-control" placeholder="Nhập tên"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3">Số tiền</label>
                        <form:input path="money" class="form-control" placeholder="Nhập số tiền"/>
                    </div>
                    <div class="modal-footer">
                        <input type="submit" value="Lưu" class="btn btn-success btn-block" />
                        <a href="${pageContext.request.contextPath}/person/list"
                           style="color: white; text-decoration: underline">Trở về danh sách người dùng</a>
                    </div>
                </form:form>

            </div>

        </div>
    </body>
</html>
