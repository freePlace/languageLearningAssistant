<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<div id="footer" style="display: table;margin: 0 auto;">
	<c:if test="${not empty authorName}">
		Developed by <a href="https://github.com/freePlace/"><c:out value="${authorName}"/></a>, 2015
	</c:if>
</div>