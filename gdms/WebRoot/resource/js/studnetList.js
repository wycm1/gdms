// 全选、全不选
function chioceAll(value) {
	var chioce = document.getElementsByName("checkbox");
	for (var i=0; i < chioce.length; i++) {
		if (value.checked == true) {
			chioce[i].checked = true;
		} else{
			chioce[i].checked = false;			
		}
	};
};