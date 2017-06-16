<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>布局页</title>
<link href="image/main.css" rel="stylesheet" type="text/css">

<body>
<div id="logo">
	<div id="logo_main">logo</div>
</div>

<div id="menu">
	<div id="user" style="float:left;margin:0 10px;">当前用户：${sessionScope.admin.name}|<a href="">退出</a>
	</div>
	<div id="menu-list"  style="float:right;height:30px;margin:0 20px;">
		<ul style="float:left;margin:0;">
			<li><a href="${pageContext.request.contextPath}/News"> 新闻管理</a></li>
			<li><a href="${pageContext.request.contextPath}/Newsmanage"> 用户管理</a></li>
		</ul>
	</div>
</div>

<div id="content">
	<div id="sidebar">
			
		    

		    <div class="sidesec">
				<div class="sidesec_bt"> <span>热点新闻</span></a></div>
				<hr style="width:264px;margin:0 auto;">
				<div class="sidesec_list">
					<ul>
						 <li>·嫦娥三号探测器在近月点约15千米远月点</li>
						 <li>·"流浪黑洞"或许成为银河系周围的陷阱</li>
						  <li>·最新观测木卫二南极出现喷射水柱</li>
						  <li>·太阳磁极颠倒属正常活动 不会威胁地球</li>
						 <li>·研究称宇宙射线或将影响外星生命演化</li>
					</ul>
				</div>
			</div>
		    <div class="sidesec">
				<div class="sidesec_bt"> <span>最新评论</span></a></div>
				<hr style="width:264px;margin:0 auto;">
				<div class="sidesec_list">
					<ul>
						 <li>·[匿名网友]嫦娥三号探测器在近月点约15千</li>
						 <li>·[小张]"流浪黑洞"或许成为银河系陷阱</li>
						  <li>·[小张]最新观测木卫二南极出现喷射水柱</li>
						  <li>·[匿名网友]太阳磁极颠倒属正常活动 </li>
						 <li>·[匿名网友]宇宙射线或将影响外星生命演化</li>
					</ul>
				</div>
			</div>
    </div>

	
	<div class="blank20"></div>
	<div class="blank10"></div>
</div>

<div id="footer">
 <!--版权-->
	<DIV class="banq">本网站所刊载的信息，不代表本网观点。 使用本网站稿件，务经书面授权。<BR>
未经授权禁止转载、复制及建立镜像，违者将依法追究法律责任。
	</DIV>
</div>


</body></html>

