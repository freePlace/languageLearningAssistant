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
                <h3>Welcome! Please log-in below:</h3>

                <div ID="userLoginForm">
                    <form name="loginForm" action="j_spring_security_check" method="post">
                        <c:out value="${error}"/>
                        <c:out value="${message}"/>
                        <input type="text" name="login" class="form-control" id="inputSuccess">
                        <input name="password" type="password" class="form-control" id="inputSuccess">
                        <input type="submit" value="Login"/>
                    </form>
                    <a href="registration">Create new user</a>
                </div>
            </div>
        </div>

    </div>
        <%@include file="parts/footer.jsp"%>
    </body>
</html>
