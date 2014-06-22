/**
 * Created by Administrator on 2014/6/21.
 */

/**
 * 获取指定节点的位置偏移量：left、top
 * @param obj   指定的节点对象,可以是jquery对象,也可以是DOM对象
 * @returns {{left: *, top: Window}}
 */
var getAbsolutPosition = function(obj){
    obj = $(obj);//将一个DOM对象转换为jquery对象，如果本身是jquery对象，则不做转换处理
    return {
        left : obj.offset().left,
        top  : obj.offset().top
    };
}
/**
 * 扩展字符串String，为其添加 tirm 方法
 * @returns {string}
 */
String.prototype.trim = function(){
    return this.replace("/(^\s*) | (\s*$)/g","");
}


var converFormToObj = function(obj){
    obj = $(obj)[0];
    var data = [];
    for(var i=0; i<obj.elements.length; i++){
        var eleObj = obj.elements[i];
        if(eleObj.type == 'radio'){
            if(eleObj.selected){
                data[eleObj.name] = eleObj.value.trim();
            }
        }else if(eleObj.type == 'checkbox'){
            if(data[eleObj.name] == undefined){
                data[eleObj.name] = [];
                if(eleObj.checked){
                    data[eleObj.name].push(eleObj.value.trim());
                }
            }else{
                data[eleObj.name].push(eleObj.value.trim());
            }
        }else{
            data[eleObj.name] = eleObj.value.trim();
        }
    }
    return data;
}
