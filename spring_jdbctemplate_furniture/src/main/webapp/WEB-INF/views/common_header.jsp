<%@ page pageEncoding="UTF-8"%>

    <html>
<head>
<link href="css/sub_c.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
    //<![CDATA[
    $(function(){
    	$(".main_menu > li > a").mouseover(function(){
			$(".main_menu li div").hide();
			$(this).next().slideDown(500);
    	});    
    	$(".main_menu").mouseleave(function(){
			$(".main_menu li div").stop().slideUp(500);
		}) 
    });     
    //]]>
</script> 

<script type="text/javascript">
	function goPage(gubun){
		page.t_gubun.value= gubun;
		page.method="post";
		page.action="Member";
		page.submit();
	}
</script>

</head>
<body>
<form name="page">
	<input type="hidden" name="t_gubun">
</form>
	<div id="container">

		<div id="b_top_menu">
			<ul class="top_menu">
				<li><a href="javascript:goPage('join')">Contack</a></li>
				<li><a href="javascript:goPage('login')">LogIn</a></li>
				<li><a href="Home"><i class="fa fa-home"></i>Home</a></li>
			</ul>
		</div>	

		<div id="b_top">
			<ul class="main_menu">
				<li><a href="">Office</a>
					<div>
						<ul>
							<li><a href="">Bells</a></li>
							<li><a href="">Camping</a></li>
							<li><a href="">Embrocation</a></li>
							<li><a href="">Fenders</a></li>
							<li><a href="">Kickstands</a></li>
							<li><a href="">Horns</a></li>
						</ul>
					</div>
				</li>
				<li><a href="">Wooden</a>
					<div>
						<ul>
							<li><a href="">BMX</a></li>
							<li><a href="">Cyclocross</a></li>
							<li><a href="">Forks</a></li>
							<li><a href="">Frames</a></li>
						</ul>
					</div>
				
				</li>
				<li><a href="">Sofa</a>
					<div class="div3">
						<ul>
							<li><a href="">3sub menu 1</a></li>
							<li><a href="">3sub menu 2</a></li>
							<li><a href="">3sub menu 3</a></li>
						</ul>
					</div>				
				</li>
				<li><a href="">kKtchen</a>
					<div class="div4">
						<ul>
							<li><a href="">4sub menu 1</a></li>
							<li><a href="">4sub menu 2</a></li>
							<li><a href="">4sub menu 3</a></li>
							<li><a href="">4sub menu 4</a></li>
							<li><a href="">4sub menu 5</a></li>
						</ul>
					</div>					
				</li>
				<li><a href="">Chiffonier</a>
					<div class="div5">
						<ul>
							<li><a href="">5sub menu 1</a></li>
							<li><a href="">5sub menu 2</a></li>
							<li><a href="">5sub menu 3</a></li>
							<li><a href="">5sub menu 4</a></li>
							<li><a href="">5sub menu 5</a></li>
						</ul>
					</div>					
				</li>
				<li><a href="">Chair</a>
					<div class="div6">
						<ul>
							<li><a href="">6sub menu 1</a></li>
							<li><a href="">6sub menu 2</a></li>
							<li><a href="">6sub menu 3</a></li>
							<li><a href="">6sub menu 4</a></li>
							<li><a href="">6sub menu 5</a></li>
						</ul>
					</div>					
				</li>
				<li><a href="">Notice & News</a>
					<div class="div7">
						<ul>
							<li><a href="notice_list.html">NOTICE</a></li>
							<li><a href="">NEWS</a></li>
							<li><a href="">Q AND A</a></li>
							<li><a href="">FREE BOARD</a></li>
							<li><a href="">ETC</a></li>
						</ul>
					</div>					
				</li>
			</ul>		
		</div>	