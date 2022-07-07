
function checkVal(form){
   // let cnt =0;
	 /*  for(let i=0; i<form.check.length; i++){    
	        if(form.check[i].checked){
	            cnt++;
	        }
	    }
	    if(cnt===0){
	        alert("최소한 1개 이상 선택해야 합니다.")
	    }else{
	        form.submit();
	    }*/
	
	if(form.check1.checked && form.check2.checked){
		/*alert("필수항목을 모두 체크 해야 합니다.")*/
		form.submit();
	}
	else{
		$('.hide').css('display','block');
	}

}

$(document).ready(function(){
	
	$('.checkAll').click(function(){
		if($('.checkAll').is(':checked')){
			$('.check').prop("checked",true);
		}else{
			$('.check').prop("checked",false);
		}
		
	})
	
	$('.check').click(function(){
		const total = $('.check').length;
		const checked=$('.check:checked').length;
		
		if(total != checked){
			$('.checkAll').prop('checked',false);
		}else{
			$('.checkAll').prop('checked',true);
		}
		
	})
	
	
})

function cancle(){
	location.href = '_00.index.jsp';
}

/*function password(){
	var regExp = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;
	let p1=$('.password').val();
	
	if(regExp.test(p1)){
		$('.warning').css('display','block');
		$('.password').css('background-image','url(image/lock_2.png)');
	}else{
		$('.warning').css('display','none');
		$('.password').css('background-image','url(image/lock_3.png)');
	}
}*/





