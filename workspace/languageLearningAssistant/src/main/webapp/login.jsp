<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="parts/header.jsp"%>
<html>
    <%@include file="parts/head.jsp"%>
    <head>
        <link rel="stylesheet" type="text/css" href="src/main/webapp/resources/styles/main.css"/>
    </head>
    <body>
    <div class="wrapper">
        <div class="header"></div>        
        <%@include file="parts/languageBar.jsp" %>
        <div class="main">
            <div ID="enter">
                <h3>${SITE_CONTENT[WELCOME_LOGIN]}</h3>
                <div ID="userLoginForm">
                    <form name="loginForm" action="j_spring_security_check" method="post">
                        <c:out value="${error}"/>
                        <c:out value="${message}"/>
                        <input type="text" name="login" class="form-control" id="inputSuccess">
                        <input name="password" type="password" class="form-control" id="inputSuccess">
                        <input type="submit" value="${SITE_CONTENT[ENTER]}" />
                    </form>
                    <a href="registration">${SITE_CONTENT[CREATE_NEW_USER]}</a>
                </div>
            </div>
        </div>
    </div>
        <%@include file="parts/footer.jsp"%>
    </body>
</html>
