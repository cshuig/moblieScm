<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/6/17
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${systemName}</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
            border: 0;
            font-size: 100%;
            font: inherit;
            vertical-align: baseline;
        }
        input{
            background: transparent;
            border:0px;
        }

        /* ------- 删除掉 在谷歌浏览器下 输入框的活动边框(如：文本输入框获取光标后会显示边框)------- */
        *:focus {
            outline: none;
        }

        body {
            margin: 0px;
            border: 0px solid red;
            /** 背景从顶部top开始以这张图片横向重复平铺,并且背景颜色为：226cc5 **/
            background: url("resources/images/login/bg.jpg") left top repeat;
        }
        .contains {
            margin: auto;
            margin-top: 180px;
            width: 524px;
            height: 262px;
            text-align: left;
            font-family: Verdana, Arial;
            font-weight: normal;
            font-size: 12px;
            color: #ffffff;
        }
        form {
            background: url("resources/images/login/form-bg.png") top left no-repeat;
            width: 524px;
            height: 262px;
        }
        .login {
            width: 470px;
            float: left;
            margin-left: 40px;
            margin-top: 33px;
            font-size: 20px;
        }
        .userName-text {
            width: 190px;
            float: left;
            margin-left: 40px;
            margin-top: 40px;
            font-size: 16px;
        }
        .password-text{
            width: 290px;
            float: left;
            margin-left: 0px;
            margin-top: 40px;
            font-size: 16px;
        }

        .userName-field {
            width: 168px;
            height: 38px;
            float:left;
            margin-top: 10px;
            margin-left: 35px;
            background: url("resources/images/login/username-field.png") center left no-repeat;
        }
        .password-field {
            width: 280px;
            height: 38px;
            float:left;
            margin-top: 10px;
            margin-left: 22px;
            background: url("resources/images/login/password-field.png") center left no-repeat;
        }

        .userName-field:hover {
            background: url("resources/images/login/username-field-hover.png") center left no-repeat;
        }
        .password-field:hover {
            background: url("resources/images/login/password-field-hover.png") center left no-repeat;
        }

        input[type="text"], input[type="password"] {
            width: 120px;
            height: 16px;
            margin-top: 10px;
            margin-left: 10px;
            font-family: Verdana, Arial;
            font-size: 16px;
            color: #2d2d2d;
        }

        input[type="checkbox"] {
            position: absolute;
            left: -999px;
        }

        input[type="checkbox"] + label {
            width: 132px;
            height: 24px;
            float: left;
            margin-top: 26px;
            margin-left: 37px;
            padding-left: 28px;
            display: block;
            position: relative;
            line-height: 24px;
            background: url("resources/images/login/checkbox-off.png") top left no-repeat;
        }
        input[type="checkbox"]:checked + label {
            background: url("resources/images/login/checkbox-on.png") top left no-repeat;
        }

        input[type="checkbox"]:checked:hover + label, input[type="checkbox"]:checked:focus + label {
            background: url("resources/images/login/checkbox-on-hover.png") top left no-repeat;
        }

        input[type="checkbox"]:not:checked:hover + label, input[type="checkbox"]:not:checked:focus + label {
            background: url("resources/images/login/checkbox-off-hover.png") top left no-repeat;
        }

        input[type="submit"]{
            width: 95px;
            height: 73px;
            float: left;
            margin-top: 12px;
            margin-left: 2px;
            font-family: Verdana, Arial;
            font-size: 26px;
            color: #ffffff;
            cursor: pointer;
        }

        input[type="submit"]:hover, input[type="submit"]:focus {
            background:url("resources/images/login/go-hover.png")
        }

        #footer {
            margin: auto;
            margin-top: 50px;
            width: 500px;
            height: 30px;
            background: url("resources/images/login/footer-bg.png") bottom center no-repeat;
            text-align: center;
            font-family: "Times New Roman", Times, Georgia;
            font-weight: normal;
            font-size: 16px;
            color: #8d8d8d;
        }

        #footer a {
            text-decoration: none;
            color: #8d8d8d;
        }

        #footer a:hover, #footer a:focus {
            text-decoration: none;
            color: #2d2d2d;
        }
    </style>
</head>
<body>
    <div class="contains">
        <form action="user/index">
            <div class="login">LOGIN</div>
            <div class="userName-text">用户名:</div>
            <div class="password-text">密 码:</div>
            <div class="userName-field">
                <input type="text" name="userName" value="admin"/>
            </div>
            <div class="password-field">
                <input type="password" name="password" value="123"/>
            </div>
            <input type="checkbox" name="remember-me" />
            <label>记住我</label>
            <input type="submit" name="submit" value="GO" />
        </form>
    </div>
    <div id="footer">
        2014-6-19臭水沟著作 >>> <a href="http://www.baidu.com/" target="_blank" title="百度">百度首页</a>
    </div>
</body>
</html>
