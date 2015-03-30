<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<li class="dropdown">
    <a id="userMessages" class="dropdown-toggle" data-toggle="dropdown" href="/#">
        <i class="fa fa-envelope fa-fw"></i>
	    <i class="fa fa-caret-down"></i>
    </a>

    <ul class="dropdown-menu dropdown-messages">
		<li><a href="">
				<div>
					<strong>${SITE_CONTENT[AUTHOR]}</strong> <span class="pull-right text-muted">
						<em>${SITE_CONTENT[DATE_TIME]}</em>
					</span>
				</div>
				<div>Text of message...</div>
		</a></li>
		<li class="divider"></li>
	</ul> <!-- /.dropdown-messages --></li>

<script>
    $("#userMessages").click(function(){
        $.ajax({url:"main/getMessages",success:function(result){
            alert('Date: ' + jQuery.parseJSON(JSON.stringify(result)));
    //        alert('Text: ' + jQuery.parseJSON(result.messagesInfo).message0.text + '<br />');
      //      alert('Author: ' + jQuery.parseJSON(result.messagesInfo).message0.author + '<br />');
        }});
        return false;
    });
</script>