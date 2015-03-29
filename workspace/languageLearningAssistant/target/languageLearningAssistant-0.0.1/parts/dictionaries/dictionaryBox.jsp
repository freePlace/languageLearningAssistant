<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!-- begin dictionary box -->
<link rel="stylesheet" type="text/css" media="all"
	href="http://dictionarybox.com/dic_box_v3.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script type="text/javascript" src="http://dictionarybox.com/dic_box.js"></script>
<script>
	var tmp;
</script>
<div id="pl-dbox">
	<a class="pl-dbox-title" href="javascript:void(0);dboxCursorLoc();">
		<span id="pl-dbox-title-text">Dictionary</span>
	</a>
	<div id="pl-dbox-content">
		<div id="pl-dboxFlags">
			<ul>
				<li><img src="http://dictionarybox.com/flags/English.png"
					alt="english" /></li>
				<li><img src="http://dictionarybox.com/flags/Russian.png"
					alt="Russian" /></li>
				<li><h3>English Russian Dictionary</h3></li>
			</ul>
		</div>
		<div id="pl-dbox-ajax-content">
			<p class="info">Double click on any word on the page or type a
				word:</p>
			<p>
				<input type="text" name="pl-dbox-search-field"
					style="width: 97%; color: black" id="pl-dbox-search-field"
					onKeyPress="return dbxChkKy(event);" autocomplete=off />
			</p>
			<p id="pl-dbox-search-button">
				<input type="button" value=" Search! " OnClick="getdboxResults();" />
			</p>
		</div>
		<input id="pl-dbox-glossary" type="hidden"
			value="EnglishToRussian,RussianToEnglish" />
		<div id="pl-dbox-credit">
			Powered by <a href="http://www.dictionarybox.com">DictionaryBox.com</a>
		</div>
	</div>
</div>
<!-- end dictionary box -->