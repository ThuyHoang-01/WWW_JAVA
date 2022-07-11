<%-- 
    Document   : credit-form
    Created on : Mar 14, 2021, 10:48:21 AM
    Author     : Trần Thái Minh Tân
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                <h1 style="text-align: center">Thẻ tín dụng</h1>
            </div>
            <div class="modal-body">

                <c:url var="saveUrl" value="/creditcard/saveCard?personId=${personId}" />
                <c:if test= "${isUpdate}">
                    <c:url var="saveUrl" value="/creditcard/updateCard?personId=${personId}" />
                </c:if> 
                <form:form modelAttribute="creditCardAttribute" method="POST" action="${saveUrl}">
                    <form:hidden path="id" />
                    <div class="form-group">
                        <label class="control-label col-xs-3">Loại thẻ</label>
                        <form:input path="type" class="form-control" placeholder="Nhập loại thẻ"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3">Mã số</label>
                        <form:input path="number" class="form-control" placeholder="Nhập mã số"/>
                    </div>
                    <div class="modal-footer">
                        <input type="submit" value="Lưu" class="btn btn-success btn-block" />
                        <a href="${pageContext.request.contextPath}/creditcard/list?personId=${personId}"
                           style="color: white; text-decoration: underline">Trở về danh sách thẻ tín dụng</a>
                    </div>
                </form:form>
            </div>

        </div>
    </body>
</html>
