/**
 * Created by Administrator on 2014/7/21.
 */


//定义一个默认的树对象
var defaultTreeProperties = {
    fontSize : 12,
    indent : 15,
    height : 20,
    spacing : 5,
    expandLevel : 1,
    animateSpeed : 100,//动画速度,0：无速度
    utlTarger : '_self',
    expandImg :'images/elbow-end-plus-nl.gif',      //展开图片
    collapseImg : 'images/elbow-end-minus-nl.gif',  //收缩图片
    nodeImg : 'images/leaf.gif',                    //叶子图片
    picTopPosistion : 0,//控制图片上下距离，负数上移
    fieldName : {
        id : 'id',
        label : 'label',
        url : 'url',
        action : 'action',
        img : 'img',
        subTree : 'subTree'
    }
}

$.fn.extend(
    {
        tree : function(datas, treeProperties){
            var _treeProperties = treeProperties || defaultTreeProperties;
            function drawNode(nodeList, level, ul){
                var li = $("<li></li>");
                li.css("xxx",'xxx');
                li.append(ul);
            }
        }
    }
);