<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="check.do" method="post">
	<c:choose>
		<c:when test="${mb_id != null}">
			<!-- 로그아웃 -->
			<li>${mb_id}님,환영합니다!</li>&nbsp;&nbsp;
			<input type="hidden" name="action" value="logout">
			<input type="submit" value="로그아웃">
		</c:when>
		<c:when test="${ad_id != null }">
			<li>${ad_id}님,환영합니다!</li>&nbsp;&nbsp;
			<input type="hidden" name="action" value="logout">
			<input type="submit" value="로그아웃">
		</c:when>
		<c:otherwise>
			<!-- 로그인 -->
			<input type="hidden" name="action" value="login">
			<li>LOGIN</li>&nbsp;&nbsp;
			<input type="text" name="uid">&nbsp;
			<input type="password" name="passwd">&nbsp;
			<input type="submit" value="로그인">
		</c:otherwise>
	</c:choose>
</form>