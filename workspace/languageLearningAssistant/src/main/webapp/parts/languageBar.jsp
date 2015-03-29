<%@ page language="java" contentType="text/html;charset=utf-8"
         pageEncoding="utf-8"%>
<div id="language-bar">
    <ul>
        <c:forEach var="language" items="${sessionScope.get('languages')}">
            <li>
                <a href="/changeLanguage?language=${language}">${language}</a>
            </li>
        </c:forEach>
    </ul>
</div>