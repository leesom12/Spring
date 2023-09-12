<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
	
<script type="text/javascript">
	function goJoin(){
		if(checkValue(mem.t_id,"아이디를 입력하세요"))return;
		if(checkValue(mem.t_name,"성명을 입력하세요"))return;
		if(checkValue(mem.t_password,"비밀번호를 입력하세요"))return;
		if(checkValue(mem.t_passwordCheck,"비밀번호 확인을 입력하세요"))return;
		if(checkValue(mem.t_address,"주소를 입력하세요"))return;
		if(checkValue(mem.t_mobile1,"연락처를 입력하세요"))return;
		if(checkValue(mem.t_mobile2,"연락처를 입력하세요"))return;
		if(checkValue(mem.t_mobile3,"연락처를 입력하세요"))return;
		if(checkValue(mem.t_gender,"성별을 선택하세요"))return;
		if(mem.t_CheckValue.value=="" || mem.t_CheckValue.value!=mem.t_id.value){
			alert("아이디 중복검사 하세요");
			return;
		}
		
		mem.method="post";
		mem.t_gubun.value = "memberSave";
		mem.action="Member";
		mem.submit();
	}
	
	function checkId(){
		if(checkValue(mem.t_id,"아이디 입력 후 중복검사 하세요"))return;
		$.ajax({
			type : "POST",
			url : "MemberCheckID",
			data: "t_id="+mem.t_id.value,
			dataType : "text",
			error : function(){
				alert('통신실패!!!!!');
			},
			success : function(data){
				$("#idResult").text(data);
				if(data=="이미 존재하는 아이디입니다"){
					$("#idResult").css("color","red");
				}else{
					$("#idResult").css("color","black");
					mem.t_CheckValue.value = mem.t_id.value;
				}
			}
		});				
	}
</script>
	
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goPage('login')">LOGIN</a></li>
				<li><a href="">ID / PASSWORD</a></li>
				<li><a href="javascript:goPage('join')"><span class="fnt"><i class="fas fa-apple-alt"></i></span> CONTACK</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER JOIN
			</p>
			<form name="mem">
			<input type="hidden" name="t_gubun">
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>
					<input name="t_id" type="text" size="10" id="id" title="id입력하세요">
					<input type="button" onclick="checkId()" value="ID중복검사" class="checkB">
					<span id="idResult"></span>
					<input type="hidden" name="t_CheckValue">
				  </td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td><input name="t_name" type="text" size="8" id="nana"></td>
				</tr>
				<tr>
				  <th>비밀번호</th>
				  <td><input name="t_password" type="text" size="13"></td>
				</tr>
				<tr>
				  <th>비밀번호확인</th>
				  <td><input name="t_passwordCheck" type="text" size="13"></td>
				</tr>
				<tr>
				  <th>지역</th>
				  <td>
					<select name="t_area">
						<option value="서울">서울</option>
						<option value="대전">대전</option>
						<option value="부산">부산</option>
						<option value="대구">대구</option>        
					</select>	  
				  </td>
				</tr>	
				
				<tr>
				  <th>주소</th>
				  <td><input name="t_address" type="text" size="40"></td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>
					<input name="t_mobile1" type="text" size="3"> -
					<input name="t_mobile2" type="text" size="4"> -
					<input name="t_mobile3" type="text" size="4">
				  </td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
					  <input type="radio" value="F" name="t_gender" class="middleCheck" /> 여&nbsp;&nbsp;        
					  <input type="radio" value="M" name="t_gender" class="middleCheck" /> 남        
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
					  <input type="checkbox" value="Y" name="t_hobby_travel" class="middleCheck" /> 여행&nbsp;&nbsp; 
					  <input type="checkbox" value="Y" name="t_hobby_reading" class="middleCheck" /> 독서&nbsp;&nbsp; 
					  <input type="checkbox" value="Y" name="t_hobby_sports" class="middleCheck" /> 운동
				  </td>
				</tr>
			  </tbody>
			</table>
			</form>
			<div class="buttonGroup_center">
				<a href="javascript:goJoin()" class="butt">JOIN</a>
			</div>	
		</div>	

<%@ include file = "../common_footer.jsp" %>

	</div>	
</body>
</html>






