<%@include file="parts/header.jsp"%>
<html>
	<!-- HEAD block-->
    <%@include file="parts/head.jsp"%>
	<!-- HEAD block-->
    <body>
    	<div class="wrapper">
        	<div class="header"></div>
			<%@include file="parts/languageBar.jsp" %>
        	<div class="main">
                <h3 class="welcome-text">${SITE_CONTENT[WELCOME_LOGIN]}</h3>
               	<form name="loginForm" action="j_spring_security_check" method="post" class="userLoginForm">
                   	<c:out value="${error}"/>
                   	<c:out value="${message}"/>
                   	<input type="text" name="login" class="form-control">
                   	<input name="password" type="password" class="form-control">
                   	<input type="submit" value="${SITE_CONTENT[ENTER]}" />
					<a href="registration">${SITE_CONTENT[CREATE_NEW_USER]}</a>
				</form>
        	</div>
    	</div>
    	<%@include file="parts/footer.jsp"%>
    </body>
</html>
