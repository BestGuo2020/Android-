var oBtn = document.getElementById("btn");
var oMobMenu = document.getElementById("menu-mobile");
oBtn.onclick = function(){
	$menu = $(".menu-mobile").css("display");
	if($menu == "none"){
		oMobMenu.style.display = "block";
	}
	else{
		oMobMenu.style.display = "none";
	}
}
// alert(oBtn.style);
var $dis = $("#btn").css("display");
// 监听按钮是否消失
function listener(){
	if($dis == 'none'){
		oMobMenu.style.display = 'none';
		// console.log($dis == 'none');
	}
	// 获取样式的变化
	$dis = $("#btn").css("display");
}
setInterval(listener,100); // 设置定时器，监听按钮的变化

function about(){
	alert("小组成员：陈成伟、江凯、洪文圣、詹金昊、林旭涛、郭赫\n界面设计：陈成伟，詹金昊，洪文圣\n素材收集：陈成伟，江凯，林旭涛\njs逻辑交互：郭赫");
}