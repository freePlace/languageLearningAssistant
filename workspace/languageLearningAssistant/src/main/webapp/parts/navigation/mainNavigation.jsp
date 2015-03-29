<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="/main"><c:out value="${projectName}"/></a>
	</div>

	<ul class="nav navbar-top-links navbar-right">
		<jsp:include page="parts/navigation/messageMenu.jsp"></jsp:include>
		<jsp:include page="parts/navigation/taskMenu.jsp"></jsp:include>
		<jsp:include page="parts/navigation/alert.jsp"></jsp:include>
		<jsp:include page="parts/navigation/userMenu.jsp"></jsp:include>
	</ul>

	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<jsp:include page="parts/navigation/search.jsp"></jsp:include>
				<li><a href=""><i class="fa fa-dashboard fa-fw"></i>${SITE_CONTENT[MAIN]}</a>
				</li>
				<li><a href=""><i class="fa fa-table fa-fw"></i>${SITE_CONTENT[STATISTICS]}</a>
				<li><a href=""><i class="fa fa-table fa-fw"></i>${SITE_CONTENT[TRAININGS]}</a>
				</li>
				<li><a href=""><i class="fa fa-edit fa-fw"></i>${SITE_CONTENT[COURSES]}</a></li>
			</ul>
		</div>
	</div>
</nav>