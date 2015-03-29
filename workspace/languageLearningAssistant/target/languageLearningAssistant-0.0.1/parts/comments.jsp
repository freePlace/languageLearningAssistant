<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="panel panel-default">
	<div class="panel-heading">
		Add:
	</div>
	<div>
		<textarea class="form-control" rows="10" name="comment" id="commentMessage"></textarea>
		<div align="right">
			<input type="submit" id="addComment" value="Submit comment" class="btn btn-success" />
		</div>	
	</div>	
	<div class="panel-heading" id="comments">
		Comments:
		<c:forEach var="comment" items="${comments}">
			<div class="panel-heading"> ${comment.user.login}</div>
			<div>${comment.message}</div>
			<div>${comment.date}</div>
		</c:forEach>
	</div>
</div>
<script>
    $("#addComment").click(function(){
        $.ajax({url:"main/addComment?commentMessage="+$('#commentMessage').text,success:function(result){
            $('#comments').append(('Login: ' + jQuery.parseJSON(result.comment).login + '<br />'))
                    .append(('commentMessage: ' + jQuery.parseJSON(result.comment).commentMessage + '<br />'))
                    .append(('date: ' + jQuery.parseJSON(result.comment).time + '<br />'));
        }});
    });
</script>