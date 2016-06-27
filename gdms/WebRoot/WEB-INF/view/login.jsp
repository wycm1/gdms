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
		<link rel="stylesheet" type="text/css" href="./lib/font-awesome/font-awesome.min.css"/>
		<link href="./lib/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
		<link href="./resource/css/common/login.css" rel="stylesheet" type="text/css" />
		<!--自己的样式-->
		<!--[if IE 6]> 
		    <script type="text/javascript" src="./lib/DD_belatedPNG_0.0.8a-min.js" ></script>
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
							<li><a href="common/login.jsp">登录</a></li>
							<li><a href="common/register.jsp">注册</a></li>
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
						<h1>欢迎登录</h1>
					</div>

				</div>
			</div>
		</div>

		<div class="mt-50">
		</div>

		<div class="row cl w">
			<div class="login-content cl">
				
				<div class="col-7">
					<img src="./resource/img/common/login/adv.jpg" width="620" height="360" />
				</div>
				
				<div class="col-1">
				</div>
				<div class="col-3">
					<div class="login-form">

						<div class="panel panel-primary">
							<div class="panel-header">
								<h4 class="text-c">用户登录</h4>
							</div>
							<div class="panel-body">
								<form method="post" class="form form-horizontal responsive" id="login-form" action="">
									<div class="Huialert Huialert-success"><i class="icon-remove"></i>请输入正确信息</div>
									<!--<div class="Huialert Huialert-danger"><i class="icon-remove"></i>危险状态提示</div>-->
									<div class="row cl">
										<label class="form-label col-3">账号：</label>
										<div class="formControls col-9">
              								<input class="input-text" autocomplete="off" name="work_id" placeholder="账号" type="text" size="11">
            							</div>
									</div>
									
									<div class="row cl">
										<label class="form-label col-3">密码：</label>
										<div class="formControls col-9">
              								<input class="input-text" autocomplete="off" name="password" placeholder="密码" type="password" size="22">
            							</div>
									</div>
									
									<!--<div class="row cl">
										<label class="form-label col-3">类别：</label>
										<div class="formControls col-9">
											<span class="select-box">
										      <select class="select" size="1" name="demo1">
										        <option value="0" selected>学生</option>
										        <option value="1">老师</option>
										        <option value="2">系主任</option>
										        <option value="3">校长</option>
										      </select>
										    </span>
            							</div>
									</div>-->
									
									<div class="row cl">
										<a class="f-l pd-5" href="#">忘记密码？</a>
										<a class="f-r pd-5" href="/common/register.jsp">立即注册</a>
									</div>
									
									<div class="row cl text-c">
										<input class="btn btn-primary radius" value="立即登录" type="submit">
									</div>
								</form>
							</div>
						</div>
						<div>
						</div>
					</div>
				</div>
				<div class="col-1">
				</div>
			</div>
		</div>

		<div class="footer">
			<div class="footer-top">
				<div class="footer-top-nav w">
					<ul>
						<li><a>关于我们</a></li>
						<li><a href="#">证书查询</a></li>
						<li><a href="#">诚聘英才</a></li>
						<li><a href="#">主营业务</a></li>
						<li><a href="#">联系方式</a></li>
						<li><a href="#">友情链接</a></li>
						<li><a href="#">网站地图</a></li>
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
	</body>

</html>