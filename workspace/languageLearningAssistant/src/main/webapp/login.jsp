<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="parts/header.jsp"%>
<html>
    <%@include file="parts/head.jsp"%>
    <body>
        <div class="header"></div>
        <%@include file="parts/languageBar.jsp"%>
        <div ID="enter">
        <h3>${SITE_CONTENT[WELCOME_LOGIN]}</h3>
        <div>
            <form name="loginForm" action="j_spring_security_check" method="post">
                <c:out value="${error}"/>
                <c:out value="${message}"/>
                <input type="text" name="login" class="form-control"
                    id="inputSuccess">
                <input name="password" type="password" class="form-control" id="inputSuccess">
                <input type="submit" value="${SITE_CONTENT[ENTER]}" />
            </form>
        </div>
        <a href="registration">${SITE_CONTENT[CREATE_NEW_USER]}</a>
        </div>
        <%@include file="parts/footer.jsp"%>
    </body>
</html>
