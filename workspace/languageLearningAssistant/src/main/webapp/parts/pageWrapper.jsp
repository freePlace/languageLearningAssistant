<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<div id="page-wrapper">
	<div id="content" ondblclick="alert($('#pl-dbox-ajax-content-title').text());
	alert($('#pl-dbox-ajax-content-title').next().text());">
        temp value
    </div>
	<%@include file="comments.jsp"%>
    <%@include file="dictionaries/dictionaryBox.jsp"%>
</div>
