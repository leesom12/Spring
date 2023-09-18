<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
	
<script type="text/javascript">
	function goUpdate(){
		if(checkValue(mem.t_name,"성명을 입력하세요"))return;
		if(checkValue(mem.t_address,"주소를 입력하세요"))return;
		if(checkValue(mem.t_mobile1,"연락처를 입력하세요"))return;
		if(checkValue(mem.t_mobile2,"연락처를 입력하세요"))return;
		if(checkValue(mem.t_mobile3,"연락처를 입력하세요"))return;
		if(checkValue(mem.t_password,"비밀번호를 입력하세요"))return;
		
		checkPassword();
		
		if(mem.checkPW.value=="no"){
			alert("비밀번호가 맞지 않습니다");
			mem.t_password.value="";
			mem.t_password.focus();
			return;
		}
		
		mem.t_gubun.value = "memberUpdate";
		mem.method="post";
		mem.action="Member";
		mem.submit();
	}
	
	
	function checkPassword(){
		$.ajax({
			type : "POST",
			url : "MemberCheckPassword",
			async: false,
			data: "t_id="+mem.t_id.value+"&t_password="+mem.t_password.value,
			dataType : "text",
			error : function(){
				alert('통신실패!!!!!');
			},
			success : function(data){
				mem.checkPW.value=data;
			}
		});				
	}
	
</script>
	
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goPage('login')">LOGIN</a></li>
				<li><a href="">ID / PASSWORD</a></li>
				<li><a href="javascript:goPage('join')">CONTACT</a></li>
				<li><a href="javascript:goPage('myInfo')"><span class="fnt"><i class="fas fa-apple-alt"></i></span> MYINFO</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER UPDATE
			</p>
			<form name="mem">
			<input type="hidden" name="t_gubun">
			<input type="hidden" name="t_id" value="${t_dto.getId()}">
			<input type="hidden" name="checkPW">
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>${t_dto.getId() }</td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td><input name="t_name" type="text" size="8" id="nana" value="${t_dto.getName()}"></td>
				</tr>
				<tr>
				  <th>지역</th>
				  <td>
					<select name="t_area">
						<option value="서울" <c:if test="${t_dto.getArea() eq '서울'}">selected</c:if> >서울</option>
						<option value="대전" <c:if test="${t_dto.getArea() eq '대전'}">selected</c:if> >대전</option>
						<option value="부산" <c:if test="${t_dto.getArea() eq '부산'}">selected</c:if> >부산</option>
						<option value="대구" <c:if test="${t_dto.getArea() eq '대구'}">selected</c:if> >대구</option>        
					</select>	  
				  </td>
				</tr>	
				
				<tr>
				  <th>주소</th>
				  <td><input name="t_address" type="text" size="40" value="${t_dto.getAddress()}"></td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>
					<input name="t_mobile1" type="text" size="3" value="${t_dto.getMobile_1()}"> -
					<input name="t_mobile2" type="text" size="4" value="${t_dto.getMobile_2()}"> -
					<input name="t_mobile3" type="text" size="4" value="${t_dto.getMobile_3()}">
				  </td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
					  <input type="radio" value="F" name="t_gender" class="middleCheck" <c:if test="${t_dto.getGender() eq 'F'}">checked</c:if> /> 여&nbsp;&nbsp;        
					  <input type="radio" value="M" name="t_gender" class="middleCheck" <c:if test="${t_dto.getGender() eq 'M'}">checked</c:if> /> 남        
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
					  <input type="checkbox" value="Y" name="t_hobby_travel" class="middleCheck" <c:if test="${t_dto.getTravel() eq 'Y'}">checked</c:if> /> 여행&nbsp;&nbsp; 
					  <input type="checkbox" value="Y" name="t_hobby_reading" class="middleCheck" <c:if test="${t_dto.getReading() eq 'Y'}">checked</c:if> /> 독서&nbsp;&nbsp; 
					  <input type="checkbox" value="Y" name="t_hobby_sports" class="middleCheck" <c:if test="${t_dto.getSports() eq 'Y'}">checked</c:if> /> 운동
				  </td>
				</tr>
				<tr>
				  <th>비밀번호</th>
				  <td><input name="t_password" type="text" size="13"></td>
				</tr>
			  </tbody>
			</table>
			</form>
			<div class="buttonGroup_center">
				<a href="javascript:goUpdate()" class="butt">UPDATE</a>
				<a href="javascript:history.back()" class="butt">뒤로가기</a>
			</div>	
		</div>	

<%@ include file = "../common_footer.jsp" %>

	</div>	
</body>
</html>






