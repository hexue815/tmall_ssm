<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>


    <script>

    </script>
    <title>属性管理</title>
    <div class="workingArea">
      <ol class="breadcrumb">
        <li><a href="admin_category_list">所有分类</a></li>
        <li><a href="admin_property_list?cid=${category.id}">${category.name}</a></li>
        <li class="active">属性管理</li>
      </ol>

      <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover table-condensed">
          <thead>
            <tr class="success">
              <td>ID</td>
              <td>属性名称</td>
              <td>编辑</td>
              <td>删除</td>
            </tr>
          </thead>
            <tbody>
                <c:forEach items="${properties}" var="p">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td><a href="admin_property_edit?id=${p.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                        <td><a href="admin_property_delete?id=${p.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
      </div>

        <div class="pageDiv">
            <%@include file="../include/admin/adminPage.jsp"%>
        </div>

    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增属性</div>
        <div class="panel-body"></div>
        <form action="admin_property_add" method="post" id="addForm">
            <table class="addTable">
                <tr>
                    <td>属性名称</td>
                    <td><input type="text" id="name" name="name" class="form-control"></td>
                </tr>
                <tr class="submitTR">
                    <td colspan="2" align="center">
                        <input type="hidden" name="cid" value="${category.id}">
                        <button type="submit" class="btn btn-success">提 交</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    </div>

