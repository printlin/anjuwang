var contextPath=document.location.pathname.substr(0,document.location.pathname.substr(1).indexOf("/")+1);

$(document).ready(function(){//处理事件
	$("#tel").blur(function(){
		post("tel");
	});
	$("#user").blur(function(){
		post("user");
	});
	$("#password").blur(function(){
		post("password");
	});
	$("#repassword").blur(function(){
		if(!($("#password").val()==$("#repassword").val())){
			$("#repassword").val("");
			$("#repasswordMes").text("两次输入密码不一致");
		}
	});
	$("#chackCode").blur(function(){
		post("chackCode");
	});
	$("#button").click(function(){
		$.post(contextPath+"/servlet/RegistServlet",
	    	{
	    		phomenumber:$("#tel").val(),
	    		nickname:$("#user").val(),
	    		password:$("#password").val(),
	    		repassword:$("#repassword").val(),
	    		chackCode:$("#chackCode").val(),
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
	$.post(contextPath+"/servlet/RegistServlet",
    	{
    		phomenumber:$("#tel").val(),
    		nickname:$("#user").val(),
    		password:$("#password").val(),
    		repassword:$("#repassword").val(),
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
		window.location.href="./servlet/MessageServlet?message=注册成功&url=Login.jsp"; 
	}else{
		if(who=="tel"){
			if(json.phomenumber!=null){
				$("#telMes").text(json.phomenumber);
			}else{
				$("#telMes").text("");
			}
		}
		
		if(who=="user"){
			if(json.nickname!=null){
				$("#userMes").text(json.nickname);
			}else{
				$("#userMes").text("");
			}
		}
		
		if(who=="password"){
			if(json.password!=null){
				$("#passwordMes").text(json.password);
			}else{
				$("#passwordMes").text("");
			}
		}
		
		if(json.repassword!=null){
			$("#repasswordMes").text(json.repassword);
		}else{
			$("#repasswordMes").text("");
		}
		
		if(who=="chackCode"){
			if(json.chackCode!=null){
				$("#chackCodeMes").text(json.chackCode);
			}else{
				$("#chackCodeMes").text("");
			}
		}
		
		if(json.addError!=null){
			$("#addErrorMes").text(json.addError);
		}else{
			$("#addErrorMes").text("");
		}
	}
}
