<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>

<script type="text/javascript">
	function goNpw(){
		if(checkValue(mem.t_pw,"현재 비밀번호를 입력하세요"))return;
		mem.t_new_pw.focus();
	}
	
	function goNpw_ch(){
		if(checkValue(mem.t_new_pw,"새 비밀번호를 입력하세요"))return;
		mem.t_new_pw_check.focus();
	}
	
	function passwordUpdate(){
		if(checkValue(mem.t_pw,"현재 비밀번호를 입력하세요"))return;
		if(checkValue(mem.t_new_pw,"새 비밀번호를 입력하세요"))return;
		if(checkValue(mem.t_new_pw_check,"비밀번호 확인을 입력하세요"))return;
		
		if(mem.t_new_pw.value != mem.t_new_pw_check.value){
			alert("비밀번호 확인이 일치하지 않습니다");
			mem.t_new_pw_check.focus();
			return;
		}
		
		mem.t_gubun.value="pwUpdate";
		mem.method="post";
		mem.action="Member";
		mem.submit();
	}
</script>
	
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goPage('login')">LOGIN</a></li>
				<li><a href="">ID / PASSWORD</a></li>
				<li><a href="javascript:goPage('join')">CONTACT</a></li>
				<li><a href="javascript:goPage('myInfo')"><span class="fnt"><i class="fas fa-apple-alt"></i></span>MYINFO</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				PASSWORD UPDATE
			</p>
		
			<div class="login">
				<div class="member_boxL">
					<h2>PASSWORD</h2>
					<div class="login_form pwCheck">
						<form name="mem">
							<input type="hidden" name="t_gubun">
							<div class="fl_clear">
								<label for="mbrId">현재비밀번호</label>
								<input name="t_pw" id="mbrId" type="password" onkeypress="if( event.keyCode==13 ){goNpw()}" autofocus>
							</div>
							<div class="fl_clear">
								<label for="scrtNo">새비밀번호</label>
								<input name="t_new_pw" id="scrtNo" type="password" onkeypress="if( event.keyCode==13 ){goNpw_ch()}">
							</div>
							<div class="fl_clear">
								<label for="scrtNo">비밀번호확인</label>
								<input name="t_new_pw_check" id="scrtNo" type="password" onkeypress="if( event.keyCode==13 ){passwordUpdate()}">
							</div>
							<a class="btn_login btn_Blue" href="javascript:passwordUpdate()">변경</a>
						</form>
					</div>
				   
				</div>		
			</div>

		</div>	

<%@ include file = "../common_footer.jsp" %>
	</div>	
</body>
</html>






    




