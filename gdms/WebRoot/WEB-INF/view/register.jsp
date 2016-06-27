<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>

	<head>
        <base href="<%=basePath%>">
		<meta charset="utf-8">
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
		<title>四川理工学院毕业设计管理系统-登录</title>
		<meta name="keywords" content="关键词,5个左右,单个8汉字以内">
		<meta name="description" content="网站描述，字数尽量空制在80个汉字，160个字符以内！">
		<link rel="Bookmark" href="favicon.ico">
		<link rel="Shortcut Icon" href="favicon.ico" />
		<!--[if lt IE 9]> 
		    <script type="text/javascript" src="lib/html5.js"></script>
		    <script type="text/javascript" src="lib/respond.min.js"></script>
		    <script type="text/javascript" src="lib/PIE_IE678.js"></script>
    	<![endif]-->
		<link href="./lib/h-ui/css/H-ui.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="./lib/font-awesome/font-awesome.min.css" />
		<link href="./lib/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
		<link href="./resource/css/common/regist.css" rel="stylesheet" type="text/css" />
		<link rel='stylesheet' href='./lib/nprogress/nprogress.css' />
		<!--自己的样式-->
		<!--[if IE 6]> 
		    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
		    <script>DD_belatedPNG.fix('.pngfix,.icon');</script> 
	    <![endif]-->
	</head>

	<body>
		<div class="header">
			<div class="header-top">
				<div class="w">
					<span class="f-l">
						<ul class="nav-left">
							<li><a>网站首页</a></li>
							<li><a>加入收藏</a></li>
						</ul>
					</span>
					<span class="f-r">
						<ul class="nav-right">
							<li>欢迎	访问四川理工学院毕业设计管理系统！</li>
							<li><a href="login.html">登录</a></li>
							<li><a href="regist.html">注册</a></li>
						</ul>
					</span>
				</div>
			</div>
			<div class="header-wrap">
				<div class="w">
					<div class="logo f-l">
						<a href="#"><img src="./resource/img/common/login/sclglogo.png" height="110" /></a>
					</div>
					<div class="wrap-tit f-l ml-50">
						<h1>欢迎注册</h1>
					</div>

				</div>
			</div>
		</div>

		<div class="mt-50"></div>
		<div class="row cl w">

			<div class="docs-tip">
				<form action="" method="post" class="form form-horizontal responsive" id="regist-form">
					<legend>学生注册 <a href="common/teacherregister.jsp">教师注册</a></legend>
					<div class="row cl">
						<label class="form-label col-3">学号：</label>
						<div class="formControls col-5">
							<input type="text" class="input-text" autocomplete="off" placeholder="学号" name="workId" id="username" datatype="n" nullmsg="学号不能为空！">
						</div>
						<div class="col-4">

						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-3">教务系统密码：</label>
						<div class="formControls col-5">
							<input type="password" class="input-text" autocomplete="off" placeholder="密码" name="password" id="password" datatype="*" nullmsg="请输入密码！">
						</div>
						<div class="col-4">

						</div>
					</div>
					
					
					<!-- <div class="row cl">
						<label class="form-label col-3">用户名：</label>
						<div class="formControls col-5">
							<input type="text" class="input-text" autocomplete="off" placeholder="4~16个字符，字母/中文/数字/下划线" name="username" id="username" datatype="*4-16" nullmsg="用户名不能为空！">
						</div>
						<div class="col-4">

						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-3">密码：</label>
						<div class="formControls col-5">
							<input type="password" class="input-text" autocomplete="off" placeholder="密码" name="password" id="password" datatype="*6-18" nullmsg="请输入密码！">
						</div>
						<div class="col-4">

						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-3">密码验证：</label>
						<div class="formControls col-5">
							<input type="password" class="input-text" autocomplete="off" placeholder="再输入一次密码" name="repassword" id="password2" recheck="user.passwd" datatype="*6-18" nullmsg="请再输入一次密码！" errormsg="您两次输入的密码不一致！">
						</div>
						<div class="col-4">

						</div>
					</div> -->
					<div class="row cl">
						<label class="form-label col-3">专业：</label>
						<div class="formControls col-5"> 
						<span class="select-box">
			              <select class="select" autocomplete="off" size="1" name="major" datatype="*" nullmsg="请选择专业！">
			                <option value="" selected>请选择专业</option>
			                <option value="软件工程">软件工程</option>
			                <option value="网络工程">网络工程</option>
			                <option value="计算机科学与技术">计算机科学与技术</option>
                            <option value="电子商务">电子商务</option>
                            
			              </select>
              			</span>
                        </div> 
                        <input type="hidden" name="type" value="8"/>
                        <div class="row cl">
						<label class="form-label col-3">学生真实姓名：</label>
						<div class="formControls col-5">
							<input type="text" class="input-text" autocomplete="off" placeholder="4~16个字符，字母/中文/数字/下划线" name="name" id="username" datatype="*2-10" nullmsg="真实姓名不能为空！">
						</div>
						<div class="col-4">

						</div>
						</div>
                         <div class="row cl">
						<label class="form-label col-3">学生介绍：</label>
						<div class="formControls col-5">
							<input type="text" class="input-text" autocomplete="off" placeholder="介绍" name="introduction" id="username" datatype="*2-16" nullmsg="不能为空！">
						</div>
						<div class="col-4">

						</div>
						</div>
                        <div class="row cl">
						<label class="form-label col-3">学生年级：</label>
						<div class="formControls col-5">
							<input type="text" class="input-text" autocomplete="off" placeholder="" name="grade" id="username" datatype="*2-16" nullmsg="不能为空！">
						</div>
						<div class="col-4">

						</div>
						</div>
                        <div class="row cl">
						<label class="form-label col-3"><img alt="vertifyCode" src="validatecode"></label>
						<div class="formControls col-5">
							<input type="text" class="input-text" autocomplete="off" placeholder="4~16个字符，字母/中文/数字/下划线" name="validateCode" id="username" datatype="*2-16" nullmsg="验证码为空！">
						</div>
						<div class="col-4">

						</div>
						</div>
                  
					</div>
					
					
					<div class="row cl">
						<div class="col-10 col-offset-3">
							<input class="btn btn-primary" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
						</div>
					</div>
				</form>

			</div>

		</div>

		<div class="mt-50"></div>

		<div class="footer">
			<div class="footer-top">
				<div class="footer-top-nav w">
					<ul>
						<li><a>关于我们</a></li>
						<span class="pipe">|</span>
						<li><a href="zscx.html">证书查询</a></li>
						<span class="pipe">|</span>
						<li><a href="cpyc.html">诚聘英才</a></li>
						<span class="pipe">|</span>
						<li><a href="zyyw.html">主营业务</a></li>
						<span class="pipe">|</span>
						<li><a href="lxfs.html">联系方式</a></li>
						<span class="pipe">|</span>
						<li><a href="link.html">友情链接</a></li>
						<span class="pipe">|</span>
						<li><a href="map.html">网站地图</a></li>
					</ul>

				</div>
			</div>
			<div class="footer-wrap">
				<div class="copyright w">
					<p style="color:#333;padding:3px 0;">地址：四川省自贡市汇兴路学苑街180号</p>
					<p style="color:#333;padding:3px 0;">邮编：100000　电话：010-12345678</p>
					<p style="color:#333;padding:3px 0;">All Right Reserved By 四川理工学院毕业设计管理系统 京ICP备13002607号 京公网安备888888881</p>
				</div>
			</div>
		</div>

		<script type="text/javascript" src="./lib/jquery.min.js"></script>
		<script type="text/javascript" src="./lib/h-ui/js/H-ui.js"></script>
		<script src='./lib/nprogress/nprogress.js'></script>
		<script src="./lib/Validform_v5.3.2.js" type="text/javascript" charset="utf-8"></script>
		<script>
			$('body').show();
			   	$(function(){
		            NProgress.start();
		            $(document).ready(function(){
		            	NProgress.done();
		            });
	        	});
	        	$(function(){$(window).on("scroll",$backToTopFun);$backToTopFun();});
		</script>

		<script type="text/javascript">
			$(function(){
				$("#regist-form").Validform({
					tiptype:2,
					usePlugin:{
						datepicker:{},//日期控件校验;
						passwordstrength:{
							minLen:6,//设置密码长度最小值，默认为0;
							maxLen:18,//设置密码长度最大值，默认为30;
							trigger:function(obj,error){
								//该表单元素的keyup和blur事件会触发该函数的执行;
								//obj:当前表单元素jquery对象;
								//error:所设密码是否符合验证要求，验证不能通过error为true，验证通过则为false;					
								//console.log(error);
								if(error){
									obj.parent().find(".Validform_checktip").show();
									obj.parent().find(".passwordStrength").hide();
								}else{
									obj.parent().find(".passwordStrength").show();	
								}
							}
						}
					}
				});
			});
		</script>
	</body>

</html>