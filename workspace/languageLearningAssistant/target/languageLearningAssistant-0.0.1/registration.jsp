<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="parts/header.jsp"%>
<%@include file="parts/head.jsp"%>

<form:form method="POST" commandName="user" action="registerUser">
   <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
        <td style="color:red"><form:errors path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="lastName">Last name</form:label></td>
        <td><form:input path="lastName" /></td>
        <td style="color:red"><form:errors path="lastName" /></td>
    </tr>
    <tr>
        <td><form:label path="nativeLanguage">Native language</form:label></td>
        <td><form:select path="nativeLanguage" items="${languages}" /></td>
        <td style="color:red"><form:errors path="nativeLanguage" /></td>
    </tr>
       <tr>
           <td><form:label path="email">email</form:label></td>
           <td><form:input path="email" /></td>
           <td style="color:red"><form:errors path="email" /></td>
       </tr>
    <tr>
        <td><form:label path="login">login</form:label></td>
        <td><form:input path="login" /></td>
        <td style="color:red"><form:errors path="login" /></td>
    </tr>
    <tr>
        <td><form:label path="password">password</form:label></td>
        <td><form:input path="password" /></td>
        <td style="color:red"><form:errors path="password" /></td>
    </tr>
    <tr>
        <td><form:label path="repeatedPassword">repeated password</form:label></td>
        <td><form:input path="repeatedPassword" /></td>
        <td style="color:red"><form:errors path="repeatedPassword" /></td>
        <td style="color:red"><c:out value='${message}'/></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>

<%@include file="parts/footer.jsp"%>