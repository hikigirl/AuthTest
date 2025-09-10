<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
	<style>
		
	</style>
</head>
<body>
	<h1>시작 페이지</h1>
	<div>
		<c:if test="${empty auth}">
		<input type="button" value="로그인" onclick="location.href='/auth/auth/login.do';" />
		</c:if>
		
		<c:if test="${not empty auth}">
		<input type="button" value="로그아웃" onclick="location.href='/auth/auth/logoutok.do';" />
		</c:if>
	</div>
	
	
	<c:if test="${not empty auth}">
	<hr />
	<div class="message short" title="로그인 정보">
		<%-- <div>아이디: <%= session.getAttribute("auth") %></div> --%>
		<div>아이디: ${auth}</div>
		<div>이름: ${name}</div>
		<div>등급: ${grade == '1' ? '일반회원' : grade=='2' ? '관리자' : ''}</div>
	</div>
	</c:if>
	
	
	<hr />
	<!-- 허가: 노출 제어 -->
	<%-- <c:if test="${not empty auth}">
	<div>
		<a href="/auth/member/member.do">회원 전용 페이지</a>
	</div>
	</c:if> --%>
	
	<!-- 허가: 상태 제어 -->
	<c:if test="${empty auth}">
	<div>
		<a href="#!" onclick="alert('로그인 후 접근이 가능합니다.'); location.href='/auth/auth/login.do';">회원 전용 페이지</a>
	</div>
	</c:if>
	
	<c:if test="${not empty auth}">
	<div>
		<a href="/auth/member/member.do">회원 전용 페이지</a>
	</div>
	</c:if>
	
	<c:if test="${not empty auth and grade=='2'}">
	<hr />
	<div>
		<a href="/auth/admin/admin.do">관리자 전용 페이지</a>
	</div>
	</c:if>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>