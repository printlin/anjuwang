$(function(){
	var ob=$("#audit tr td[class='audit']");
	ob.each(function(i){
		var id=$(this).children([name='ord_id']).val();
		$(this).children([name='button']).click(function(){
			var oid=$(this).parent().children([name='ord_id']).val();
			var pass =$(this).parent().children([name='isPass'][checked='checked']).val(); 
			alert(oid);
			var request= $.ajax({
				url:"servlet/CompanyManagerDoServlet",
				method:"post",
				data:{type:"audit",ord_id:oid,isPass:pass}
			});
			request.done(function(msg) {
				if(msg=="success"){
					$(this).parent().find("span").text("成功");
				}else{
					alert(msg);
				}
			});
		});
	});
	
	$("#messageButton").click(function(){
		var mid=$("#mes_id").val();
		var answer = $("input[name='answer']").val();
		var request= $.ajax({
			url:"servlet/CompanyManagerDoServlet",
			method:"post",
			data:{type:"message",mes_id:mid,answer:answer}
		});
		request.done(function(msg ) {
			if(msg=="success"){
				$("#messageMsg").text("成功");
			}else{
				alert(msg);
			}
		});
	});
	$("#goingAuditButton").click(function(){
		
		var oid=$("#ord_id").val();alert(oid);
		var audit = $("#goingAudit option:selected").val();
		var request= $.ajax({
			url:"servlet/CompanyManagerDoServlet",
			method:"post",
			data:{type:"goingAudit",ord_id:oid,audit:audit}
		});
		request.done(function(msg ) {
			if(msg=="success"){
				$("#goingAuditMsg").text("成功");
			}else{
				alert(msg);
			}
		});
	});
	$("#reportButton").click(function(){
		var oid=$("#ord_id").val();
		var report = $("#report option:selected").val();
		var request= $.ajax({
			url:"servlet/CompanyManagerDoServlet",
			method:"post",
			data:{type:"report",ord_id:oid,report:report}
		});
		request.done(function(msg ) {
			if(msg=="success"){
				$("#reportMsg").text("成功");
			}else{
				alert(msg);
			}
		});
	});
});