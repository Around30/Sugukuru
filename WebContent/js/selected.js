/**
 * select内のselectedを変更する
 *
 */
function checkSelect(obj,val){
  	for(var i=0;i<obj.length;i++){
  		if(obj[i].value==val){
 			 obj[i].selected=true;
 		 break;
 		 }
  	}
}