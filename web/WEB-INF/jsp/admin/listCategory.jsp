<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/admin/adminHeader.jsp" %>

<%@include file="../include/admin/adminNavigator.jsp" %>

    <title>分类管理</title>
    <script>
        $(function () {
            $("#addForm").submit(function () {
                if (!checkEmpty("name", "分类名称"))
                    return false;
                if (!checkEmpty("categoryPic", "分类图片"))
                    return false;
            });
        });
    </script>
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
                    <td><a href="admin_category_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" href="admin_category_delete?id=${c.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp"%>
    </div>

    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增分类</div>
        <div class="panel-body">
            <form action="/admin_category_add" method="post" enctype="multipart/form-data" id="addForm">
                <table class="addTable">
                    <tr>
                        <td>分类名称</td>
                        <td><input type="text" name="name" id="name" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>分类图片</td>
                        <td>
                            <input type="file" name="image" id="categoryPic" accept="image/*">
                        </td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <%@include file="../include/admin/adminFooter.jsp"%>


































