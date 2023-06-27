<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/design.css">
<head>
    <title>TOP画面</title>
</head>
<body>
${currentUser.name}さんこんにちは。<br>

<div class="contents">
    <a href="/mutter/read">ホーム</a>
    <a href="/mutter/read?name=${currentUser.name}">自分のつぶやき</a>
    <a href="/user/logout">ログアウト</a>
</div>

<br> 
<a href="/mutter/insert" class="btn mutter">つぶやく</a>

<br>

<c:forEach items = "${mutters}" var = "mutter">
    <div class="mutterArea">
        <div class="mutteredBy">
            <a href="/mutter/read?name=${mutter.name}">${mutter.name}</a> <br>
        </div>
        <div class="mutterText">
            ${mutter.text}<br>
        </div>
        <!-- <c:if test="${mutter.name== currentUser.name}">
            <a href="/mutter/read">編集</a>
            <a href="/mutter/read">削除</a>
        </c:if> -->
    </div>
</c:forEach>
</body>
</html>