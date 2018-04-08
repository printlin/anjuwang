var contextPath=document.location.pathname.substr(0,document.location.pathname.substr(1).indexOf("/")+1);

$(document).ready(function(){//处理事件
	$("#tel").blur(function(){
		post("tel");
	});
	$("#password").blur(function(){
		post("password");
	});
	$("#chackCode").blur(function(){
		post("chackCode");
	});
	$("#button").click(function(){
		$.post(contextPath+"/servlet/LoginServlet",
	    	{
	    		phomenumber:$("#tel").val(),
	    		password:$("#password").val(),
	    		chackCode:$("#chackCode").val(),
	    		remember:$("#remember").is(':checked'),
	    		type:"submit"
	    	},
	    	function(data,status){
	    		showMes(data);
	    	}
	    );
	});
	$("#chackImg").click(function(){
		var time=new Date();
		$("#chackImg").attr("src",contextPath+"/servlet/ChackCode?time="+time.getTime());
	});
});
function post(who){//发送请求
	$.post(contextPath+"/servlet/LoginServlet",
    	{
    		phomenumber:$("#tel").val(),
    		password:$("#password").val(),
    		chackCode:$("#chackCode").val()
    	},
    	function(data,status){
    		showMes(data,who);
    	}
    );
}
function showMes(data,who){//展示获得的数据
	var json=JSON.parse(data);
	if(json.susses!=null){
		if(json.oldURL!=null){
			window.location.href=contextPath+json.oldURL; 
		}else{
			window.location.href=contextPath+"/servlet/HomeServlet?place=all&page=1"; 
		}
	}else{
		if(who=="tel"){
			if(json.phomenumber!=null){
				$("#telMes").text(json.phomenumber);
			}else{
				$("#telMes").text("");
			}
		}
		
		if(who=="password"){
			if(json.password!=null){
				$("#passwordMes").text(json.password);
			}else{
				$("#passwordMes").text("");
			}
		}
		
		if(who=="chackCode"){
			if(json.chackCode!=null){
				$("#chackCodeMes").text(json.chackCode);
			}else{
				$("#chackCodeMes").text("");
			}
		}
		
		if(json.loginError!=null){
			$("#loginErrorMes").text(json.loginError);
		}else{
			$("#loginErrorMes").text("");
		}
	}
}
