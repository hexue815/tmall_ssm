<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/admin/adminHeader.jsp" %>

<%@include file="../include/admin/adminNavigator.jsp" %>
<html>
<head>
    <title>分类管理</title>
</head>
<body>
    <div class="workingArea">
        <table class="table table-striped table-bordered table-hover table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>图片</th>
                <th>分类名称</th>
                <th>属性管理</th>
                <th>产品管理</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${categories}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td><img height="40px" src="img/category/${c.id}.jpg"></td>
                    <td>${c.name}</td>
                    <td><a href=""><span class="glyphicon glyphicon-th-list"></span></a></td>
                    <td><a href=""><span class="glyphicon glyphicon-shopping-cart"></span></a></td>
                    <td><a href=""><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a href=""><span class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
