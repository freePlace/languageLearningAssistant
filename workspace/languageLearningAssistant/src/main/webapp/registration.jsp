<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="parts/header.jsp"%>
<%@include file="parts/head.jsp"%>

<form:form method="POST" commandName="user" action="registerUser">
   <table>
    <tr>
        <td><form:label path="name">${SITE_CONTENT[NAME]}</form:label></td>
        <td><form:input path="name" /></td>
        <td style="color:red"><form:errors path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="lastName">${SITE_CONTENT[LAST_NAME]}</form:label></td>
        <td><form:input path="lastName" /></td>
        <td style="color:red"><form:errors path="lastName" /></td>
    </tr>
    <tr>
        <td><form:label path="nativeLanguage">${SITE_CONTENT[NATIVE_LANGUAGE]}</form:label></td>
        <td><form:select path="nativeLanguage" items="${languages}" /></td>
        <td style="color:red"><form:errors path="nativeLanguage" /></td>
    </tr>
       <tr>
           <td><form:label path="email">${SITE_CONTENT[EMAIL]}</form:label></td>
           <td><form:input path="email" /></td>
           <td style="color:red"><form:errors path="email" /></td>
       </tr>
    <tr>
        <td><form:label path="login">${SITE_CONTENT[LOGIN]}</form:label></td>
        <td><form:input path="login" /></td>
        <td style="color:red"><form:errors path="login" /></td>
    </tr>
    <tr>
        <td><form:label path="password">${SITE_CONTENT[PASSWORD]}</form:label></td>
        <td><form:input path="password" /></td>
        <td style="color:red"><form:errors path="password" /></td>
    </tr>
    <tr>
        <td><form:label path="repeatedPassword">${SITE_CONTENT[REPEATED_PASSWORD]}</form:label></td>
        <td><form:input path="repeatedPassword" /></td>
        <td style="color:red"><form:errors path="repeatedPassword" /></td>
        <td style="color:red"><c:out value='${message}'/></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="${SITE_CONTENT[CREATE]}"/>
        </td>
    </tr>
</table>  
</form:form>

<%@include file="parts/footer.jsp"%>