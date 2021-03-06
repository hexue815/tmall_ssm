<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<a href="${contextPath}">
    <img src="img/site/logo.gif" class="logo" id="logo">
</a>

<form action="foresearch" method="post">
    <div class="searchDiv">
        <input name="keyword" type="text" value="${param.keyword}" placeholder="时尚男鞋    太阳镜">
        <button type="submit" class="searchButton">搜索</button>
        <div class="searchBelow">
            <c:forEach items="${cs}" var="c" varStatus="st">
                <c:if test="${st.count>=5 and st.count<=8}">
                    <span>
                        <a href="forecategory?cid=${c.id}">${c.name}</a>
                        <c:if test="${st.count!=8}">
                            <span>|</span>
                        </c:if>
                    </span>
                </c:if>
            </c:forEach>
        </div>
    </div>
</form>