<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<li class="dropdown"><a class="dropdown-toggle"
	data-toggle="dropdown" href=""> <i class="fa fa-user fa-fw"></i> <i
		class="fa fa-caret-down"></i>
</a>
	<ul class="dropdown-menu dropdown-user">
		<li><a href="#" id="userProfile"><i class="fa fa-user fa-fw"></i> User Profile</a>
		</li>
		<li><a href=""><i class="fa fa-gear fa-fw"></i> Settings</a></li>
		<li class="divider"></li>
		<li>
			<a href='j_spring_security_logout'> Logout</a>
		</li>
	</ul></li>
<script>
	$("#userProfile").click(function(){
	  $.ajax({url:"main/userProfileInfo",success:function(result){
	    $('#content').html('Name: ' + jQuery.parseJSON(result.userInfo).name + '<br />')
	                 .append('Last name: ' + jQuery.parseJSON(result.userInfo).lastName + '<br />')
	                 .append('Email: ' + jQuery.parseJSON(result.userInfo).email + '<br />')
	                 .append('Login: ' + jQuery.parseJSON(result.userInfo).login + '<br />')
	                 .append('Role: ' + jQuery.parseJSON(result.userInfo).role);
	  }});
        return false;
	});
</script>