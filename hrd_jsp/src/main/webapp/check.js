/**
 * 
 */
 
function checkAll(){
	var obj = document.form;
	
	if(obj.custname.value == ""){
		alert("회원 성명이 입력되지 않았습니다.");
		obj.custname.focus();
		return false;
	}
	
	if(obj.phone.value == ""){
		alert("회원 번호가 입력되지 않았습니다.");
		obj.phone.focus();
		return false;
	}
	
	if(obj.city.value == ""){
		alert("회원 도시코드가 입력되지 않았습니다.");
		obj.city.focus();
		return false;
	}

}