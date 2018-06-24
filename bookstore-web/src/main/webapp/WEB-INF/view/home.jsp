<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Spring MVC</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="css/monokai_sublime.min.css">
<link rel="stylesheet" type="text/css" href="css/popup.min.css">
<link rel="stylesheet" type="text/css" href="css/screen.css">

<!-- <script type="text/javascript" src="js/common.js"></script> -->
</head>

<body class="home-template">
	<header class="main-header"
		style="background-image: url(image/header.jpg)">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">

					<!-- start logo -->
					<a class="branding"><img src="image/logo.png"
						alt="Ghost 开源博客平台"></a>
					<!-- end logo -->
					<h2 class="text-hide">Ghost
						是一个简洁、强大的写作平台。你只须专注于用文字表达你的想法就好，其余的事情就让 Ghost 来帮你处理吧。</h2>

					<img src="image/header.jpg" alt="Ghost 博客系统" class="hide">
				</div>
			</div>
		</div>
	</header>
	<!-- end header -->

	<!-- start navigation -->
	<nav class="main-navigation">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="navbar-header">
						<span class="nav-toggle-button collapsed" data-toggle="collapse"
							data-target="#main-menu"> <span class="sr-only">Toggle
								navigation </span> <i class="fa fa-bars"></i>
						</span>
					</div>
					<div class="collapse navbar-collapse" id="main-menu">
						<ul class="menu">
							<li class="nav-current" role="presentation"><a
								href="http://www.ghostchina.com/">首页</a></li>
							<li role="presentation"><a
								href="http://wenda.ghostchina.com/">论坛</a></li>
							<li role="presentation"><a
								href="http://www.ghostchina.com/ghost-cheat-sheet/">快捷手册</a></li>
							<li role="presentation"><a
								href="http://docs.ghostchina.com/zh/">中文文档</a></li>
							<li role="presentation"><a
								href="http://www.ghostchina.com/download/">下载</a></li>
							<li role="presentation"><a
								href="http://www.ghostchina.com/about/">关于</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>
	<!-- start site's main content area -->
	<section class="content-wrap">
		<div class="container">
			<div class="row">
				<main class="col-md-8 main-content"> 
				<c:forEach	items="${list}" var="item">
					<article id="111" class="post">
					<div class="post-head">
						<h1 class="post-title">
						<a href="http://www.ghostchina.com/ghost-5-years/">${item.getName()}</a>
						</h1>
						<div class="post-meta">
							<span class="author">作者：<a
								href="http://www.ghostchina.com/author/wangsai/">王赛</a></span> •
							<time class="post-date" datetime="2018年5月17日星期四凌晨3点41分"
								title="2018年5月17日星期四凌晨3点41分">2018年5月17日</time>
						</div>
					</div>
					<div class="post-content">
						<p>${item.getDescription()}</p>
					</div>
					<div class="post-permalink">
						<a href="http://www.ghostchina.com/ghost-5-years/"
							class="btn btn-default">阅读全文</a>
					</div>

					<footer class="post-footer clearfix">
						<div class="pull-left tag-list">
							<i class="fa fa-folder-open-o"></i>

						</div>
						<div class="pull-right share"></div>
					</footer>
				</article>
					</article>
				</c:forEach>
				<article id="111" class="post">

					<div class="post-head">
						<h1 class="post-title">
							<a href="http://www.ghostchina.com/ghost-5-years/">5 年的时间、300
								万美元的营收，这是我们创建 Ghost 的过程中学到的一切</a>
						</h1>
						<div class="post-meta">
							<span class="author">作者：<a
								href="http://www.ghostchina.com/author/wangsai/">王赛</a></span> •
							<time class="post-date" datetime="2018年5月17日星期四凌晨3点41分"
								title="2018年5月17日星期四凌晨3点41分">2018年5月17日</time>
						</div>
					</div>
					<div class="post-content">
						<p>尚未译完，改天再译 原作者：JOHN O'NOLAN, HANNAH WOLFE 上周是 Ghost 从
							Kickstarter 上推广算起的五周年纪念日。
							利用这些里程碑来标记重要时刻并反思迄今为止的旅程总是显得很有趣。在上一个四周年纪念日里，我谈到了营收里程碑</p>
					</div>
					<div class="post-permalink">
						<a href="http://www.ghostchina.com/ghost-5-years/"
							class="btn btn-default">阅读全文</a>
					</div>

					<footer class="post-footer clearfix">
						<div class="pull-left tag-list">
							<i class="fa fa-folder-open-o"></i>

						</div>
						<div class="pull-right share"></div>
					</footer>
				</article>
				<article id="110" class="post">

					<div class="post-head">
						<h1 class="post-title">
							<a
								href="http://www.ghostchina.com/theme-translations-and-blog-localisation/">主题模板和博客支持本地化了！</a>
						</h1>
						<div class="post-meta">
							<span class="author">作者：<a
								href="http://www.ghostchina.com/author/wangsai/">王赛</a></span> •
							<time class="post-date" datetime="2018年1月22日星期一下午5点03分"
								title="2018年1月22日星期一下午5点03分">2018年1月22日</time>
						</div>
					</div>
					<div class="post-content">
						<p>上周我们 发布 了一个新版本，包含了大家期盼已久的功能：主题模板和网站对本地化的支持。
							这个功能完全是由我们的一个贡献者（Juan）开发的，Ghost 基金提供了支持。
							我们已经针对这个功能编写了完整的文档，下面就来介绍一下这个功能是如何工作的： 网站本地化 你可以在 Ghos</p>
					</div>
					<div class="post-permalink">
						<a
							href="http://www.ghostchina.com/theme-translations-and-blog-localisation/"
							class="btn btn-default">阅读全文</a>
					</div>

					<footer class="post-footer clearfix">
						<div class="pull-left tag-list">
							<i class="fa fa-folder-open-o"></i>

						</div>
						<div class="pull-right share"></div>
					</footer>
				</article>


				<nav class="pagination" role="navigation">
					<span class="page-number">第 1 页 ⁄ 共 9 页</span> <a
						class="older-posts" href="http://www.ghostchina.com/page/2/"><i
						class="fa fa-angle-right"></i></a>
				</nav>


				</main>

				<aside class="col-md-4 sidebar">
					<!-- start widget -->
					<!-- end widget -->

					<!-- start tag cloud widget -->
					<div class="widget">
						<h4 class="title">社区</h4>
						<div class="content community">
							<p>QQ群：277327792</p>
							<p>
								<a href="http://wenda.ghostchina.com/" title="Ghost中文网问答社区"
									target="_blank"
									onclick="_hmt.push([&#39;_trackEvent&#39;, &#39;big-button&#39;, &#39;click&#39;, &#39;问答社区&#39;])"><i
									class="fa fa-comments"></i> 问答社区</a>
							</p>
							<p>
								<a href="http://weibo.com/ghostchinacom" title="Ghost中文网官方微博"
									target="_blank"
									onclick="_hmt.push([&#39;_trackEvent&#39;, &#39;big-button&#39;, &#39;click&#39;, &#39;官方微博&#39;])"><i
									class="fa fa-weibo"></i> 官方微博</a>
							</p>
						</div>
					</div>
					<!-- end tag cloud widget -->

					<!-- start widget -->
					<div class="widget">
						<h4 class="title">下载 Ghost</h4>
						<div class="content download">
							<a href="http://www.ghostchina.com/download/"
								class="btn btn-default btn-block"
								onclick="_hmt.push([&#39;_trackEvent&#39;, &#39;big-button&#39;, &#39;click&#39;, &#39;下载Ghost&#39;])">Ghost
								中文版（0.7.4）</a>
						</div>
					</div>
					<!-- end widget -->

					<!-- start tag cloud widget -->
					<div class="widget">
						<h4 class="title">标签云</h4>
						<div class="content tag-cloud">
							<a href="http://www.ghostchina.com/tag/ke-hu-duan/">客户端</a> <a
								href="http://www.ghostchina.com/tag/android/">Android</a> <a
								href="http://www.ghostchina.com/tag/jquery/">jQuery</a> <a
								href="http://www.ghostchina.com/tag/ghost-0-7-ban-ben/">Ghost
								0.7 版本</a> <a href="http://www.ghostchina.com/tag/opensource/">开源</a>
							<a href="http://www.ghostchina.com/tag/zhu-shou-han-shu/">助手函数</a>
							<a href="http://www.ghostchina.com/tag/tag-cloud/">标签云</a> <a
								href="http://www.ghostchina.com/tag/navigation/">导航</a> <a
								href="http://www.ghostchina.com/tag/customize-page/">自定义页面</a> <a
								href="http://www.ghostchina.com/tag/static-page/">静态页面</a> <a
								href="http://www.ghostchina.com/tag/roon-io/">Roon.io</a> <a
								href="http://www.ghostchina.com/tag/configuration/">配置文件</a> <a
								href="http://www.ghostchina.com/tag/upyun/">又拍云存储</a> <a
								href="http://www.ghostchina.com/tag/upload/">上传</a> <a
								href="http://www.ghostchina.com/tag/handlebars/">Handlebars</a>
							<a href="http://www.ghostchina.com/tag/email/">邮件</a> <a
								href="http://www.ghostchina.com/tag/shortcut/">快捷键</a> <a
								href="http://www.ghostchina.com/tag/yong-hu-zhi-nan/">用户指南</a> <a
								href="http://www.ghostchina.com/tag-cloud/">...</a>
						</div>
					</div>
					<!-- end tag cloud widget -->

					<!-- start widget -->
					<!-- end widget -->

					<!-- start widget -->
					<!-- end widget -->
				</aside>

			</div>
		</div>
	</section>


</body>

</html>