<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/admin/adminHeader.jsp"%>
<%@ include file="../include/admin/adminNavigator.jsp"%>
<title>编辑产品</title>
<script>
  $(function() {
    $("#editForm").submit(function() {
      if (!checkEmpty("name", "产品名称"))
        return false;
      if (!checkEmpty("subTitle", "小标题"))
        return false;
      if (!checkNumber("originalPrice", "原价格"))
        return false;
      if (!checkNumber("promotePrice", "优惠价格"))
        return false;
      if (!checkInt("stock", "库存"))
        return false;
      return true;
    });
  });
</script>

<div class="workingArea">
  <ol class="breadcrumb">
    <li><a href="admin_category_list">所有分类</a></li>
    <li><a href="admin_prouduct_list?cid=${category.id}">${product.name}</a></li>
    <li class="active">编辑产品</li>
  </ol>

  <div class="panel panel-warning editDiv">
    <div class="panel-heading">编辑产品</div>
    <div class="panel-body">
      <form action="admin_product_update" method="post" id="editForm">
        <table class="editTable">
          <tr>
            <td>产品名称</td>
            <td><input type="text" name="name" id="name" value="${product.name}" class="form-control"></td>
          </tr>
          <tr>
            <td>产品小标题</td>
            <td><input type="text" id="subTitle" name="subTitle" class="form-control" value="${product.subTitle}"></td>
          </tr>
          <tr>
            <td>原价格</td>
            <td><input type="text" id="originalPrice" name="originalPrice" class="form-control" value="${product.originalPrice}"></td>
          </tr>
          <tr>
            <td>优惠价格</td>
            <td><input type="text" id="promotePrice" name="promotePrice" class="form-control" value="${product.promotePrice}"></td>
          </tr>
          <tr>
            <td>库存</td>
            <td><input type="text" id="stock" name="stock" class="form-control" value="${product.stock}"></td>
          </tr>
          <tr>
            <td><input type="hidden" name="id" value="${product.id}"></td>
            <td><input type="hidden" name="cid" value="${category.id}"></td>
            <td><button type="submit" class="btn btn-success">提 交</button></td>
          </tr>
        </table>
      </form>
    </div>
  </div>
</div>