<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<li class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="">
        <i class="fa fa-user fa-fw"></i>
        <i class="fa fa-caret-down"></i>
    </a>
	<ul class="dropdown-menu dropdown-user"  ng-controller="userMenu">
		<li>
            <a href="#" id="userProfile" ng-click="data.doClick()">
                <i class="fa fa-user fa-fw"></i> ${SITE_CONTENT[USER_PROFILE]}
            </a>
		</li>
		<li><a href=""><i class="fa fa-gear fa-fw"></i> ${SITE_CONTENT[SETTINGS]}</a></li>
		<li class="divider"></li>
		<li>
			<a href='j_spring_security_logout'> ${SITE_CONTENT[LOGOUT]}</a>
		</li>
	</ul>
</li>

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
<script>
    angular.module("lla", [])
            .controller("userMenu", function($scope, $http) {
                $scope.data = {};
                $scope.data.doClick = function() {
                    var responsePromise = $http.get("/main/userProfileInfo");
                    responsePromise.success(function(data) {
                        alert(angular.fromJson(data.userInfo).name);
                    });
                    responsePromise.error(function() {
                        alert("AJAX failed!");
                    });
                }
            } );
</script>