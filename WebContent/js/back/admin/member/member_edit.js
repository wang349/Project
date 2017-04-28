window.onload=function(){
	listener("birthday","click",laydate);
	listener("mid","blur",validateMid);
	listener("name","blur",validateName);
	listener("sal","blur",validateSal);
	listener("memberform","submit",function(e){
		if(validateMid() & validateName() & validateBirthday() & validateSal()){
			this.submit();
		}else{
			e.preventDefault();
		}
	});
}
function validateMid(){
	return validateEmpty("mid");
}
function validateName(){
	return validateEmpty("name");
}
function validateBirthday(){
	return validateRegex("birthday",/^\d{4}-\d{2}-\d{2}$/);
}
function validateSal(){
	return validateRegex("sal",/^\d+(\.\d{1,2})?$/);
}