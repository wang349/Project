function listener(eleId,eventType,fun){

	document.getElementById(eleId).addEventListener(eventType,fun,false);
}

function validateEmpty(eleId){
	obj =document.getElementById(eleId);

	if (obj!=null) {
		if (obj.value!="") {
			obj.className="right";
			return true;
		}else{
			obj.className="wrong";
			return false;
		}
	}
	return false;
}
function validateRegex(eleId,regex){
	
	if (validateEmpty(eleId)) {

		obj =document.getElementById(eleId);
		if (regex.test(obj.value)) {
			obj.className="right";
			return true;
		}else{
			obj.className="wrong";
			return false;
		}
	}
	return false;
}

function validateCheckbox(eleId){
	count =0;
	obj =document.all(eleId);
	if (obj.length==undefined) {
		if (obj.checked) {
			count++;
		}
	}else{		
		for (var x = 0 ; x < obj.length ; x ++) {
			if (obj[x].checked==true) {
				count ++ ;
			}
		}
	}
	return count>0;
}
function checkboxSelectAll(ctrId,eleId){
	ctrObject=document.getElementById(ctrId);
	eleObject=document.all(eleId);
	if(eleObject.length==undefined){
		eleObject.checked=ctrObject.checked;
	}else{
		for (x = 0; x < eleObject.length; x++) {
			eleObject[x].checked=ctrObject.checked;
		}
	}
}
function handleDelete(eleId,delUrl){
	eleObject=document.all(eleId);
	idsValue="";
	if(eleObject.length==undefined){
		if(eleObject.checked){
			idsValue +=eleObject.value;
		}
	}else{
		for(x=0;x<eleObject.length;x++){
			if(eleObject[x].checked){
				idsValue +=eleObject[x].value+",";
			}
		}
	}
	if(idsValue==""){
		alert("请选择");
	}else{
		if(window.confirm("!-- dangerous --!")){
		window.location=delUrl+"?ids="+idsValue;
		}
	
	}
	
}
