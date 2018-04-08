/**
 * 
 */
var width=0;
var bannum=1;
var bannerGo=setInterval(function() {setBanner();}, 2500);


function setBanner(){
	width=-bannum*document.getElementById("banner1").offsetWidth;
	document.getElementById("bannerbod").style.left=width+"px";
	
	var bannernum=document.getElementById("bannernum");
	if(bannum==0){
		document.getElementById("point"+Number(bannernum.value)).style.opacity=0.4;
	}else{
		document.getElementById("point"+bannum).style.opacity=0.4;
	}
	bannum=bannum+1;
	document.getElementById("point"+bannum).style.opacity=1;
	if(bannum==Number(bannernum.value)){
		bannum=0;
	}
	//console.warn(bannum+"fjbsj  "+);
}

function pointClick(point){
	var bannernum=document.getElementById("bannernum");
	for(i=1;i<=Number(bannernum.value);i++){
		document.getElementById("point"+i).style.opacity=0.4;
	}
	document.getElementById("point"+point).style.opacity=1;
	bannum=point-1;
	width=-bannum*document.getElementById("banner1").offsetWidth;
	document.getElementById("bannerbod").style.left=width+"px";
}
