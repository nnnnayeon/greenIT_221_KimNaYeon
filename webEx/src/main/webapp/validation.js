function checkVal(form){
    let cnt = 0;
    for(let i=0; i<form.choice.length; i++){
        if(form.choice[i].checked){
            cnt ++;
        }
    }
    if(cnt >= 2){
        form.submit();
    }
    else{
        alert("네이버 이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.");
    }
}

// function checkVal(form){
//     if(!jQuery('#mychecked').prop('checked')){
//         alert('필수입니다.');
//         jQuery('#mychecked',form).focus();
//         return false;
//     }
// }