/**
 * 
 */

function checkPass() {
	
	var pass1 = document.getElementById('password');
	var pass2 = document.getElementById('cpassword');
	
	var goodColor = "#66cc66";
    var badColor = "#ff6666";
    
    if(pass1.value == pass2.value){
    	pass2.style.backgroundColor = goodColor;
    }else{
    	pass2.style.backgroundColor = badColor;
    }
}