<%-- 
    Document   : person
    Created on : Mar 13, 2021, 7:43:39 PM
    Author     : Trần Thái Minh Tân
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
            tr th{ text-align: center; }
            tbody { 
                text-align: center; 
                background:#FF9900;
            }
            caption h1{ 
                color:#FF0000; 
                background: linear-gradient(to right, #9DD7E1, white, #9DD7E1); 
                margin-bottom: 5px; 
                margin-top: 0px; 
                text-shadow: 3px 4px 5px orange;
            }
            span{ color: yellow; float: right; padding-right: 10px; margin-top: 15px; }
            span a{ color: yellow; float: right; padding-right: 10px; }
            span a:hover{ color: white; }
            li{ color:yellow; }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row col-sm-12 col-md-12 col-xl-12">
                <nav class="navbar navbar-inverse ">
                    <div class="container-fluid">
                        <ul class="nav navbar-nav">
                            <c:url var="addUrl" value="/creditcard/showFormForAdd?personId=${person.id}" />
                            <c:url var="addCcUrl" value="/creditcard/showFormForAdd?personId=${person.id}" />
                            <c:url var="personUrl" value="/person/list" />
                            <li>
                                <a href="${pageContext.request.contextPath}/home">Trang chủ</a>
                            </li>
                            <li>
                                <a href="${personUrl}"}">Danh sách hồ sơ</a>
                            </li>   
                            <security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
                                <li><a href="${addUrl}">Tạo thẻ tín dụng</a></li>
                            </security:authorize>                            
                        </ul>
                        <span>
                            User: <security:authentication property="principal.username" />, Role(s): <security:authentication property="principal.authorities" />
                            &nbsp;<a href="${pageContext.request.contextPath}/showMyLoginPage?logout">Logout</a>
                        </span>
                    </div>
                </nav>
                <section class="table-responsive">
                    <c:url var="editImgUrl" value="/resources/img/edit.png" />
                    <c:url var="deleteImgUrl" value="/resources/img/delete.png" />
                    <table class="table table-striped" >
                        <caption>
                            <h1>Danh sách thẻ tín dụng của ${person.firstName} ${person.lastName}</h1>
                        </caption>
                        <thead style="background:#FF9900">
                            <tr>
                                <th>Mã</th>
                                <th>Loại thẻ</th>
                                <th>Số thẻ</th>
                                <security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
                                    <th>Sửa</th>
                                </security:authorize>
                                <security:authorize access="hasAnyRole('ADMIN')">
                                    <th>Xóa</th>
                                </security:authorize>
                                <!--                                <th colspan="2">Quản lý thẻ</th>-->
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${!empty person.creditCards}">
                                <c:forEach items="${person.creditCards}" var="creditCard">
                                    <tr>
                                        <td><c:out value="${creditCard.id}" /></td>
                                        <td><c:out value="${creditCard.type}" /></td>
                                        <td><c:out value="${creditCard.number}" /></td>                                   
                                        <c:url var="editCcUrl" value="/creditcard/showFormForUpdate?personId=${person.id}&creditCardId=${creditCard.id}" />
                                        <c:url var="deleteCcUrl" value="/creditcard/delete?creditCardId=${creditCard.id}&personId=${person.id}" />
                                        <security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
                                            <td><a href="${editCcUrl}"><img src="${editImgUrl}" /></a></td>
                                        </security:authorize>
                                        <security:authorize access="hasAnyRole('ADMIN')">
                                            <td><a href="${deleteCcUrl}"><img src="${deleteImgUrl}"/></a></td>
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
