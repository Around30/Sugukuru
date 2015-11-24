/**
 * select内のselectedを変更する
 *
 */
function selectedChange(formSelectId, itemValue){
var objSelect = document.getElementById(formSelectId);
var m = objSelect.length;
var i = 0;
for(i=0;m>i;i++){
if(objSelect.options[i].value == itemValue){
objSelect.options[i].selected = true;
break;
}
}
}